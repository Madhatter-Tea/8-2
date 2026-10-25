import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class AppointmentTest {

    private Date future_date() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        return calendar.getTime();
    }

    private Date past_date() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        return calendar.getTime();
    }

    @Test
    public void creates_valid_appointment_maxxor() {
        Appointment appointment = new Appointment("maxxor001", future_date(), "Maxxor defends Kiru City");
        assertEquals("maxxor001", appointment.get_appointment_id());
        assertNotNull(appointment.get_appointment_date());
        assertEquals("Maxxor defends Kiru City", appointment.get_description());
    }

    @Test
    public void creates_valid_appointment_with_minimal_id() {
        Appointment appointment = new Appointment("a", future_date(), "x");
        assertEquals("a", appointment.get_appointment_id());
    }

    @Test
    public void creates_valid_appointment_with_max_length_id() {
        Appointment appointment = new Appointment("chaor00001", future_date(), "Chaor plans UnderWorld raid");
        assertEquals("chaor00001", appointment.get_appointment_id());
    }

    @Test
    public void creates_valid_appointment_with_max_length_description() {
        String description = "Maxxor defends Kiru City from the UnderWorld horde";
        assertEquals(50, description.length());
        Appointment appointment = new Appointment("tangath01", future_date(), description);
        assertEquals(description, appointment.get_description());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_null_appointment_id() {
        new Appointment(null, future_date(), "Najarin studies future mugic");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_appointment_id_too_long() {
        new Appointment("heptadd0001", future_date(), "Heptadd summons the Cothica");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_null_appointment_date() {
        new Appointment("ulmar00001", null, "Ulmar forges new battlegear");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_past_appointment_date() {
        new Appointment("takinom001", past_date(), "Takinom rallies the Danian hive");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_null_description() {
        new Appointment("cromlech1", future_date(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_description_too_long() {
        new Appointment("vanbloot01", future_date(),
                "Lord Van Bloot betrays the OverWorld and marches on Kiru City walls");
    }

    @Test
    public void appointment_id_is_not_updatable() {
        Appointment appointment = new Appointment("intress01", future_date(), "Intress reads the ancient codex");
        assertEquals("intress01", appointment.get_appointment_id());
        try {
            Appointment.class.getMethod("set_appointment_id", String.class);
            fail("appointment_id should not have a setter");
        } catch (NoSuchMethodException expected) {
        }
    }

    @Test
    public void updates_appointment_date_to_valid_future() {
        Appointment appointment = new Appointment("rarran001", future_date(), "Rarran scouts the Mipedian dunes");
        Date new_date = future_date();
        appointment.set_appointment_date(new_date);
        assertEquals(new_date, appointment.get_appointment_date());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_updating_date_to_null() {
        Appointment appointment = new Appointment("khybon001", future_date(), "Khybon builds a gear works");
        appointment.set_appointment_date(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_updating_date_to_past() {
        Appointment appointment = new Appointment("garv0011", future_date(), "garv patrols the Perim gates");
        appointment.set_appointment_date(past_date());
    }

    @Test
    public void updates_description_to_valid_value() {
        Appointment appointment = new Appointment("Vlar1", future_date(), "Vlar signals the front line");
        appointment.set_description("Vlar calls the OverWorld to arms");
        assertEquals("Vlar calls the OverWorld to arms", appointment.get_description());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_updating_description_to_null() {
        Appointment appointment = new Appointment("frafdo001", future_date(), "Frafdo watches the border");
        appointment.set_description(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejects_updating_description_too_long() {
        Appointment appointment = new Appointment("laarina01", future_date(), "Laarina tracks the Mipedian scouts");
        appointment.set_description(
                "Laarina reports that the Mipedian scouts have crossed the dunes again today");
    }
}