package com.sivannsan.foundation.utility;

import com.sivannsan.foundation.annotation.Nonnull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtility {
    /**
     * Pattern:
     * - yyyy   : 1970
     * - MM     : 12
     * - dd     : 31
     * - HH     : 24
     * - mm     : 59
     * - ss     : 59
     * - sss    : 999
     */
    @Nonnull
    public static String toString(@Nonnull Date date, @Nonnull String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter.format(date);
    }

    /**
     * Pattern:
     * - yyyy   : 1970
     * - MM     : 12
     * - dd     : 31
     * - HH     : 24
     * - mm     : 59
     * - ss     : 59
     * - sss    : 999
     */
    public static Date fromString(@Nonnull String date, @Nonnull String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
