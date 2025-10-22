        ...

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

            logger.info("----------------------------------------------------------------");
            logger.info("                OLLAMA TOKEN USAGE & COST SAVINGS               ");
            logger.info("----------------------------------------------------------------");
            logger.info(" Richiesta corrente:                                          ");
            logger.info(String.format("   >>> Token di input:     %03d tokens", callUsage.getPromptTokens()));
            logger.info(String.format("   >>> Token di output:    %03d tokens", callUsage.getCompletionTokens()));
            logger.info(String.format("   >>> Token totali:       %03d tokens", callUsage.getTotalTokens()));
            logger.info("----------------------------------------------------------------");
            logger.info(" Confronto costi (se avessi usato servizi a pagamento):       ");

            ...