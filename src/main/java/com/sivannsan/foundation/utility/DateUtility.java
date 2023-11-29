package com.sivannsan.foundation.utility;

import com.sivannsan.foundation.annotation.Nonnull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@SuppressWarnings("unused")
public final class DateUtility {
    private DateUtility() {
    }

    /**
     * List of pattern examples
     * <p> - yyyy   : 1970
     * <p> - MM     : 12
     * <p> - dd     : 31
     * <p> - HH     : 24
     * <p> - mm     : 59
     * <p> - ss     : 59
     * <p> - sss    : 999
     */
    @Nonnull
    public static String format(@Nonnull Date date, @Nonnull String pattern) {
        return format(date, pattern, TimeZone.getDefault());
    }

    /**
     * List of pattern examples
     * <p> - yyyy   : 1970
     * <p> - MM     : 12
     * <p> - dd     : 31
     * <p> - HH     : 24
     * <p> - mm     : 59
     * <p> - ss     : 59
     * <p> - sss    : 999
     */
    @Nonnull
    public static String format(@Nonnull Date date, @Nonnull String pattern, @Nonnull TimeZone timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setTimeZone(timeZone);
        return sdf.format(date);
    }

    /**
     * List of pattern examples
     * <p> - yyyy   : 1970
     * <p> - MM     : 12
     * <p> - dd     : 31
     * <p> - HH     : 24
     * <p> - mm     : 59
     * <p> - ss     : 59
     * <p> - sss    : 999
     * @return  null if parse fail
     */
    public static Date parse(@Nonnull String date, @Nonnull String pattern) {
        return parse(date, pattern, TimeZone.getDefault());
    }

    /**
     * List of pattern examples
     * <p> - yyyy   : 1970
     * <p> - MM     : 12
     * <p> - dd     : 31
     * <p> - HH     : 24
     * <p> - mm     : 59
     * <p> - ss     : 59
     * <p> - sss    : 999
     * @return  null if parse fail
     */
    public static Date parse(@Nonnull String date, @Nonnull String pattern, @Nonnull TimeZone timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setTimeZone(timeZone);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
