package com.sivannsan.foundation.common;

import java.util.Collection;

public class Check {
    public static <CS extends CharSequence> boolean isInBounds(CS charSequence, int index) {
        return charSequence != null && 0 <= index && index < charSequence.length();
    }

    public static <A> boolean isInBounds(A[] array, int index) {
        return array != null && 0 <= index && index < array.length;
    }

    public static <C extends Collection<?>> boolean isInBounds(C collection, int index) {
        return collection != null && 0 <= index && index < collection.size();
    }

    public static boolean isBetween(int start, int end, int element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }

    public static boolean isBetween(long start, long end, long element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }

    public static boolean isBetween(float start, float end, float element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }

    public static boolean isBetween(double start, double end, double element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }
}
