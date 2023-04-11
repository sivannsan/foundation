package com.sivannsan.foundation.common;

import com.sivannsan.foundation.annotation.Nonnegative;
import com.sivannsan.foundation.annotation.Nonnull;

public final class Validate {
    private Validate() {
    }

    @Nonnull
    public static <T> T ifNull(T t, @Nonnull T nonnullT) {
        return t == null ? Require.nonnull(nonnullT) : t;
    }

    public static int ifNegative(int n, @Nonnegative int nonnegativeN) {
        return n < 0 ? Require.nonnegative(n) : n;
    }

    public static long ifNegative(long n, @Nonnegative long nonnegativeN) {
        return n < 0 ? Require.nonnegative(n) : n;
    }

    public static float ifNegative(float n, @Nonnegative float nonnegativeN) {
        return n < 0 ? Require.nonnegative(n) : n;
    }

    public static double ifNegative(double n, @Nonnegative double nonnegativeN) {
        return n < 0 ? Require.nonnegative(n) : n;
    }
}
