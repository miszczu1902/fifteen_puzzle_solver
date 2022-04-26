package sise.fifteen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path currentDir = Paths.get("");
        List<Integer> integers = IOFileOperations.readFromFile(currentDir.toAbsolutePath()+"/boards/4x4_01_00001.txt");
        System.out.println(integers);
        Board board = new Board(integers);
  //      board.move(Movement.U);
        DFS dfs = new DFS(board.getFields(integers),board.getHeight(integers),board.getWidth(integers));


        System.out.println(Arrays.deepToString(board.getFields(integers)));
//        board.move(Movement.U);
//        System.out.println(Arrays.deepToString(board.getFields()));
//        board.move(Movement.L);
//        System.out.println(Arrays.deepToString(board.getFields()));
//        board.move(Movement.R);
//        System.out.println(Arrays.deepToString(board.getFields()));

        //System.out.println(dfs);
//        board.move(Movement.L);
//        System.out.println(Arrays.deepToString(board.getFields()));
    }

}