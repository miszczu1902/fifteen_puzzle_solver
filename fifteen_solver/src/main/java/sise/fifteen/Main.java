package sise.fifteen;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        // args[] - lista parametrow String
        // 0 - bfs, dfs, astr
        // 1 - jesli astr -> hamm, manh
        // 2 - zrodlowa plansza
        // 3 - rozwiazana plansza
        // 4 - statystki rozwiazania

        String strategy = args[0].toLowerCase();
        String order = args[1].toUpperCase();
        String sourceBoardFilePath = args[2];
        String solutionFilePath = args[3];
        String statisticsFilePath = args[4];
        int processedStates;
        int visitedStates;
        double time;
        int length;
        int depth;
        String Path = "";
        Board solvedBoard;

        Path currentDir = Paths.get("");
        List<Integer> integers = IOFileOperations.readFromFile(
                currentDir.toAbsolutePath() + "/" + sourceBoardFilePath);

        Board board = new Board(integers);
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
            length = solvedBoard.getPath().length();
            Path = solvedBoard.getPath();
            depth = solvedBoard.getDepth();

        } else if (Objects.equals(strategy, "dfs")) {
            timeStart = System.nanoTime();
            //timeStart = System.currentTimeMillis();
            DFS dfs = new DFS(board);
            solvedBoard = dfs.check(board, Board.setOrder(order));
            timeStop = System.nanoTime();
            //timeStop = System.currentTimeMillis();
            processedStates = dfs.getProcessedStates();
            visitedStates = dfs.getVisitedStates();
            time = Math.round((timeStop - timeStart) / 1000.0) / 1000.0;
            //time = Math.round((timeStop - timeStart));
            if (solvedBoard == null) {
                length = -1;
                depth = dfs.getHighestDepth();
            } else {
                length = solvedBoard.getPath().length();
                Path = solvedBoard.getPath();
                depth = dfs.getHighestDepth();
            }

        } else {
            timeStart = System.nanoTime();
            ASTR astr = new ASTR(board);
            solvedBoard = astr.check(board, Board.setOrder("LRUD"), order);
            timeStop = System.nanoTime();
            processedStates = astr.getProcessedStates();
            visitedStates = astr.getVisitedStates();
            time = Math.round((timeStop - timeStart) / 1000.0) / 1000.0;
            length = solvedBoard.getPath().length();
            Path = solvedBoard.getPath();
            depth = solvedBoard.getDepth();
        }
        IOFileOperations.saveToFile(solutionFilePath, String.valueOf(length), Path);
        IOFileOperations.saveToFileInformations(statisticsFilePath, String.valueOf(length),
                String.valueOf(visitedStates),
                String.valueOf(processedStates), String.valueOf(depth), String.valueOf(time));
    }
}