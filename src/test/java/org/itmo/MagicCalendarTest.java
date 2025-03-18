package org.itmo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagicCalendarTest {

    @Test
    public void testReplaceWorkWithPersonal() {
        MagicCalendar calendar = new MagicCalendar();
        // Планируем рабочую встречу на "10:00"
        assertTrue(calendar.scheduleMeeting("Alice", "10:00", MagicCalendar.MeetingType.WORK));
    }
}
