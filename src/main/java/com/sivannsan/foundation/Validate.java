package com.sivannsan.foundation;

import com.sivannsan.foundation.annotation.Nonnull;

import java.util.Objects;

public final class Validate {
    public static <T> T nonnull(T t) {
        return Objects.requireNonNull(t);
    }

    public static <T> T nonnull(T t, @Nonnull String message) {
        return Objects.requireNonNull(t, message);
    }
}
