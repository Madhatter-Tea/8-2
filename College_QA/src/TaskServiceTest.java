import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskServiceTest {
    private TaskService service;
    private Task sample_task;

    @BeforeEach
    public void set_up() {
        service = new TaskService();
        sample_task = new Task("maxxor_001", "Maxxor", "OverWorld hero and brave leader");
    }

    @Test
    public void test_add_task_succeeds() {
        service.add_task(sample_task);
        assertNotNull(service.get_task("maxxor_001"));
        assertEquals("Maxxor", service.get_task("maxxor_001").get_name());
    }

    @Test
    public void test_add_multiple_unique_tasks() {
        service.add_task(new Task("maxxor_001", "Maxxor", "OverWorld hero and brave leader"));
        service.add_task(new Task("chaor_002", "Chaor", "UnderWorld warlord of fire"));
        service.add_task(new Task("najarin03", "Najarin", "OverWorld sage and scholar"));
        assertNotNull(service.get_task("maxxor_001"));
        assertNotNull(service.get_task("chaor_002"));
        assertNotNull(service.get_task("najarin03"));
    }

    @Test
    public void test_add_duplicate_task_id_throws() {
        service.add_task(sample_task);
        Task duplicate = new Task("maxxor_001", "Chaor", "UnderWorld warlord of fire");
        assertThrows(IllegalArgumentException.class, () -> {
            service.add_task(duplicate);
        });
    }

    @Test
    public void test_add_null_task_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.add_task(null);
        });
    }

    @Test
    public void test_delete_task_succeeds() {
        service.add_task(sample_task);
        service.delete_task("maxxor_001");
        assertNull(service.get_task("maxxor_001"));
    }

    @Test
    public void test_delete_nonexistent_task_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.delete_task("chaor_002");
        });
    }

    @Test
    public void test_delete_null_task_id_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.delete_task(null);
        });
    }

    @Test
    public void test_update_name_succeeds() {
        service.add_task(sample_task);
        service.update_name("maxxor_001", "Heptadd");
        assertEquals("Heptadd", service.get_task("maxxor_001").get_name());
    }

    @Test
    public void test_update_name_nonexistent_task_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.update_name("chaor_002", "Takinom");
        });
    }

    @Test
    public void test_update_name_null_id_throws() {
        service.add_task(sample_task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.update_name(null, "Takinom");
        });
    }

    @Test
    public void test_update_name_invalid_value_throws() {
        service.add_task(sample_task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.update_name("maxxor_001", null);
        });
    }

    @Test
    public void test_update_description_succeeds() {
        service.add_task(sample_task);
        service.update_description("maxxor_001", "Mipedian muge of stone");
        assertEquals("Mipedian muge of stone", service.get_task("maxxor_001").get_description());
    }

    @Test
    public void test_update_description_nonexistent_task_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.update_description("chaor_002", "Danian insectoid");
        });
    }

    @Test
    public void test_update_description_null_id_throws() {
        service.add_task(sample_task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.update_description(null, "Danian insectoid");
        });
    }

    @Test
    public void test_update_description_invalid_value_throws() {
        service.add_task(sample_task);
        assertThrows(IllegalArgumentException.class, () -> {
            service.update_description("maxxor_001", null);
        });
    }
}