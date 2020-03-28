package evs.labs.w301Assgnmt;

import com.sun.istack.internal.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateTimeUtils {

    /**
     * Method tells the date is before start, true if before false otherwise.
     *
     * @param start the param with which date param will be compared to check if it is before, in format "yyyy-MM-dd HH:mm:ss"
     * @param date  value of date param to be checked if it is before start, in format "yyyy-MM-dd HH:mm:ss"
     * @return true if date is before start, false otherwise
     */
    static boolean dateTimeBeforeStartDate(@NotNull String start, @NotNull String date) {
        boolean after;
        Date convDate;
        Date convStartDate;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String strCurrentDate = dateFormat.format(new Date());

        try {
            convDate = dateFormat.parse(date);
            convStartDate = dateFormat.parse(start);
            after = convStartDate.after(convDate);
        } catch (ParseException e) {
            e.printStackTrace();
            after = false;
        }
        return after;
    }

    /**
     * Method tells the date is before start, true if before false otherwise.
     *
     * @param start the param with which date param will be compared to check if it is before, in format "yyyy-MM-dd"
     * @param date  value of date param to be checked if it is before start, in format "yyyy-MM-dd"
     * @return true if date is before start, false otherwise
     */
    static boolean dateBeforeStartDate(@NotNull String start, @NotNull String date) {
        boolean flag;
        Date convDate;
        Date convStartDate;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String strCurrentDate = dateFormat.format(new Date());

        try {
            convDate = dateFormat.parse(date);
            convStartDate = dateFormat.parse(start);
            flag = convStartDate.after(convDate);
        } catch (ParseException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * Method tells the date is between start and end, true if in between false otherwise.
     *
     * @param start the param with which date param will be compared for start limit, in format "yyyy-MM-dd HH:mm:ss"
     * @param date  value of date param to be checked for start and end date limit, in format "yyyy-MM-dd HH:mm:ss"
     * @param end   the param with which date param will be compared for end limit, in format "yyyy-MM-dd HH:mm:ss"
     * @return true if date is in between start and end, false otherwise
     */
    static boolean dateTimeBetweenStartAndEndDates(@NotNull String start, @NotNull String date,
                                                   @NotNull String end) {
        boolean flag;
        Date convDate;
        Date convStartDate;
        Date convEndDate;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String strCurrentDate = dateFormat.format(new Date());

        try {
            convDate = dateFormat.parse(date);
            convStartDate = dateFormat.parse(start);
            convEndDate = dateFormat.parse(end);
            flag = convDate.after(convStartDate);

            if (flag) {
                flag = convDate.before(convEndDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
