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

        String strategy = args[0].toLowerCase();
        String order = args[1].toUpperCase();
        String sourceBoardFilePath = args[2];
        String solutionFilePath = args[3];
        String statisticsFilePath = args[4];
        String time;
        String Path = "";
        int processedStates = 0;
        int visitedStates = 0;
        int length = 0;
        int depth = 0;
        Path currentDir = Paths.get("");
        List<Integer> integers = IOFileOperations.readFromFile(
                currentDir.toAbsolutePath() + "/" + sourceBoardFilePath);
        Board board = new Board(integers);
        Board solvedBoard;

        if (Objects.equals(strategy, "bfs")) {
            BFS bfs = new BFS(board);
            solvedBoard = bfs.check(board, Board.setOrder(order));
            processedStates = bfs.getProcessedStates();
            visitedStates = bfs.getVisitedStates();
            time = String.format("%.3f", bfs.time);
            length = solvedBoard.getPath().length();
            Path = solvedBoard.getPath();
            depth = solvedBoard.getDepth();

        } else if (Objects.equals(strategy, "dfs")) {
            DFS dfs = new DFS(board);
            solvedBoard = dfs.check(board, Board.setOrder(order));
            processedStates = dfs.getProcessedStates();
            visitedStates = dfs.getVisitedStates();
            time = String.format("%.3f", dfs.time);
            if (solvedBoard == null) {
                length = -1;
                depth = dfs.getHighestDepth();
            } else {
                length = solvedBoard.getPath().length();
                Path = solvedBoard.getPath();
                depth = dfs.getHighestDepth();
            }
        } else {
            ASTR astr = new ASTR(board);
            solvedBoard = astr.check(board, Board.setOrder("LRUD"), order);
            processedStates = astr.getProcessedStates();
            visitedStates = astr.getVisitedStates();
            time = String.format("%.3f", astr.time);
            length = solvedBoard.getPath().length();
            Path = solvedBoard.getPath();
            depth = solvedBoard.getDepth();
        }
        IOFileOperations.saveToFile(solutionFilePath, String.valueOf(length), Path);
        IOFileOperations.saveToFileInformations(statisticsFilePath, String.valueOf(length),
                String.valueOf(visitedStates),
                String.valueOf(processedStates), String.valueOf(depth), time);
    }
}