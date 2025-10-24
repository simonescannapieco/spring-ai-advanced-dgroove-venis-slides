public interface BaseChatMemoryAdvisor extends BaseAdvisor {
    /**
     * Retrieve the conversation ID from the given context or return the default conversation ID when not found.
     */
    default String getConversationId(Map<String, Object> context, String defaultConversationId) {
        Assert.notNull(context, "context cannot be null");
        Assert.noNullElements(context.keySet().toArray(), "context cannot contain null keys");
        Assert.hasText(defaultConversationId, "defaultConversationId cannot be null or empty");
        return context.containsKey(ChatMemory.CONVERSATION_ID) ? context.get(ChatMemory.CONVERSATION_ID).toString()
                : defaultConversationId;
    }

}