package sise.fifteen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path currentDir = Paths.get("");
        System.out.println(currentDir.toAbsolutePath());
        List<Integer> filePath = IOFileOperations.readFromFile(currentDir.toAbsolutePath()+"/boards/4x4_01_00001.txt");
        System.out.println(filePath);
        System.out.println("Hello world!");
        Board board = new Board(filePath);
        System.out.println(Arrays.deepToString(board.getFields()));
    }
}