public class LoggingListener implements EventListeners{
    @Override
    public void update(String fileName) {
        System.out.println("Someone handle " + fileName);
    }
}
