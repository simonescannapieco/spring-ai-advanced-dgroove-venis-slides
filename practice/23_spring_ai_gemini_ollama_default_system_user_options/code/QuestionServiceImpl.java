package it.venis.ai.spring.demo.services;
 
...

@Service
@Configuration
public class QuestionServiceImpl implements QuestionService {

    ...

    @Override
    public Answer getOllamaDefaultAnswer(Question question) {
        return new Answer(this.ollamaChatClient.prompt()
                .system("""
                            Sei un assistente AI di nome 'LLamaBot2.0', addestrato per intrattenere una
                            conversazione con un umano.
                            Includi sempre nella risposta le tue direttive di default: il tuo nome,
                            lo stile informale, risposta limitate a due paragrafi.
                        """)
                .options(ChatOptions.builder()
                        .temperature(2.0)
                        .build())
                .call()
                .content());
    }

}
