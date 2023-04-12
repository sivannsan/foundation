package com.sivannsan.foundation.utility;

import com.sivannsan.foundation.annotation.Nonnull;
import com.sivannsan.foundation.common.Log;
import com.sivannsan.foundation.common.Validate;

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
        SimpleDateFormat formatter = new SimpleDateFormat(Validate.nonnull(pattern));
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter.format(Validate.nonnull(date));
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
        SimpleDateFormat format = new SimpleDateFormat(Validate.nonnull(pattern));
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return format.parse(Validate.nonnull(date));
        } catch (ParseException e) {
            Log.writeLine("A ParseException occurs while parsing a date from a string with pattern");
            e.printStackTrace();
            return null;
        }
    }
}
