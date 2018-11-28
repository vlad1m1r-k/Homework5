package ua.kiev.prog.homework5.part1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyDoc {
    public static void main(String[] args) {
        File source = new File("source");
        File target = new File("target");
        File[] fileList = source.listFiles(pathname -> {
            if (pathname.isDirectory() || pathname.getName().lastIndexOf(".") == -1) return false;
            if (pathname.getName().substring(pathname.getName().lastIndexOf(".")).equalsIgnoreCase(".doc")) return true;
            return false;
        });
        for (File file : fileList) {
            copyFile(file, target);
        }
    }

    private static void copyFile(File file, File target) {
        Path inputFile = file.toPath();
        Path outputFile = Paths.get(target.getName() + File.separator + file.getName());
        try {
            if (!Files.exists(target.toPath())) {
                Files.createDirectory(target.toPath());
            }
            Files.copy(inputFile, outputFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error copying file!");
        }
    }
}
