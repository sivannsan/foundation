package com.sivannsan.foundation.utility;

import com.sivannsan.foundation.annotation.Nonnull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class FileUtility {
    private FileUtility() {
    }

    /**
     * Writes provided lines into the provided file.
     * <p>If this operation success, the old content will be deleted and replaced with the provided lines. Also, there is no empty line at the end.
     */
    public static void writeLines(@Nonnull File file, @Nonnull List<String> lines) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.join("\n", lines));
        } catch (IOException ignored) {
        }
    }

    /**
     * Reads all lines from the provided file.
     */
    @Nonnull
    public static List<String> readLines(@Nonnull File file) {
        List<String> lines = new ArrayList<>();
        if (!file.exists()) {
            return lines;
        }
        if (file.isDirectory()) {
            return lines;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException ignored) {
        }
        return lines;
    }

    /**
     * Deletes a regular file or a directory with its content
     */
    public static void delete(@Nonnull File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    delete(f);
                }
            }
            file.delete();
            return;
        }
        if (file.isFile()) {
            file.delete();
        }
    }
}
