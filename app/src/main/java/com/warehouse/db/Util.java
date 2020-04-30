package com.warehouse.db;

import android.os.Build;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Util {

    public static final int   ONE = 1;
    public static final long   ZERO_LONG = 0L;
    public static final int    ZERO = 0;
    public static final String MSG_DELIM = " | ";
    public static final String SLASH     = "/";
    public static final String SLASH_NR  = SLASH + "#";
    public static final String DOT  = ".";


    public static final String CONTENT_PROVIDER = "ContentProvider";

    public static final String WHERE_PARAM = "=?";

    public static final Locale LOCALE    = Locale.GERMANY;
    public static final String DEVICE    = Build.MANUFACTURER + "_" + Build.MODEL;

    private static final String     _DB_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:MM";
    public static final  DateFormat DATE_FORMAT        = new SimpleDateFormat(_DB_FORMAT_PATTERN, LOCALE);

    public static String getDateTime() {
        Calendar calendar = Calendar.getInstance();
        String dateTime = DATE_FORMAT.format(calendar.getTime());
        return dateTime;
    }

    public static String dateFormat(Calendar calendarDate) {
        return DATE_FORMAT.format(calendarDate.getTime());
    }

    public static Calendar parse(String dbTime, Calendar baseCalendar) throws ParseException {
        baseCalendar.setTime(DATE_FORMAT.parse(dbTime));
        return baseCalendar;
    }

    public static Calendar parse(String dbTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        return parse(dbTime, calendar);
    }
}
