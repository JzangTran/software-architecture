public class EmailAlertsListener implements EventListeners{
    @Override
    public void update(String fileName) {
        System.out.println("Send " + fileName + " to email");
    }
}
