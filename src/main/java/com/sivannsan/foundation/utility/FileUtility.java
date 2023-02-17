package com.sivannsan.foundation.utility;

import com.sivannsan.foundation.Validate;
import com.sivannsan.foundation.annotation.Nonnull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtility {
    public static void createFile(@Nonnull File file) {
        try {
            Validate.nonnull(file);
            File parent = file.getParentFile();
            if (parent != null) parent.mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDirectory(@Nonnull File file) {
        Validate.nonnull(file).mkdirs();
    }

    public static void write(@Nonnull File file, @Nonnull byte[] bytes) {
        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(@Nonnull File file, @Nonnull String... lines) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(String.join("\n", lines));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(@Nonnull File file) {
        if (!file.exists()) return;
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        File[] files = file.listFiles();
        if (files != null) for (File f : files) delete(f);
        file.delete();
    }
}
