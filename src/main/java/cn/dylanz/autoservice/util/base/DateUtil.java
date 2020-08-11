package cn.dylanz.autoservice.util.base;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public class DateUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String preFormatDateTimeString(String dateTimeString) {
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

    public String superPlus(String dateTimeString, int adding, String type) throws Exception {
        return superPlus(dateTimeString, adding, type, "");
    }

    public String superPlus(String dateTimeString, int adding, String type, String patten) throws Exception {
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

    public DateTime plus(String dateTimeString, int adding, String type) {
        dateTimeString = preFormatDateTimeString(dateTimeString);
        DateTime dateTime = new DateTime(dateTimeString);
        return plus(dateTime, adding, type, "");
    }

    public DateTime plus(String dateTimeString, int adding, String type, String patten) {
        dateTimeString = preFormatDateTimeString(dateTimeString);
        DateTime dateTime = new DateTime(dateTimeString);
        return plus(dateTime, adding, type, patten);
    }

    public DateTime plus(DateTime dateTime, int adding, String type) {
        return plus(dateTime, adding, type, "");
    }

    public DateTime plus(DateTime dateTime, int adding, String type, String patten) {
        if (type == null || type.equals("")) {
            return dateTime;
        }
        return plusService(dateTime, adding, type);
    }

    public Long getTimeStamp() {
        DateTime dateTime = new DateTime();
        return dateTime.getMillis();
    }

    public String getCurrentDate() {
        DateTime dateTime = new DateTime();
        return format(dateTime, "MM-dd-YYYY");
    }

    public String getCurrentDate(String format) {
        DateTime dateTime = new DateTime();
        return format(dateTime, format.equals("") ? "MM-dd-YYYY" : format);
    }

    public String getDate() {
        return getCurrentDate();
    }

    public String getDate(String format) {
        return getCurrentDate(format);
    }

    public String getDate(int adding, String type) {
        DateTime dateTime = new DateTime();
        DateTime newTime = plus(dateTime, adding, type);
        return format(newTime, "MM-dd-YYYY");
    }

    public String getDate(int adding, String type, String format) {
        DateTime dateTime = new DateTime();
        DateTime newTime = plus(dateTime, adding, type);
        return format(newTime, format.equals("") ? "MM-dd-YYYY" : format);
    }

    public int getYear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getYear();
    }

    public int getYear() {
        return getYear(0, "");
    }

    public int getMonthOfYear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getMonthOfYear();
    }

    public int getMonthOfYear() {
        return getMonthOfYear(0, "");
    }

    public int getDayOfMonth(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getDayOfMonth();
    }

    public int getDayOfMonth() {
        return getDayOfMonth(0, "");
    }

    public int getDayOfWeek(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getDayOfWeek();
    }

    public int getDayOfWeek() {
        return getDayOfWeek(0, "");
    }

    public int getDayOfYear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getDayOfYear();
    }

    public int getDayOfYear() {
        return getDayOfYear(0, "");
    }

    public int getHourOfDay(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getHourOfDay();
    }

    public int getHourOfDay() {
        return getHourOfDay(0, "");
    }

    public int getMinuteOfHour(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getMinuteOfHour();
    }

    public int getMinuteOfHour() {
        return getMinuteOfHour(0, "");
    }

    public int getSecondOfMinute(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getSecondOfMinute();
    }

    public int getSecondOfMinute() {
        return getSecondOfMinute(0, "");
    }

    public int getWeekOfWeekyear(int adding, String type) {
        DateTime dateTime = new DateTime();
        dateTime = plus(dateTime, adding, type);
        return dateTime.getWeekOfWeekyear();
    }

    public int getWeekOfWeekyear() {
        return getWeekOfWeekyear(0, "");
    }

    public int getDaysBetween(DateTime startDate, DateTime endDate) {
        return Days.daysBetween(startDate, endDate).getDays();
    }

    public String format(String dateString) {
        DateTime dateTime = new DateTime(dateString);
        return format(dateTime, "");
    }

    public String format(String dateString, String patten) {
        DateTime dateTime = new DateTime(dateString);
        return format(dateTime, patten);
    }

    public String format(DateTime dateTime) {
        return format(dateTime, "");
    }

    public String format(DateTime dateTime, String patten) {
        if (dateTime == null) {
            logger.error("Invalid DateTime!");
            return null;
        }
        if (patten.equals("")) {
            logger.error("Invalid format patten!");
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern(patten);
        return dateTime.toString(formatter);
    }

    private DateTime plusService(DateTime dateTime, int adding, String type) {
        type = type.toLowerCase();
        switch (type) {
            case "year":
            case "years":
                dateTime = dateTime.plusYears(adding);
                break;
            case "month":
            case "months":
                dateTime = dateTime.plusMonths(adding);
                break;
            case "week":
            case "weeks":
                dateTime = dateTime.plusWeeks(adding);
                break;
            case "day":
            case "days":
                dateTime = dateTime.plusDays(adding);
                break;
            case "hour":
            case "hours":
                dateTime = dateTime.plusHours(adding);
                break;
            case "minute":
            case "minutes":
                dateTime = dateTime.plusMinutes(adding);
                break;
            case "second":
            case "seconds":
                dateTime = dateTime.plusSeconds(adding);
                break;
            case "milli":
            case "millis":
                dateTime = dateTime.plusMillis(adding);
                break;
        }
        return dateTime;
    }
}
