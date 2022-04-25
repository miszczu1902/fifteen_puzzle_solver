package sise.fifteen;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path currentDir = Paths.get("");
        System.out.println(currentDir.toAbsolutePath());
        String str = IOFileOperations.readFromFile(currentDir.toAbsolutePath() + "/boards/4x4_01_00001.txt");
        System.out.println(str);
        System.out.println("Hello world!");
    }
}