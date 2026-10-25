public class Task {
    private final String task_id;
    private String name;
    private String description;

    public Task(String task_id, String name, String description) {
        validate_task_id(task_id);
        validate_name(name);
        validate_description(description);
        this.task_id = task_id;
        this.name = name;
        this.description = description;
    }

    public String get_task_id() {
        return task_id;
    }

    public String get_name() {
        return name;
    }

    public String get_description() {
        return description;
    }

    public void set_name(String name) {
        validate_name(name);
        this.name = name;
    }

    public void set_description(String description) {
        validate_description(description);
        this.description = description;
    }

    private void validate_task_id(String task_id) {
        if (task_id == null) {
            throw new IllegalArgumentException("task_id cannot be null");
        }
        if (task_id.length() > 10) {
            throw new IllegalArgumentException("task_id cannot be longer than 10 characters");
        }
    }

    private void validate_name(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("name cannot be longer than 20 characters");
        }
    }

    private void validate_description(String description) {
        if (description == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("description cannot be longer than 50 characters");
        }
    }
}
