package com.sivannsan.foundation;

public class Check {
    public static boolean inBound(Object[] a, int index) {
        return a != null && index >= 0 && a.length > index;
    }

    public static boolean between(int start, int end, int element, boolean includeBoundaries) {
        if (start < element && element < end) return true;
        return includeBoundaries && (start == element || element == end);
    }

    public static boolean between(long start, long end, long element, boolean includeBoundaries) {
        if (start < element && element < end) return true;
        return includeBoundaries && (start == element || element == end);
    }

    public static boolean between(float start, float end, float element, boolean includeBoundaries) {
        if (start < element && element < end) return true;
        return includeBoundaries && (start == element || element == end);
    }

    public static boolean between(double start, double end, double element, boolean includeBoundaries) {
        if (start < element && element < end) return true;
        return includeBoundaries && (start == element || element == end);
    }
}
