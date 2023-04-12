package com.sivannsan.foundation.utility;

import com.sivannsan.foundation.common.Log;
import com.sivannsan.foundation.annotation.Nonnull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class FileUtility {
    private FileUtility() {
    }

    /**
     * Creates a new empty regular file if it does not exist, including its parent directory
     */
    public static void createFile(File file) {
        if (file == null) {
            Log.writeLine("Trying to create a regular file yet provided a null reference");
            return;
        }
        createDirectory(file.getParentFile());
        try {
            if (!file.createNewFile()) {
                Log.writeLine("Trying to create a regular file of '" + file.getPath() + "' yet is already exist");
            }
        } catch (IOException e) {
            Log.writeLine("An IOException occurs while creating a regular file");
            e.printStackTrace();
        }
    }

    /**
     * Creates a new directory if it does not exist, including its parent directory
     */
    public static void createDirectory(File file) {
        if (file == null) {
            Log.writeLine("Trying to create a directory yet provided a null reference");
            return;
        }
        if (!file.mkdirs()) {
            Log.writeLine("Trying to create a directory of '" + file.getPath() + "' yet is already exist or something failed");
        }
    }

    /**
     * Writes provided lines into the provided file.
     * <p>If this operation success, the old content will be deleted and replaced with the provided lines. Also, there is no empty line at the end.
     */
    public static void writeLines(File file, String... lines) {
        if (file == null || lines == null) {
            Log.writeLine("Trying to write lines to a file yet provided null references");
            return;
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.join("\n", lines));
        } catch (IOException e) {
            Log.writeLine("An IOException occurs while writing lines to a file");
            e.printStackTrace();
        }
    }

    /**
     * Reads all lines from the provided file.
     */
    @Nonnull
    public static List<String> readLines(File file) {
        List<String> lines = new ArrayList<>();
        if (file == null) {
            Log.writeLine("Trying to read lines from a file yet provided a null reference");
            return lines;
        }
        if (!file.exists()) {
            Log.writeLine("Trying to read lines from a file of '" + file.getPath() + "' yet does not exist");
            return lines;
        }
        if (file.isDirectory()) {
            Log.writeLine("Trying to read lines from a file of '" + file.getPath() + "' yet is a directory");
            return lines;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            Log.writeLine("An IOException occurs while reading lines from a file");
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Deletes a regular file or a directory with its content
     */
    public static void delete(File file) {
        if (file == null) {
            Log.writeLine("Trying to delete a file yet provided a null reference");
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    delete(f);
                }
            }
            if (!file.delete()) {
                Log.writeLine("Could not delete a directory of '" + file.getPath() + "'");
            }
            return;
        }
        if (file.isFile()) {
            if (!file.delete()) {
                Log.writeLine("Could not delete a regular file of '" + file.getPath() + "'");
            }
            return;
        }
        if (!file.exists()) {
            Log.writeLine("Trying to delete a file of '" + file.getPath() + "' yet does not exist");
            return;
        }
        Log.writeLine("Reached an unexpected line of code while deleting a file of '" + file.getPath() + "'");
    }
}
