package sise.fifteen;

import org.apache.commons.math3.util.Precision;

import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
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
        int processedStates = 0;
        int visitedStates = 0;
        double time = 0;

        int length = 0;
        int depth = 0;
        String Path = "";
        Board solvedBoard;


        Path currentDir = Paths.get("");
        List<Integer> integers = IOFileOperations.readFromFile(
                currentDir.toAbsolutePath() + "/" + sourceBoardFilePath);

        Board board = new Board(integers);
        final DecimalFormat df = new DecimalFormat("0.000");
        long timeStart;
        long timeStop;
        if (Objects.equals(strategy, "bfs")) {
            timeStart = System.nanoTime();
            BFS bfs = new BFS(board);
            solvedBoard = bfs.check(board, Board.setOrder(order));
            timeStop = System.nanoTime();
            processedStates = bfs.getProcessedStates();
            visitedStates = bfs.getVisitedStates();
            time = Math.round((timeStop - timeStart) / 1000.0) / 1000.0;
            //time=(timeStop - timeStart) / 1000000.0;
            length = solvedBoard.getPath().length();
            Path = solvedBoard.getPath();
            depth = solvedBoard.getDepth();
            //System.out.println(solvedBoard.getDepth());


        } else if (Objects.equals(strategy, "dfs")) {
            timeStart = System.nanoTime();
            DFS dfs = new DFS(board);
            solvedBoard = dfs.check(board, Board.setOrder(order));
            timeStop = System.nanoTime();
            processedStates = dfs.getProcessedStates();
            visitedStates = dfs.getVisitedStates();
            time = Math.round((timeStop - timeStart) / 1000.0) / 1000.0;
            // time=(timeStop - timeStart) / 1000000.0;
            length = solvedBoard.getPath().length();
            Path = solvedBoard.getPath();
            depth = solvedBoard.getDepth();
            //System.out.println(solvedBoard.getDepth());
        } else {
            timeStart = System.nanoTime();
            ASTR astr = new ASTR(board);
            solvedBoard = astr.check(board, Board.setOrder("LURD"), order);
            timeStop = System.nanoTime();
            processedStates = astr.getProcessedStates();
            visitedStates = astr.getVisitedStates();
            time = Math.round((timeStop - timeStart) / 1000.0) / 1000.0;
            // time=(timeStop - timeStart) / 1000000.0;
            length = solvedBoard.getPath().length();
            Path = solvedBoard.getPath();
            depth = solvedBoard.getDepth();
            //System.out.println(solvedBoard.getDepth());
        }


//        System.out.println("Path length: " + solvedBoard.getPath().length());
//        System.out.println("Path: " + solvedBoard.getPath());
//        System.out.println("czas w milisekundach: " + ((timeStop - timeStart) / 1000000.0));

        IOFileOperations.saveToFile(solutionFilePath, String.valueOf(length), Path);
        IOFileOperations.saveToFileInformations(statisticsFilePath, String.valueOf(length),
                String.valueOf(visitedStates),
                String.valueOf(processedStates), String.valueOf(depth), String.valueOf(time));


    }


}