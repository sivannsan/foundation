package com.sivannsan.foundation.common;

import java.util.Collection;

@SuppressWarnings("unused")
public class Check {
    private Check() {
    }

    public static boolean equals(Object a, Object b) {
        if (a == b) return true;
        return a != null && a.equals(b);
    }

    public static <CS extends CharSequence> boolean withinBounds(CS charSequence, int index) {
        return charSequence != null && between(-1, charSequence.length(), index, false);
    }

    public static <A> boolean withinBounds(A[] array, int index) {
        return array != null && between(-1, array.length, index, false);
    }

    public static <C extends Collection<?>> boolean withinBounds(C collection, int index) {
        return collection != null && between(-1, collection.size(), index, false);
    }

    public static boolean between(int start, int end, int element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }

    public static boolean between(long start, long end, long element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }

    public static boolean between(float start, float end, float element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }

    public static boolean between(double start, double end, double element, boolean inclusive) {
        if (start < element && element < end) return true;
        return inclusive && (start == element || element == end);
    }
}
