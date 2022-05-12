package sise.fifteen;

import java.util.*;

public class DFS {
    private final int maxDepth = 20;
    private final Board board;
    private int visitedStates;
    private int processedStates;
    private int depth = 0;
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

        if (s.isOrdered(this.board)) {
            return s;
        }

        Stack<Board> S = new Stack<>();
        Set<Board> T = new HashSet<>();
        S.push(s);

        while (!S.isEmpty()) {
            Board v = S.pop();
            if (v.getDepth() > this.maxDepth) {
                continue;
            }

            if (v.getDepth() > this.depth) {
                this.depth = v.getDepth();
            }

            if (!T.contains(v)) {
                T.add(v);
                List<Board> neighbours = this.neighbours(movesOrder, v);
                Collections.reverse(neighbours);

                for (Board neighbour : neighbours) {
                    if (neighbour.isOrdered(this.board)) {
                        this.visitedStates = S.size() + T.size();
                        this.processedStates = T.size();

                        return neighbour;
                    }
                    S.push(neighbour);
                    this.path = neighbour.getPath();

                }
            }
        }
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
