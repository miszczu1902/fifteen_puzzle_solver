package sise.fifteen;

import java.util.*;

public class DFS {
    private final int maxDepth = 21;
    private final Board board;
    private int visitedStates;
    private int processedStates;
    private int depth = 0;
    double time = 0;
    long timeStart;
    private String path = "";

    public DFS(Board b) {
        this.board = b;
    }

    public int getVisitedStates() {
        return visitedStates;
    }

    public int getProcessedStates() {
        return processedStates;
    }

    public int getHighestDepth() {
        return depth;
    }

    public Board check(Board s, Movement[] movesOrder) {
        timeStart = System.nanoTime();

        if (s.isOrdered(this.board)) {
            time = (System.nanoTime() - timeStart) / 1000000f;
            return s;
        }

        Stack<Board> S = new Stack<>();
        Set<Board> T = new HashSet<>();
        S.push(s);

        while (!S.isEmpty()) {
            Board v = S.pop();

            if (!T.contains(v) && v.getDepth() < this.maxDepth) {
                T.add(v);
                List<Board> neighbours = this.neighbours(movesOrder, v);
                Collections.reverse(neighbours);
                for (Board neighbour : neighbours) {
                    if (neighbour.getDepth() > this.depth) {
                        this.depth = neighbour.getDepth();
                    }
                    if (neighbour.isOrdered(this.board)) {
                        time = (System.nanoTime() - timeStart) / 1000000f;
                        this.visitedStates = S.size() + T.size();
                        this.processedStates = T.size();

                        return neighbour;
                    }
                    S.push(neighbour);
                    this.path = neighbour.getPath();

                }
            }
        }
        time = (System.nanoTime() - timeStart) / 1000000f;
        this.visitedStates = S.size() + T.size();
        this.processedStates = T.size();
        return null;
    }

    private List<Board> neighbours(Movement[] movements, Board element) {
        List<Board> result = new ArrayList<>();

        for (Movement movement : movements) {
            if (element.canMove(this.board, movement)) {
                Board newBoard = new Board(this.board, element);
                newBoard.move(movement);
                result.add(newBoard);
            }
        }
        return result;
    }
}
