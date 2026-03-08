public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        EmailAlertListener email1 = new EmailAlertListener("dev1@company.com");
        EmailAlertListener email2 = new EmailAlertListener("dev2@company.com");

        manager.subscribe(email1);
        manager.subscribe(email2);

        Task task = new Task("Implement Observer Pattern", "OPEN");

        Member alice = new Member("Alice", manager);

        alice.updateTask(task, "IN_PROGRESS");

    }
}