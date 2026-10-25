import java.util.HashMap;
public class ContactService {
    private HashMap<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<String, Contact>();
    }

    public void add_contact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact cannot be null");
        }
        String id = contact.get_contact_id();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("contact id already exists");
        }
        contacts.put(id, contact);
    }

    public void delete_contact(String contact_id) {
        require_existing(contact_id);
        contacts.remove(contact_id);
    }

    public void update_first_name(String contact_id, String first_name) {
        Contact c = require_existing(contact_id);
        c.set_first_name(first_name);
    }

    public void update_last_name(String contact_id, String last_name) {
        Contact c = require_existing(contact_id);
        c.set_last_name(last_name);
    }

    public void update_phone(String contact_id, String phone) {
        Contact c = require_existing(contact_id);
        c.set_phone(phone);
    }

    public void update_address(String contact_id, String address) {
        Contact c = require_existing(contact_id);
        c.set_address(address);
    }

    public int contact_count() {
        return contacts.size();
    }

    public Contact get_contact(String contact_id) {
        if (contact_id == null) {
            return null;
        }
        return contacts.get(contact_id);
    }

    private Contact require_existing(String contact_id) {
        if (contact_id == null) {
            throw new IllegalArgumentException("contact id cannot be null");
        }
        Contact c = contacts.get(contact_id);
        if (c == null) {
            throw new IllegalArgumentException("contact id not found");
        }
        return c;
    }
}
