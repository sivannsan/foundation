package com.sivannsan.foundation.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("unused")
public final class Log {
    private Log() {
    }

    /**
     * Writes String.valueOf(o) to the "standard" output stream
     */
    public static void write(Object o) {
        System.out.print(o);
    }

    /**
     * Writes the line separator string to the "standard" output stream
     */
    public static void writeLine() {
        System.out.println();
    }

    /**
     * Writes String.valueOf(o) and the line separator string to the "standard" output stream
     */
    public static void writeLine(Object o) {
        System.out.println(o);
    }

    /**
     * Reads a character as an int32 from the "standard" input stream
     * @return  -1 if the IOException occurs or when the end of the stream has been reached
     */
    public static int read() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.read();
        } catch (IOException e) {
            writeLine("An IOException occurs while reading a character as an int32 from the \"standard\" input stream");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Reads a line from the "standard" input stream
     * @return  null if the IOException occurs or when the end of the stream has been reached
     */
    public static String readLine() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            writeLine("An IOException occurs while reading a line from the \"standard\" input stream");
            e.printStackTrace();
            return null;
        }
    }
}
