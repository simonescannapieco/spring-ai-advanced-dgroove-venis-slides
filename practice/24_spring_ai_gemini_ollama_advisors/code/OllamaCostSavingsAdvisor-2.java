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

        ...