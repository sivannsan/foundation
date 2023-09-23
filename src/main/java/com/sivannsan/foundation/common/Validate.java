package com.sivannsan.foundation.common;

import com.sivannsan.foundation.annotation.Nonnull;

@SuppressWarnings("unused")
public final class Validate {
    private Validate() {
    }

    public static void valid(boolean condition, @Nonnull String message) {
        if (condition) return;
        throw new RuntimeException(message);
    }

    public static void valid(boolean condition) {
        valid(condition, "A condition is not valid!");
    }

    @Nonnull
    public static <T> T nonnull(T t, @Nonnull String message) {
        valid(t != null, message);
        return t;
    }
    
    @Nonnull
    public static <T> T nonnull(T t) {
        return nonnull(t, "An object is null!");
    }

    public static int nonnegative(int n, @Nonnull String message) {
        valid(n >= 0, message);
        return n;
    }

    public static int nonnegative(int n) {
        return nonnegative(n, "An int32 is negative!");
    }

    public static long nonnegative(long n, @Nonnull String message) {
        valid(n >= 0, message);
        return n;
    }

    public static long nonnegative(long n) {
        return nonnegative(n, "An int64 is negative!");
    }

    public static float nonnegative(float n, @Nonnull String message) {
        valid(n >= 0, message);
        return n;
    }

    public static float nonnegative(float n) {
        return nonnegative(n, "A float32 is negative!");
    }

    public static double nonnegative(double n, @Nonnull String message) {
        valid(n >= 0, message);
        return n;
    }

    public static double nonnegative(double n) {
        return nonnegative(n, "A float64 is negative!");
    }
}
