package evs.labs.w3lab.exercise;

import com.sun.istack.internal.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Sample implementation of Date Time's Java Functionality
 */
public class TestDateTimeComparison {
    public static void main(String[] args) {
        System.out.println(getCurrentDateTimeInFormat("yyyy-MM-dd HH:mm:ss")); // 24 hrs format
        System.out.println(getCurrentDateTimeInFormat("yyyy-MM-dd hh:mm:ss a")); // 12 hrs format
        System.out.println(getCurrentDateTimeInFormat("yyyy-MMMMM-dd HH:mm:ss")); // Month as a word 24 hrs format

        System.out.println("Is date before start? : " + dateTimeBeforeStartDate("yyyy-MM-dd HH:mm:ss",
                "2019-12-08 17:16:30","2019-12-08 17:16:29"));
    }

    /**
     * Method is getting String format e.g. yyyy-MM-dd HH:mm:ss and return the current date String in the given
     * valid format. See <a href="https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html">SimpleDateFormat</a></br>
     * <a href="https://www.javatpoint.com/java-get-current-date">Get Current Date - JavaTPoint</a>
     * @param format {@link String} format e.g. yyyy-MM-dd HH:mm:ss
     * @return Formatted String current datetime
     */
    private static String getCurrentDateTimeInFormat(@NotNull String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        //Date date = new Date();
        return formatter.format(new Date());
    }

    static boolean dateTimeBeforeStartDate(@NotNull String format, @NotNull String start, @NotNull String date) {
        boolean before;
        Date convDate;
        Date convStartDate;

        SimpleDateFormat formatter = new SimpleDateFormat(format);

        try {
            convStartDate = formatter.parse(start);
            convDate = formatter.parse(date);
            before = convDate.before(convStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
            before = false;
        }

        return before;
    }
}
