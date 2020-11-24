import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TimeUtilProTest {

    private final int INT = 20030201;
    private final long LONGNOTIME = 200302010000L;
    private final long LONG = 200302011234L;

    private final LocalDate LOCALDATE = LocalDate.of(2003,2,1);
    private final LocalDateTime LOCALDATENOTIME = LocalDateTime.of(2003,2,1,0,0);
    private final LocalDateTime LOCALDATETIME = LocalDateTime.of(2003,2,1,12,34);
    private final Date DATE = new Date(103, Calendar.FEBRUARY,1);
    private static final Calendar CALENDARNOTIME = Calendar.getInstance();
    private static final Calendar CALENDAR = Calendar.getInstance();


    @BeforeAll
    static void beforeAll() {
        CALENDARNOTIME.set(2003,Calendar.FEBRUARY,1);
        CALENDAR.clear();
        CALENDAR.set(2003,Calendar.FEBRUARY,1,12,34);
    }

    private void assertLocalDateEquals(LocalDate solution, LocalDate result){
        if(!solution.isEqual(result)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            fail("result ("+result.format(formatter)+") does not equal solution ("+solution.format(formatter)+")");
        }
    }

    private void assertLocalDateTimeEquals(LocalDateTime solution, LocalDateTime result){
        if(!solution.isEqual(result)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
            fail("result ("+result.format(formatter)+") does not equal solution ("+solution.format(formatter)+")");
        }
    }

    @Test
    void testIntToLocalDate() {
        LocalDate result = TimeUtilPro.intToLocalDate(INT);
        assertEquals(LOCALDATE,result);
    }

    @Test
    void testLongToLocalDate() {
        LocalDate result = TimeUtilPro.longToLocalDate(LONG);
        assertEquals(LOCALDATE,result);
    }

    @Test
    void testDateToLocalDate() {
        LocalDate result = TimeUtilPro.dateToLocalDate(DATE);
        assertEquals(LOCALDATE,result);
    }

    @Test
    void testCalendarToLocalDate() {
        LocalDate result = TimeUtilPro.calendarToLocalDate(CALENDARNOTIME);
        assertEquals(LOCALDATE,result);
    }

    @Test
    void testIntToLocalDateTime() {
        LocalDateTime result = TimeUtilPro.intToLocalDateTime(INT);
        assertEquals(LOCALDATENOTIME,result);
    }

    @Test
    void testLongToLocalDateTime() {
        LocalDateTime result = TimeUtilPro.longToLocalDateTime(LONG);
        assertEquals(LOCALDATETIME,result);
    }

    @Test
    void testDateToLocalDateTime() {
        LocalDateTime result = TimeUtilPro.dateToLocalDateTime(DATE);
        assertEquals(LOCALDATENOTIME,result);
    }

    @Test
    void testCalendarToLocalDateTime() {
        LocalDateTime result = TimeUtilPro.calendarToLocalDateTime(CALENDAR);
        assertEquals(LOCALDATETIME,result);
    }

    @Test
    void testLocalDateToInt() {
        int result = TimeUtilPro.localDateToInt(LOCALDATE);
        assertEquals(INT,result);
    }

    @Test
    void testLocalDateTimeToInt() {
        int result = TimeUtilPro.localDateTimeToInt(LOCALDATENOTIME);
        assertEquals(INT,result);
    }

    @Test
    void testLocalDateToLong() {
        long result = TimeUtilPro.localDateToLong(LOCALDATE);
        assertEquals(LONGNOTIME,result);
    }

    @Test
    void testLocalDateTimeToLong() {
        long result = TimeUtilPro.localDateTimeToLong(LOCALDATETIME);
        assertEquals(LONG,result);
    }

    @Test
    void testLocalDateToDate() {
        Date result = TimeUtilPro.localDateToDate(LOCALDATE);
        assertEquals(DATE,result);
    }

    @Test
    void testLocalDateTimeToDate() {
        Date result = TimeUtilPro.localDateTimeToDate(LOCALDATENOTIME);
        assertEquals(DATE,result);
    }
}