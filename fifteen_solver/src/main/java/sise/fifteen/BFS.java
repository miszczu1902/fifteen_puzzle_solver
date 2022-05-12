package sise.fifteen;

import java.util.*;

public class BFS {
    private final Board board;
    private int visitedStates = 0;
    private int processedStates;

    public BFS(Board b) {
        this.board = b;
    }

    public int getVisitedStates() {
        return visitedStates;
    }

    public int getProcessedStates() {
        return processedStates;
    }

    public Board check(Board s, Movement[] movesOrder) {
        if (s.isOrdered(this.board)) {
            return s;
        }

        Queue<Board> Q = new LinkedList<>();
        Set<Board> T = new HashSet<>();
        Q.add(s);

        while (!Q.isEmpty()) {
            Board v = Q.poll();
            T.add(v);
            List<Board> neighbours = this.neighbours(movesOrder, v);

            for (Board neighbour : neighbours) {
                if (!T.contains(neighbour) && !Q.contains(neighbour)) {
                    if (neighbour.isOrdered(this.board)) {
                        this.visitedStates = Q.size() + T.size();
                        this.processedStates = T.size();
                        return neighbour;
                    }
                }
                Q.add(neighbour);
            }
        }
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
