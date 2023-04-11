package com.sivannsan.foundation.common;

import com.sivannsan.foundation.annotation.Nonnull;

public final class Log {
    private Log() {
    }

    public static void out(@Nonnull String s, boolean endsLine) {
        if (endsLine) System.out.println(Require.nonnull(s));
        else System.out.print(Require.nonnull(s));
    }

    public static void err(@Nonnull String s, boolean endsLine) {
        if (endsLine) System.err.println(Require.nonnull(s));
        else System.err.print(Require.nonnull(s));
    }
}
