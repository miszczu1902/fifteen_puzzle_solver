package sise.fifteen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // args[] - lista parametrow String
        // 0 - bfs, dfs, astr
        // 1 - jesli astr -> hamm, manh
        // 2 - zrodlowa plansza
        // 3 - rozwiazana plansza
        // 4 - statystki rozwiazania

        String method = args[0];
        String strategy = args[1];
        String sourceBoardFilePath = args[2];
        String solutionFilePath = args[3];
        String statisticsFilePath = args[4];

        Path currentDir = Paths.get("");
//        List<Integer> integers = IOFileOperations.readFromFile(currentDir.toAbsolutePath() + "/boards/4x4_06_00011.txt");
        List<Integer> integers = IOFileOperations.readFromFile(currentDir.toAbsolutePath() + "/"+ sourceBoardFilePath);
        Board board = new Board(integers);
        //System.out.println(Arrays.deepToString(board.getFields()));
        long timeStart;
        long timeStop;
        BFS bfs = new BFS(board);
//        Movement[] strategy = new Movement[]{Movement.L, Movement.R, Movement.U, Movement.D};
        timeStart = System.nanoTime();
        Board solvedBoard = bfs.check(board, Board.setStrategy(strategy));
        timeStop = System.nanoTime();
        if (solvedBoard != null) {
            System.out.println("Path length: " + solvedBoard.getPath().length());
            System.out.println("Path: " + solvedBoard.getPath());
            System.out.println("czas w milisekundach: " + ((timeStop - timeStart) / 1000000.0));
            IOFileOperations.saveToFile( solutionFilePath, String.valueOf(solvedBoard.getPath().length()), solvedBoard.getPath());
            IOFileOperations.saveToFile(statisticsFilePath, String.valueOf(solvedBoard.getPath().length()), solvedBoard.getPath());
        }
//        else
//        {
//            IOFileOperations.saveToFile( solutionFilePath, String.valueOf(-1), solvedBoard.getPath());
//        }


    }


}


//
//
//
//package sise.fifteen;
//
//        import java.nio.file.Path;
//        import java.nio.file.Paths;
//        import java.util.Arrays;
//        import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        int[][] Solved ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
//
//
//        Path currentDir = Paths.get("");
//        List<Integer> integers = IOFileOperations.readFromFile(currentDir.toAbsolutePath() + "/boards/4x4_07_00212.txt");
//        Board board = new Board(integers);
//        System.out.println(Arrays.deepToString(board.getFields()));
//
//        Puzzle puzzle;
//
//        int[][] puzzleToSolve;
//        puzzleToSolve = board.getFields();
//
//
//        System.out.println("hahazw2");
//        System.out.println(Arrays.deepToString(Solved));
//        puzzle = new Puzzle(puzzleToSolve, Solved);
//        System.out.println("------- BEFORE -------");
//        System.out.println(puzzle);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        long timeStart;
//        long timeStop;
//        SolverBFS solverBFS = new SolverBFS();
//        Movement[] strategy = new Movement[]{Movement.L, Movement.R, Movement.U, Movement.D};
//        timeStart = System.nanoTime();
//        Puzzle solvedPuzzle = solverBFS.solve(puzzle, strategy);
//        timeStop = System.nanoTime();
//        System.out.println("------- AFTER -------");
//        System.out.println(solvedPuzzle);
//        System.out.println("Path: " + solvedPuzzle.getPath());
//        System.out.println("Path length: " + solvedPuzzle.getPath().length());
//        System.out.println("Solved in: " + ((timeStop - timeStart) / 1000) / 1000.0 + "ms");
//
//
//    }
//
//}


//package sise.fifteen;
//
//        import java.nio.file.Path;
//        import java.nio.file.Paths;
//        import java.util.Arrays;
//        import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        int[][] Solved ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
//
//
//        Path currentDir = Paths.get("");
//        List<Integer> integers = IOFileOperations.readFromFile(currentDir.toAbsolutePath() + "/boards/4x4_07_00212.txt");
//        Board board = new Board(integers);
//        System.out.println(Arrays.deepToString(board.getFields()));
//
//        Puzzle puzzle;
//
//        int[][] puzzleToSolve;
//        puzzleToSolve = board.getFields();
//
//
//        System.out.println("hahazw2");
//        System.out.println(Arrays.deepToString(Solved));
//        puzzle = new Puzzle(puzzleToSolve, Solved);
//        System.out.println("------- BEFORE -------");
//        System.out.println(puzzle);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        long timeStart;
//        long timeStop;
//        SolverBFS solverBFS = new SolverBFS();
//        Puzzle.DIRECTION[] strategy = {Puzzle.DIRECTION.RIGHT, Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.LEFT, Puzzle.DIRECTION.UP};
//        timeStart = System.nanoTime();
//        Puzzle solvedPuzzle = solverBFS.solve(puzzle, strategy);
//        timeStop = System.nanoTime();
//        System.out.println("------- AFTER -------");
//        System.out.println(solvedPuzzle);
//        System.out.println("Path: " + solvedPuzzle.getPath());
//        System.out.println("Path length: " + solvedPuzzle.getPath().length());
//        System.out.println("Solved in: " + ((timeStop - timeStart) / 1000) / 1000.0 + "ms");
//
//
//    }
//
//}