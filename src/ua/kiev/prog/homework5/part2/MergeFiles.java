package ua.kiev.prog.homework5.part2;

import java.io.IOException;
import java.nio.file.*;

public class MergeFiles {
    public static void main(String[] args) {
        if (args.length < 3) System.out.println("Usage: MergeFiles FileName1 FileName2 TargetFileName");
        else {
            Path file1 = Paths.get(args[0]);
            Path file2 = Paths.get(args[1]);
            if (Files.exists(file1) && Files.exists(file2)) {
                try {
                    Path targetFile = Files.copy(file1, Paths.get(args[2]), StandardCopyOption.REPLACE_EXISTING);
                    Files.write(targetFile, Files.readAllBytes(file2), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("File operation error.");
                }
            } else {
                System.out.println("One or more input files not found.");
                System.out.println(file1.toFile().getAbsolutePath());
                System.out.println(file2.toFile().getAbsolutePath());
            }
        }
    }
}
