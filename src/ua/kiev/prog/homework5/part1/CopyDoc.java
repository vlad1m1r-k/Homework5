package ua.kiev.prog.homework5.part1;

import java.io.*;

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
        try (FileInputStream inputStream = new FileInputStream(file); FileOutputStream outputStream = new FileOutputStream(target)){
            
        } catch (IOException e) {
            System.out.println("Error copying file.");
        }
    }
}
