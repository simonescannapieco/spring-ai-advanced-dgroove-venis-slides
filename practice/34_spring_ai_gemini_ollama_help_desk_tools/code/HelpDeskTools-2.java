
    ...
    
    @Tool(description = "Recupera lo stato dei ticket di assistenza a partire da uno specifico username.")
    List<HelpDeskTicket> getTicketStatus(ToolContext toolContext) {

        String username = (String) toolContext.getContext().get("username");
        LOGGER.info("Recupero ticket per utente: {}", username);
        List<HelpDeskTicket> tickets =  service.getTicketsByUsername(username);
        LOGGER.info("Trovati {} ticket di assistenza per utente {}", tickets.size(), username);
        return tickets;
    
    }

}