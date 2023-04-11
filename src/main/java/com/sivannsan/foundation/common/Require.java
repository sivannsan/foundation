package com.sivannsan.foundation.common;

import com.sivannsan.foundation.annotation.Nonnull;

public final class Require {
    private Require() {
    }
    
    @Nonnull
    public static <T> T nonnull(T t) {
        if (t != null) return t;
        throw new RuntimeException("An object is null!");
    }

    @Nonnull
    public static <T> T nonnull(T t, @Nonnull String message) {
        if (t != null) return t;
        throw new RuntimeException(nonnull(message));
    }

    public static int nonnegative(int n, @Nonnull String message) {
        if (n >= 0) return n;
        throw new RuntimeException(nonnull(message));
    }

    public static int nonnegative(int n) {
        return nonnegative(n, "An int32 is negative!");
    }

    public static long nonnegative(long n, @Nonnull String message) {
        if (n >= 0) return n;
        throw new RuntimeException(nonnull(message));
    }

    public static long nonnegative(long n) {
        return nonnegative(n, "An int64 is negative!");
    }

    public static float nonnegative(float n, @Nonnull String message) {
        if (n >= 0) return n;
        throw new RuntimeException(nonnull(message));
    }

    public static float nonnegative(float n) {
        return nonnegative(n, "A float32 is negative!");
    }

    public static double nonnegative(double n, @Nonnull String message) {
        if (n >= 0) return n;
        throw new RuntimeException(nonnull(message));
    }

    public static double nonnegative(double n) {
        return nonnegative(n, "A float64 is negative!");
    }
}
