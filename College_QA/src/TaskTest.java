import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TaskTest {
    private String valid_task_id;
    private String valid_name;
    private String valid_description;

    @BeforeEach
    public void set_up() {
        valid_task_id = "maxxor_001";
        valid_name = "Maxxor";
        valid_description = "OverWorld hero and brave leader";
    }

    @Test
    public void test_task_creates_with_valid_fields() {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        assertEquals(valid_task_id, task.get_task_id());
        assertEquals(valid_name, task.get_name());
        assertEquals(valid_description, task.get_description());
    }

    @Test
    public void test_task_id_at_max_length_is_valid() {
        String ten_char_id = "chaor_0001";
        Task task = new Task(ten_char_id, valid_name, valid_description);
        assertEquals(ten_char_id, task.get_task_id());
    }

    @Test
    public void test_task_id_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, valid_name, valid_description);
        });
    }

    @Test
    public void test_task_id_too_long_throws() {
        String long_id = "chaor_overlord_id";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(long_id, valid_name, valid_description);
        });
    }

    @Test
    public void test_name_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(valid_task_id, null, valid_description);
        });
    }

    @Test
    public void test_name_too_long_throws() {
        String long_name = "Najarin the Great Sage of the OverWorld";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(valid_task_id, long_name, valid_description);
        });
    }

    @Test
    public void test_description_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(valid_task_id, valid_name, null);
        });
    }

    @Test
    public void test_description_too_long_throws() {
        String long_description = "Chaor is the feared ruler of the UnderWorld who commands vast armies";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(valid_task_id, valid_name, long_description);
        });
    }

    @Test
    public void test_set_name_updates_name() {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        task.set_name("Heptadd");
        assertEquals("Heptadd", task.get_name());
    }

    @Test
    public void test_set_name_null_throws() {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        assertThrows(IllegalArgumentException.class, () -> {
            task.set_name(null);
        });
    }

    @Test
    public void test_set_name_too_long_throws() {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        assertThrows(IllegalArgumentException.class, () -> {
            task.set_name("Tangath Toborn the Mighty OverWorld Lion");
        });
    }

    @Test
    public void test_set_description_updates_description() {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        task.set_description("UnderWorld warlord of great power");
        assertEquals("UnderWorld warlord of great power", task.get_description());
    }

    @Test
    public void test_set_description_null_throws() {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        assertThrows(IllegalArgumentException.class, () -> {
            task.set_description(null);
        });
    }

    @Test
    public void test_set_description_too_long_throws() {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        assertThrows(IllegalArgumentException.class, () -> {
            task.set_description("descriptiontoo long");
        });
    }

    @Test
    public void test_task_id_is_not_updatable() throws NoSuchFieldException {
        Task task = new Task(valid_task_id, valid_name, valid_description);
        Field task_id_field = Task.class.getDeclaredField("task_id");
        int modifiers = task_id_field.getModifiers();
        assertTrue(Modifier.isFinal(modifiers), "task_id should not be updatable");
        assertEquals(valid_task_id, task.get_task_id());
    }
}