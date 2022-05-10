package sise.fifteen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

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
        if (Objects.equals(strategy, "bfs")) {
            timeStart = System.nanoTime();
            BFS bfs = new BFS(board);
            solvedBoard = bfs.check(board, Board.setOrder(order));
            timeStop = System.nanoTime();
            processedStates=bfs.getProcessedStates();
            visitedStates=bfs.getVisitedStates();
            time=Precision.round((timeStop - timeStart) / 1000000.0, 3);
            length = solvedBoard.getPath().length();
            Path=solvedBoard.getPath();
            System.out.println(solvedBoard.getDepth());


        } else  {
            timeStart = System.nanoTime();
            DFS dfs = new DFS(board);
            solvedBoard = dfs.check(board, Board.setOrder(order));
            timeStop = System.nanoTime();
            processedStates=dfs.getProcessedStates();
            visitedStates=dfs.getVisitedStates();
            time=Precision.round((timeStop - timeStart) / 1000000.0, 3);
            length = solvedBoard.getPath().length();
            Path=solvedBoard.getPath();
            System.out.println(solvedBoard.getDepth());
        }



//        System.out.println("Path length: " + solvedBoard.getPath().length());
//        System.out.println("Path: " + solvedBoard.getPath());
//        System.out.println("czas w milisekundach: " + ((timeStop - timeStart) / 1000000.0));

        IOFileOperations.saveToFile( solutionFilePath, String.valueOf(solvedBoard.getPath().length()), solvedBoard.getPath());
        IOFileOperations.saveToFileInformations(statisticsFilePath, String.valueOf(solvedBoard.getPath().length()),
                String.valueOf(bfs.getProcessedStates()),String.valueOf(bfs.getVisitedStates()), String.valueOf(Precision.round((timeStop - timeStart) / 1000000.0, 3)));

    }


}