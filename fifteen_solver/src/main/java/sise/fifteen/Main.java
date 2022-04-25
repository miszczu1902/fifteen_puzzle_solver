package sise.fifteen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path currentDir = Paths.get("");
        List<Integer> filePath = IOFileOperations.readFromFile(currentDir.toAbsolutePath()+"/boards/4x4_01_00001.txt");
        Board board = new Board(filePath);
        System.out.println(Arrays.deepToString(board.getFields()));
        board.move(Movement.R);
        System.out.println(Arrays.deepToString(board.getFields()));
//        board.move(Movement.L);
//        System.out.println(Arrays.deepToString(board.getFields()));
    }
}