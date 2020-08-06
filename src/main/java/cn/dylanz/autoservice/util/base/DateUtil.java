package cn.dylanz.autoservice.util.base;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class DateUtil {
//    private static Logger logger = Logger.getLogger(DateUtil.class);

    public static String preFormatDateTimeString(String dateTimeString) {
        dateTimeString = dateTimeString.replaceAll("/", "-");
        String[] arr = dateTimeString.split("-");
        if (arr[0].length() == 4) {
            return String.join("-", arr);
        }
        String month = arr[0];
        String day = arr[1];
        String year = arr[2].substring(0, 4);
        String time = arr[2].substring(4, arr[2].length());
        return year + "-" + month + "-" + day + time;
    }

    public static String superPlus(String dateTimeString, int adding, String type) throws Exception {
        return superPlus(dateTimeString, adding, type, "");
    }

    public static String superPlus(String dateTimeString, int adding, String type, String patten) throws Exception {
        if (type == null || type.equals("")) {
            return dateTimeString;
        }
        dateTimeString = preFormatDateTimeString(dateTimeString);
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateTimeString);
        } catch (Exception e) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            date = sdf.parse(dateTimeString);
        }
        DateTime dateTime = new DateTime(date.getTime());
        dateTime = plusService(dateTime, adding, type);
        if (!patten.equals("")) {
            return format(dateTime, patten);
        }
        return dateTime.toString();
    }

    public static DateTime plus(String dateTimeString, int adding, String type) {
        dateTimeString = preFormatDateTimeString(dateTimeString);
        DateTime dateTime = new DateTime(dateTimeString);
        return plus(dateTime, adding, type, "");
    }

    public static DateTime plus(String dateTimeString, int adding, String type, String patten) {
        dateTimeString = preFormatDateTimeString(dateTimeString);
        DateTime dateTime = new DateTime(dateTimeString);
        return plus(dateTime, adding, type, patten);
    }

    public static DateTime plus(DateTime dateTime, int adding, String type) {
        return plus(dateTime, adding, type, "");
    }

    public static DateTime plus(DateTime dateTime, int adding, String type, String patten) {
        if (type == null || type.equals("")) {
            return dateTime;
        }
        return plusService(dateTime, adding, type);
    }

    public static Long getTimeStamp() {
        DateTime dateTime = new DateTime();
        return dateTime.getMillis();
    }

    public static String getCurrentDate() {
        DateTime dateTime = new DateTime();
        return format(dateTime, "MM-dd-YYYY");
    }

    public static String getCurrentDate(String format) {
        DateTime dateTime = new DateTime();
        return format(dateTime, format.equals("") ? "MM-dd-YYYY" : format);
    }

    public static String getDate() {
        return getCurrentDate();
    }

    public static String getDate(String format) {
        return getCurrentDate(format);
    }

    public static String getDate(int adding, String type) {
        DateTime dateTime = new DateTime();
        DateTime newTime = plus(dateTime, adding, type);
        return format(newTime, "MM-dd-YYYY");
    }

    public static String getDate(int adding, String type, String format) {
        DateTime dateTime = new DateTime();
        DateTime newTime = plus(dateTime, adding, type);
        return format(newTime, format.equals("") ? "MM-dd-YYYY" : format);
    }

    public static int getYear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getYear();
    }

    public static int getYear() {
        return getYear(0, "");
    }

    public static int getMonthOfYear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getMonthOfYear();
    }

    public static int getMonthOfYear() {
        return getMonthOfYear(0, "");
    }

    public static int getDayOfMonth(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getDayOfMonth();
    }

    public static int getDayOfMonth() {
        return getDayOfMonth(0, "");
    }

    public static int getDayOfWeek(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getDayOfWeek();
    }

    public static int getDayOfWeek() {
        return getDayOfWeek(0, "");
    }

    public static int getDayOfYear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getDayOfYear();
    }

    public static int getDayOfYear() {
        return getDayOfYear(0, "");
    }

    public static int getHourOfDay(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getHourOfDay();
    }

    public static int getHourOfDay() {
        return getHourOfDay(0, "");
    }

    public static int getMinuteOfHour(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getMinuteOfHour();
    }

    public static int getMinuteOfHour() {
        return getMinuteOfHour(0, "");
    }

    public static int getSecondOfMinute(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getSecondOfMinute();
    }

    public static int getSecondOfMinute() {
        return getSecondOfMinute(0, "");
    }

    public static int getWeekOfWeekyear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getWeekOfWeekyear();
    }

    public static int getWeekOfWeekyear() {
        return getWeekOfWeekyear(0, "");
    }

    public static int getDaysBetween(DateTime startDate, DateTime endDate) {
        return Days.daysBetween(startDate, endDate).getDays();
    }

    public static String format(String dateString) {
        DateTime dateTime = new DateTime(dateString);
        return format(dateTime, "");
    }

    public static String format(String dateString, String patten) {
        DateTime dateTime = new DateTime(dateString);
        return format(dateTime, patten);
    }

    public static String format(DateTime dateTime) {
        return format(dateTime, "");
    }

    public static String format(DateTime dateTime, String patten) {
        if (dateTime == null) {
//            logger.error("Invalid DateTime!");
            return null;
        }
        if (patten == null || patten.equals("")) {
//            logger.error("Invalid format patten!");
            return null;
        }
        if (!patten.equals("")) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(patten);
            return dateTime.toString(formatter);
        }
        return dateTime.toString();
    }

    private static DateTime plusService(DateTime dateTime, int adding, String type) {
        type = type.toLowerCase();
        switch (type) {
            case "year":
                dateTime = dateTime.plusYears(adding);
                break;
            case "years":
                dateTime = dateTime.plusYears(adding);
                break;
            case "month":
                dateTime = dateTime.plusMonths(adding);
                break;
            case "months":
                dateTime = dateTime.plusMonths(adding);
                break;
            case "week":
                dateTime = dateTime.plusWeeks(adding);
                break;
            case "weeks":
                dateTime = dateTime.plusWeeks(adding);
                break;
            case "day":
                dateTime = dateTime.plusDays(adding);
                break;
            case "days":
                dateTime = dateTime.plusDays(adding);
                break;
            case "hour":
                dateTime = dateTime.plusHours(adding);
                break;
            case "hours":
                dateTime = dateTime.plusHours(adding);
                break;
            case "minute":
                dateTime = dateTime.plusMinutes(adding);
                break;
            case "minutes":
                dateTime = dateTime.plusMinutes(adding);
                break;
            case "second":
                dateTime = dateTime.plusSeconds(adding);
                break;
            case "seconds":
                dateTime = dateTime.plusSeconds(adding);
                break;
            case "milli":
                dateTime = dateTime.plusMillis(adding);
                break;
            case "millis":
                dateTime = dateTime.plusMillis(adding);
                break;
        }
        return dateTime;
    }
}
