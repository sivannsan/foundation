package com.sivannsan.foundation;

import com.sivannsan.foundation.annotation.Nonnull;

public class Ensure {
    public static <T> T ifNull(T t, @Nonnull T nonnullT) {
        return t == null ? Validate.nonnull(nonnullT) : t;
    }
}
