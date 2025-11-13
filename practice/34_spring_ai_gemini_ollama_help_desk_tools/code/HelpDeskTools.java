package it.venis.ai.spring.demo.tools;

...

@Component
@RequiredArgsConstructor
public class HelpDeskTools {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelpDeskTools.class);

    private final HelpDeskTicketService service;

    @Tool(name = "createTicket", 
          description = "Genera un nuovo ticket di assistenza.", 
          returnDirect = true)
    String createTicket(
        @ToolParam(description = "Il problema segnalato dall'utente.") TicketRequest ticketRequest, 
                                                                       ToolContext toolContext) {

        String username = (String) toolContext.getContext().get("username");
        LOGGER.info("Creazione ticket di assistenza per utente {} con dettagli {}", username, ticketRequest);
        HelpDeskTicket savedTicket = service.createTicket(ticketRequest,username);
        LOGGER.info("Ticket creato con successo. Ticket ID: {}, Username: {}", 
                    savedTicket.getId(), 
                    savedTicket.getUsername()
                   );
        return "Ticket #" + savedTicket.getId() + " creato con successo per utente " + savedTicket.getUsername();
    
    }

    ...