package com.sivannsan.foundation.common;

import java.util.Collection;

@SuppressWarnings("unused")
public class Check {
    private Check() {
    }

    public static boolean withinBounds(int size, int index) {
        return index >= 0 && index < size;
    }

    public static <CS extends CharSequence> boolean withinBounds(CS charSequence, int index) {
        return charSequence != null && index >= 0 && index < charSequence.length();
    }

    public static <A> boolean withinBounds(A[] array, int index) {
        return array != null && index >= 0 && index < array.length;
    }

    public static <C extends Collection<?>> boolean withinBounds(C collection, int index) {
        return collection != null && index >= 0 && index < collection.size();
    }
}
