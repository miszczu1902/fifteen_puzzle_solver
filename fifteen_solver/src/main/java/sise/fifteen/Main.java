package sise.fifteen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // args[] - lista parametrow String
        // 0 - bfs, dfs, astr
        // 1 - jesli astr -> hamm, manh
        // 2 - zrodlowa plansza
        // 3 - rozwiazana plansza
        // 4 - statystki rozwiazania

        String strategy = args[0];
        String order = args[1];
        String sourceBoardFilePath = args[2];
        String solutionFilePath = args[3];
        String statisticsFilePath = args[4];


        Path currentDir = Paths.get("");
        List<Integer> integers = IOFileOperations.readFromFile(currentDir.toAbsolutePath() + "/" + sourceBoardFilePath);

        Board board = new Board(integers);
        long timeStart;
        long timeStop;
        BFS bfs = new BFS(board);
        timeStart = System.nanoTime();
        Board solvedBoard = bfs.check(board, Board.setOrder(order));
        timeStop = System.nanoTime();

//        System.out.println("Path length: " + solvedBoard.getPath().length());
//        System.out.println("Path: " + solvedBoard.getPath());
//        System.out.println("czas w milisekundach: " + ((timeStop - timeStart) / 1000000.0));

        IOFileOperations.saveToFile( solutionFilePath, String.valueOf(solvedBoard.getPath().length()), solvedBoard.getPath());
        IOFileOperations.saveToFileInformations(statisticsFilePath, String.valueOf(solvedBoard.getPath().length()),
                String.valueOf(bfs.getProcessedStates()),String.valueOf(bfs.getVisitedStates()), String.valueOf(Precision.round((timeStop - timeStart) / 1000000.0, 3)));

    }


}