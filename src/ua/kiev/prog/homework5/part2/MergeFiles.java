package ua.kiev.prog.homework5.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MergeFiles {
    public static void main(String[] args) {
        if (args.length < 4) System.out.println("Usage: MergeFiles FileName1 FileName2 TargetFileName");
        Path file1 = Paths.get(args[0]);
        Path file2 = Paths.get(args[1]);
        if (Files.exists(file1) && Files.exists(file2)) {
            try {
                Path targetFile = Files.copy(file1, Paths.get(args[3]), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Input files not found.");
        }
    }
}
