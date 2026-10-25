import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    public void add_task(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("task cannot be null");
        }
        String task_id = task.get_task_id();
        if (tasks.containsKey(task_id)) {
            throw new IllegalArgumentException("task_id must be unique");
        }
        tasks.put(task_id, task);
    }

    public void delete_task(String task_id) {
        if (task_id == null) {
            throw new IllegalArgumentException("task_id cannot be null");
        }
        if (!tasks.containsKey(task_id)) {
            throw new IllegalArgumentException("task_id not found");
        }
        tasks.remove(task_id);
    }

    public void update_name(String task_id, String name) {
        Task task = get_existing_task(task_id);
        task.set_name(name);
    }

    public void update_description(String task_id, String description) {
        Task task = get_existing_task(task_id);
        task.set_description(description);
    }

    public Task get_task(String task_id) {
        if (task_id == null) {
            throw new IllegalArgumentException("task_id cannot be null");
        }
        return tasks.get(task_id);
    }

    private Task get_existing_task(String task_id) {
        if (task_id == null) {
            throw new IllegalArgumentException("task_id cannot be null");
        }
        Task task = tasks.get(task_id);
        if (task == null) {
            throw new IllegalArgumentException("task_id not found");
        }
        return task;
    }
}