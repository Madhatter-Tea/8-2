import java.util.Date;

public class Appointment {

    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    private final String appointment_id;
    private Date appointment_date;
    private String description;

    public Appointment(String appointment_id, Date appointment_date, String description) {
        validate_id(appointment_id);
        validate_date(appointment_date);
        validate_description(description);

        this.appointment_id = appointment_id;
        this.appointment_date = new Date(appointment_date.getTime());
        this.description = description;
    }

    private void validate_id(String appointment_id) {
        if (appointment_id == null) {
            throw new IllegalArgumentException("appointment_id cannot be null");
        }
        if (appointment_id.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("appointment_id cannot be longer than " + MAX_ID_LENGTH + " characters");
        }
    }

    private void validate_date(Date appointment_date) {
        if (appointment_date == null) {
            throw new IllegalArgumentException("appointment_date cannot be null");
        }
        if (appointment_date.before(new Date())) {
            throw new IllegalArgumentException("appointment_date cannot be in the past");
        }
    }

    private void validate_description(String description) {
        if (description == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        if (description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("description cannot be longer than " + MAX_DESCRIPTION_LENGTH + " characters");
        }
    }

    public String get_appointment_id() {
        return appointment_id;
    }

    public Date get_appointment_date() {
        return new Date(appointment_date.getTime());
    }

    public String get_description() {
        return description;
    }

    public void set_appointment_date(Date appointment_date) {
        validate_date(appointment_date);
        this.appointment_date = new Date(appointment_date.getTime());
    }

    public void set_description(String description) {
        validate_description(description);
        this.description = description;
    }
}