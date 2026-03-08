public class Member {

    private String name;
    private TaskManager taskManager;

    public Member(String name, TaskManager taskManager) {
        this.name = name;
        this.taskManager = taskManager;
    }

    public void updateTask(Task task, String status) {
        System.out.println(name + " updated task: " + task.getTitle());
        taskManager.updateTask(task, status);
    }

}