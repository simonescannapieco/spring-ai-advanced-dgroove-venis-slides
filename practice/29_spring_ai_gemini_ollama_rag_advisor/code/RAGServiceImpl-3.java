        ...
        return new Answer(this.geminiChatClient.prompt()
            .advisors(List.of(new SimpleLoggerAdvisor(), geminiRetrievalAugmentationAdvisor))
            /*
             * The geminiRetrievalAugmentationAdvisor takes also care to create
             * a dedicated system prompt to handle the RAG strategy!
             * 
             * .system(s -> s.text(this.ragDataSystemEngPrompt)
             * .params(Map.of("documenti", similarDocsString)))
             */
            .user(request.body().question())
            /*
             * The template rendered is now useless, since the system prompt is
             * automatically created!
             *
             * .templateRenderer(StTemplateRenderer.builder().startDelimiterToken('<')
             * .endDelimiterToken('>')
             * .build())
             */
            .call()
            .content());
    }
    ...

}