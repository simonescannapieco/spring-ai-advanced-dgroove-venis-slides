@Component
public class TimeTools {
    @Tool(name="getCurrentLocalTime", description = "Ottieni l'ora corrente nel fuso orario dell'utente")
    String getCurrentLocalTime() { }

    @Tool(name = "getCurrentTime", description = "Ottieni l'ora corrente nel fuso orario specificato.")
    public String getCurrentTime(@ToolParam(
        description = "Valore che rappresenta il fuso orario") String timeZone) { }
}