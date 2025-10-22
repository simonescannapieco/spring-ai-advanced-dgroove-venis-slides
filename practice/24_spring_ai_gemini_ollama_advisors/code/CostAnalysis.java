       ...

        /*
         * Google Gemini
         */
        COMMERCIAL_LLM_PRICING.put("gemini-2.5-pro", new ModelPricing(1.25f, 10.0f));
        COMMERCIAL_LLM_PRICING.put("gemini-2.5-flash", new ModelPricing(0.3f, 2.5f));
        COMMERCIAL_LLM_PRICING.put("gemini-2.5-flash-lite", new ModelPricing(0.1f, 0.4f));
    }

    @Override
    public String getName() {
        return "OllamaCostSavingsAdvisor";
    }

    @Override
    public int getOrder() {
        return ORDER_ID;
    }

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        /*
         * Return directly the response object returned by the LLM, but first
         * we extract some metadata and log the required information.
         */
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);

        ChatResponse chatResponse = chatClientResponse.chatResponse();

        if (chatResponse.getMetadata() != null) {
            /*
             * Extract the usage metadata from the response.
             */
            Usage callUsage = chatResponse.getMetadata().getUsage();

            CostAnalysis analysis = new CostAnalysis();

            for (Map.Entry<String, ModelPricing> entry : COMMERCIAL_LLM_PRICING.entrySet()) {
                String model = entry.getKey();
                ModelPricing pricing = entry.getValue();

                Float inputCost = (callUsage.getPromptTokens().floatValue() / 1000000) * pricing.inputPrice();
                Float outputCost = (callUsage.getCompletionTokens().floatValue() / 1000000) * pricing.outputPrice();
                Float totalCost = inputCost + outputCost;

                analysis.costByModel.put(model, totalCost);

            }

            logger.info("╔══════════════════════════════════════════════════════════════╗");
            logger.info("║               OLLAMA TOKEN USAGE & COST SAVINGS              ║");
            logger.info("╠══════════════════════════════════════════════════════════════╣");
            logger.info(" Richiesta corrente:                                          ");
            logger.info(String.format("   >>> Token di input:     %03d tokens", callUsage.getPromptTokens()));
            logger.info(String.format("   >>> Token di output:    %03d tokens", callUsage.getCompletionTokens()));
            logger.info(String.format("   >>> Token totali:       %03d tokens", callUsage.getTotalTokens()));
            logger.info("╠══════════════════════════════════════════════════════════════╣");
            logger.info(" Confronto costi (se avessi usato servizi a pagamento):       ");

            /*
             * Order by decreasing costs
             */

            analysis.costByModel.entrySet().stream()
                    .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
                    .forEach(entry -> {
                        logger.info(String.format("   >>> %-25s: %.6f USD", entry.getKey(), entry.getValue()));
                    });

            logger.info("╚══════════════════════════════════════════════════════════════╝");
        }

        return chatClientResponse;

    }

    private static class CostAnalysis {
        Map<String, Float> costByModel = new HashMap<>();
    }

}
