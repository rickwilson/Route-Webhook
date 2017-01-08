package core.util;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class PrettyDate {
    // now in corporate timezone
    public static String currentDateTimeUtah() {
        return dateTimeAndZone(LocalDateTime.now(),"America/Denver");
    }

    // now in defined timezone
    public static String currentDateTimeInZone(String where) {
        ZoneId requestedZone = ZoneId.of(where);
        LocalDateTime when = LocalDateTime.now();
        ZonedDateTime there = ZonedDateTime.of(when,requestedZone);
        return makeItPretty(there);
    }

    // defined datetime in defined timezone
    public static String dateTimeAndZone(LocalDateTime when, String where) {
        ZoneId requestedZone = ZoneId.of(where);
        ZonedDateTime there = ZonedDateTime.of(when,requestedZone);
        return makeItPretty(there);
    }

    // make timedate pretty
    public static String makeItPretty(ZonedDateTime when) {
        String prettyString = null;
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            prettyString = when.format(format);
        } catch (DateTimeException ex) {
            ex.printStackTrace();
        }
        return prettyString;
    }

    // defined timestamp
    public static String makeItPretty(Timestamp time) {
        LocalDateTime when = time.toLocalDateTime();
        return dateTimeAndZone(when,"America/Denver");
    }
}
