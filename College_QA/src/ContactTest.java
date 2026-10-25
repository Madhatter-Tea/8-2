import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact make_valid_contact() {
        return new Contact("C001", "Nivenna", "Garv", "0123456789", "13 a dress");
    }

    @Test
    public void test_contact_created_with_valid_fields() {
        Contact c = make_valid_contact();
        assertEquals("C001", c.get_contact_id());
        assertEquals("Nivenna", c.get_first_name());
        assertEquals("Garv", c.get_last_name());
        assertEquals("0123456789", c.get_phone());
        assertEquals("13 a dress", c.get_address());
    }

    @Test
    public void test_contact_id_at_max_length_is_valid() {
        Contact c = new Contact("1234567890", "Nivenna", "Garv", "0123456789", "13 a dress");
        assertEquals(10, c.get_contact_id().length());
    }

    @Test
    public void test_contact_id_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Nivenna", "Garv", "0123456789", "13 a dress");
        });
    }

    @Test
    public void test_contact_id_too_long_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Nivenna", "Garv", "0123456789", "13 a dress");
        });
    }

    @Test
    public void test_first_name_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", null, "Garv", "0123456789", "13 a dress");
        });
    }

    @Test
    public void test_first_name_too_long_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Irrabeq", "Garv", "0123456789", "13 a dress");
        });
    }

    @Test
    public void test_last_name_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", null, "0123456789", "13 a dress");
        });
    }

    @Test
    public void test_last_name_too_long_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", "Iflar", "0123456789", "13 a dress");
        });
    }

    @Test
    public void test_phone_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", "Garv", null, "13 a dress");
        });
    }

    @Test
    public void test_phone_too_short_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", "Garv", "12345", "13 a dress");
        });
    }

    @Test
    public void test_phone_too_long_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", "Garv", "01234567890", "13 a dress");
        });
    }

    @Test
    public void test_phone_with_letters_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", "Garv", "01234abcd9", "13 a dress");
        });
    }

    @Test
    public void test_address_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", "Garv", "0123456789", null);
        });
    }

    @Test
    public void test_address_too_long_throws() {
        String long_address = "This address is definitely way too long to pass validation";
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Nivenna", "Garv", "0123456789", long_address);
        });
    }

    @Test
    public void test_set_first_name_updates_value() {
        Contact c = make_valid_contact();
        c.set_first_name("Aivenna");
        assertEquals("Aivenna", c.get_first_name());
    }

    @Test
    public void test_set_first_name_null_throws() {
        Contact c = make_valid_contact();
        assertThrows(IllegalArgumentException.class, () -> c.set_first_name(null));
    }

    @Test
    public void test_set_first_name_too_long_throws() {
        Contact c = make_valid_contact();
        assertThrows(IllegalArgumentException.class, () -> c.set_first_name("Irrabeq"));
    }

    @Test
    public void test_set_last_name_updates_value() {
        Contact c = make_valid_contact();
        c.set_last_name("Vlar");
        assertEquals("Vlar", c.get_last_name());
    }

    @Test
    public void test_set_last_name_null_throws() {
        Contact c = make_valid_contact();
        assertThrows(IllegalArgumentException.class, () -> c.set_last_name(null));
    }

    @Test
    public void test_set_phone_updates_value() {
        Contact c = make_valid_contact();
        c.set_phone("9876543210");
        assertEquals("9876543210", c.get_phone());
    }

    @Test
    public void test_set_phone_invalid_throws() {
        Contact c = make_valid_contact();
        assertThrows(IllegalArgumentException.class, () -> c.set_phone("12345"));
    }

    @Test
    public void test_set_phone_null_throws() {
        Contact c = make_valid_contact();
        assertThrows(IllegalArgumentException.class, () -> c.set_phone(null));
    }

    @Test
    public void test_set_address_updates_value() {
        Contact c = make_valid_contact();
        c.set_address("13 Addr DR");
        assertEquals("13 Addr DR", c.get_address());
    }

    @Test
    public void test_set_address_null_throws() {
        Contact c = make_valid_contact();
        assertThrows(IllegalArgumentException.class, () -> c.set_address(null));
    }

    @Test
    public void test_set_address_too_long_throws() {
        Contact c = make_valid_contact();
        assertThrows(IllegalArgumentException.class, () -> c.set_address("Address too long"));
    }
}