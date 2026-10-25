public class Contact {
    private String contact_id;
    private String first_name;
    private String last_name;
    private String phone;
    private String address;

    public Contact(String contact_id, String first_name, String last_name, String phone, String address) {
        if (contact_id == null || contact_id.length() > 10) {
            throw new IllegalArgumentException("contact id must be non-null and at most 10 characters");
        }
        if (first_name == null || first_name.length() > 10) {
            throw new IllegalArgumentException("first name must be non-null and at most 10 characters");
        }
        if (last_name == null || last_name.length() > 10) {
            throw new IllegalArgumentException("last name must be non-null and at most 10 characters");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("phone must be non-null and exactly 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("address must be non-null and at most 30 characters");
        }

        this.contact_id = contact_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.address = address;
    }

    public String get_contact_id() {
        return contact_id;
    }

    public String get_first_name() {
        return first_name;
    }

    public String get_last_name() {
        return last_name;
    }

    public String get_phone() {
        return phone;
    }

    public String get_address() {
        return address;
    }

    public void set_first_name(String first_name) {
        if (first_name == null || first_name.length() > 10) {
            throw new IllegalArgumentException("first name must be non-null and at most 10 characters");
        }
        this.first_name = first_name;
    }

    public void set_last_name(String last_name) {
        if (last_name == null || last_name.length() > 10) {
            throw new IllegalArgumentException("last name must be non-null and at most 10 characters");
        }
        this.last_name = last_name;
    }

    public void set_phone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("phone must be non-null and exactly 10 digits");
        }
        this.phone = phone;
    }

    public void set_address(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("address must be non-null and at most 30 characters");
        }
        this.address = address;
    }
}
