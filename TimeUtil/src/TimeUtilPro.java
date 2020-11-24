import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


public class TimeUtilPro
{   
    private TimeUtilPro() {
    }

    // ########## LOCALDATE METHODS ##########
    
    public static LocalDate intToLocalDate(int date) {
        return LocalDate.of(date/10000,
                (date/100)%100,
                date%100);
    }

    public static LocalDate longToLocalDate(long dateTime) {
        long date = dateTime/10000;
        return intToLocalDate((int)date);
    }
    
    public static LocalDate dateToLocalDate(Date dateTime) {
        return dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public static LocalDate calendarToLocalDate(Calendar dateTime) {
        ZoneId zoneId = dateTime.getTimeZone() == null ? ZoneId.systemDefault() : dateTime.getTimeZone().toZoneId();
        return dateTime.toInstant().atZone(zoneId).toLocalDate();
    }
    
    // ########## LOCALDATETIME METHODS ##########
            
    public static LocalDateTime intToLocalDateTime(int date) {
        return LocalDateTime.of(date/10000,
                (date/100)%100,
                date%100,0,0);
    }
    
    public static LocalDateTime longToLocalDateTime(long dateTime) {
        return LocalDateTime.of((int)(dateTime/100000000), //years
                (int)((dateTime/1000000)%100), //months
                (int)((dateTime/10000)%100), //days
                (int)((dateTime/100)%100), //hours
                (int)(dateTime%100) //minutes
        );
    }
    
    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        return LocalDateTime.of(dateTime.getYear()+1900,dateTime.getMonth()+1,dateTime.getDate(),0,0);
    }
    
    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        ZoneId zoneId = dateTime.getTimeZone() == null ? ZoneId.systemDefault() : dateTime.getTimeZone().toZoneId();
        return dateTime.toInstant().atZone(zoneId).toLocalDateTime();
    }
           
    // ########## INT METHODS ##########
    
    public static int localDateToInt(LocalDate date) {
        return date.getDayOfMonth()
                +date.getMonthValue()*100
                +date.getYear()*10000;
    }

    public static int localDateTimeToInt(LocalDateTime dateTime) {
        return localDateToInt(dateTime.toLocalDate());
    }

    // ########## LONG METHODS ##########
    
    public static long localDateToLong(LocalDate date) {
        return (long)date.getDayOfMonth()*10000
                +(long)date.getMonthValue()*1000000+
                (long)date.getYear()*100000000;
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        return (long)dateTime.getMinute()
                +(long)dateTime.getHour()*100
                +localDateToLong(dateTime.toLocalDate());
    }

    // ########## DATE METHODS ##########
    
    @SuppressWarnings("deprecation")
    public static Date localDateToDate(LocalDate date) {
        return new Date(date.getYear()-1900,date.getMonthValue()-1,date.getDayOfMonth());
    }

    @SuppressWarnings("deprecation")
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return localDateToDate(dateTime.toLocalDate());
    }

    // ########## CALENDAR METHODS ##########
    
    public static Calendar localDateToCalendar(LocalDate date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        return calendar;
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        Calendar calendar = localDateToCalendar(dateTime.toLocalDate());
        calendar.set(Calendar.HOUR, dateTime.getHour());
        calendar.set(Calendar.MINUTE, dateTime.getMinute());
        return calendar;
    }

}
