public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        LoggingListener logger = new LoggingListener();

        editor.events.subscribe("open", logger);

        EmailAlertsListener emailAlert = new EmailAlertsListener();

        editor.events.subscribe("save", emailAlert);

        editor.openFile();
        editor.saveFile();
    }
}
