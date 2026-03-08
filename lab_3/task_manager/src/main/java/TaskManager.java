import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<TaskListener> listeners = new ArrayList<>();

    public void subscribe(TaskListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(TaskListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(Task task, String message) {
        for (TaskListener listener : listeners) {
            listener.update(task, message);
        }
    }

    public void updateTask(Task task, String newStatus) {
        task.setStatus(newStatus);
        notifyListeners(task, "Task status changed to: " + newStatus);
    }

}