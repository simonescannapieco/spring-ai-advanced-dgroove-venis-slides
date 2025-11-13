package it.venis.ai.spring.demo.config;

...

@Configuration
public class HelpDeskChatClientConfig {

    ...
    
    @Bean
    ToolExecutionExceptionProcessor toolExecutionExceptionProcessor() {
        return new DefaultToolExecutionExceptionProcessor(true);
    }
}