public class EmailAlertListener implements TaskListener {

    private String email;

    public EmailAlertListener(String email) {
        this.email = email;
    }

    @Override
    public void update(Task task, String message) {
        System.out.println("Send email to " + email +
                " | Task: " + task.getTitle() +
                " | " + message);
    }

}