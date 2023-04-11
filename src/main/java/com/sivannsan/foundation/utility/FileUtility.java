package com.sivannsan.foundation.utility;

import com.sivannsan.foundation.common.Log;
import com.sivannsan.foundation.common.Validate;
import com.sivannsan.foundation.annotation.Nonnull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class FileUtility {
    private FileUtility() {
    }

    /**
     * Creates a new empty file if it does not exist, including its parent directory
     */
    public static void createFile(File file) {
        if (file == null) {
            Log.out("Trying to create a file yet provided a null reference", true);
            return;
        }
        createDirectory(file.getParentFile());
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new directory if it does not exist, including its parent directory
     */
    public static void createDirectory(File file) {
        if (file == null) {
            Log.out("Trying to create a directory yet provided a null reference", true);
            return;
        }
        file.mkdirs();
    }

    /**
     * If this operation success, the old content will be deleted and replaced with the provided bytes
     */
    public static void write(File file, byte[] bytes) {
        if (file == null || bytes == null) {
            Log.out("Trying to write bytes to a file yet provided null references", true);
            return;
        }
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(bytes);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * If this operation success, the old content will be deleted and replaced with the provided lines
     */
    public static void write(File file, String... lines) {
        if (file == null || lines == null) {
            Log.out("Trying to write lines to a file yet provided null references", true);
            return;
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.join("\n", lines));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nonnull
    public static List<String> readLines(File file) {
        List<String> lines = new ArrayList<>();
        if (file == null) {
            Log.out("Trying to read lines from a file yet provided a null reference", true);
            return lines;
        }
        if (!file.exists()) {
            Log.out("Trying to read lines from a file of '" + file.getPath() + "' yet does not exist", true);
            return lines;
        }
        if (file.isDirectory()) {
            Log.out("Trying to read lines from a file of '" + file.getPath() + "' yet is a directory", true);
            return lines;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Deletes a regular file or a directory with its content
     */
    public static void delete(File file) {
        if (file == null) {
            Log.out("Trying to delete a file yet provided a null reference", true);
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
                Log.out("Could not delete a directory of '" + file.getPath() + "'", true);
            }
            return;
        }
        if (file.isFile()) {
            if (!file.delete()) {
                Log.out("Could not delete a regular file of '" + file.getPath() + "'", true);
            }
            return;
        }
        if (!file.exists()) {
            Log.out("Trying to delete a file of '" + file.getPath() + "' yet does not exist", true);
            return;
        }
        Log.out("Reached an unexpected line of code while deleting a file of '" + file.getPath() + "'", true);
    }
}
