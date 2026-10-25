import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<String, Appointment>();
    }

    public void add_appointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("appointment cannot be null");
        }
        String appointment_id = appointment.get_appointment_id();
        if (appointments.containsKey(appointment_id)) {
            throw new IllegalArgumentException("appointment id already exists: " + appointment_id);
        }
        appointments.put(appointment_id, appointment);
    }

    public void delete_appointment(String appointment_id) {
        if (appointment_id == null) {
            throw new IllegalArgumentException("appointment id cannot be null");
        }
        if (!appointments.containsKey(appointment_id)) {
            throw new IllegalArgumentException("appointment id not found: " + appointment_id);
        }
        appointments.remove(appointment_id);
    }

    public Appointment get_appointment(String appointment_id) {
        return appointments.get(appointment_id);
    }

    public int appointment_count() {
        return appointments.size();
    }
}