import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    private Contact new_contact(String id) {
        return new Contact(id, "Maxxor", "Overworld", "1313131337", "13 Adder ST");
    }

    @Test
    public void test_add_contact_stores_contact() {
        Contact c = new_contact("C001");
        service.add_contact(c);
        assertNotNull(service.get_contact("C001"));
        assertEquals("Maxxor", service.get_contact("C001").get_first_name());
    }

    @Test
    public void test_add_contact_duplicate_id_throws() {
        service.add_contact(new_contact("C001"));
        assertThrows(IllegalArgumentException.class, () -> {
            service.add_contact(new Contact("C001", "Intress", "OW", "9876543210", "13 Addr DR"));
        });
    }

    @Test
    public void test_add_null_contact_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.add_contact(null));
    }

    @Test
    public void test_delete_contact_removes_contact() {
        service.add_contact(new_contact("C001"));
        service.delete_contact("C001");
        assertNull(service.get_contact("C001"));
    }

    @Test
    public void test_delete_contact_not_found_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.delete_contact("NOPE"));
    }

    @Test
    public void test_delete_contact_null_id_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.delete_contact(null));
    }

    @Test
    public void test_update_first_name_changes_value() {
        service.add_contact(new_contact("C001"));
        service.update_first_name("C001", "Intress");
        assertEquals("Intress", service.get_contact("C001").get_first_name());
    }

    @Test
    public void test_update_first_name_not_found_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.update_first_name("NOPE", "Intress"));
    }

    @Test
    public void test_update_first_name_invalid_value_throws() {
        service.add_contact(new_contact("C001"));
        assertThrows(IllegalArgumentException.class, () -> service.update_first_name("C001", null));
    }

    @Test
    public void test_update_last_name_changes_value() {
        service.add_contact(new_contact("C001"));
        service.update_last_name("C001", "OW");
        assertEquals("OW", service.get_contact("C001").get_last_name());
    }

    @Test
    public void test_update_last_name_not_found_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.update_last_name("NOPE", "OW"));
    }

    @Test
    public void test_update_last_name_invalid_value_throws() {
        service.add_contact(new_contact("C001"));
        assertThrows(IllegalArgumentException.class, () -> service.update_last_name("C001", "Chaor"));
    }

    @Test
    public void test_update_phone_changes_value() {
        service.add_contact(new_contact("C001"));
        service.update_phone("C001", "9876543210");
        assertEquals("9876543210", service.get_contact("C001").get_phone());
    }

    @Test
    public void test_update_phone_not_found_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.update_phone("NOPE", "9876543210"));
    }

    @Test
    public void test_update_phone_invalid_value_throws() {
        service.add_contact(new_contact("C001"));
        assertThrows(IllegalArgumentException.class, () -> service.update_phone("C001", "12345"));
    }

    @Test
    public void test_update_address_changes_value() {
        service.add_contact(new_contact("C001"));
        service.update_address("C001", "13 Addr DR");
        assertEquals("13 Addr DR", service.get_contact("C001").get_address());
    }

    @Test
    public void test_update_address_not_found_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.update_address("NOPE", "13 Addr DR"));
    }

    @Test
    public void test_update_address_invalid_value_throws() {
        service.add_contact(new_contact("C001"));
        assertThrows(IllegalArgumentException.class, () -> service.update_address("C001", null));
    }

    @Test
    public void test_update_null_id_throws() {
        service.add_contact(new_contact("C001"));
        assertThrows(IllegalArgumentException.class, () -> service.update_first_name(null, "Intress"));
    }

    @Test
    public void test_multiple_contacts_stored_separately() {
        service.add_contact(new_contact("C001"));
        service.add_contact(new Contact("C002", "Intress", "OW", "9876543210", "13 Addr DR"));
        assertEquals(2, service.contact_count());
        service.update_first_name("C002", "Alice");
        assertEquals("Maxxor", service.get_contact("C001").get_first_name());
        assertEquals("Alice", service.get_contact("C002").get_first_name());
    }
}
