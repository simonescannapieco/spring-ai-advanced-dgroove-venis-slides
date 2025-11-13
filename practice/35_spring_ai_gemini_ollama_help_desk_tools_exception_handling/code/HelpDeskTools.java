package it.venis.ai.spring.demo.tools;

...

@Component
@RequiredArgsConstructor
public class HelpDeskTools {

    ...

    @Tool(description = "Recupera lo stato dei ticket di assistenza a partire da uno specifico username.")
    List<HelpDeskTicket> getTicketStatus(ToolContext toolContext) {

        String username = (String) toolContext.getContext().get("username");
        LOGGER.info("Recupero ticket per utente: {}", username);
        List<HelpDeskTicket> tickets =  service.getTicketsByUsername(username);
        LOGGER.info("Trovati {} ticket di assistenza per utente {}", tickets.size(), username);
        throw new RuntimeException("Errore durtante il fetch dei ticket");
        //return tickets;
    
    }

}