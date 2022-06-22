package sise.fifteen;

import java.util.*;

public class ASTR {
    private final Board board;
    private int visitedStates;
    private int processedStates;
    private int heuristicValue;
    double time = 0;
    long timeStart;

    public ASTR(Board b) {
        this.board = b;
    }

    public int getVisitedStates() {
        return visitedStates;
    }

    public int getProcessedStates() {
        return processedStates;
    }

    public Board check(Board s, Movement[] movesOrder, String heuristic) {
        timeStart = System.nanoTime();
        if (s.isOrdered(this.board)) {
            time = (System.nanoTime() - timeStart) / 1000000f;
            return s;
        }

        PriorityQueue<Board> P = new PriorityQueue<>();
        Set<Board> T = new HashSet<>();
        P.add(s);

        while (!P.isEmpty()) {
            Board v = P.poll();
            if (v.isOrdered(this.board)) {
                time = (System.nanoTime() - timeStart) / 1000000f;
                this.visitedStates = P.size() + T.size();
                this.processedStates = T.size();
                return v;
            }
            T.add(v);
            List<Board> neighbours = this.neighbours(movesOrder, v);

            for (Board neighbour : neighbours) {
                if (!T.contains(neighbour)) {
                    neighbour.calculateHeuristic(board, heuristic, neighbour.getDepth());
                    this.heuristicValue = neighbour.getHeuristicValue();
                    if (!P.contains(neighbour)) {
                        P.add(neighbour);
                    }
                } else {
                    if (P.contains(neighbour) && neighbour.getHeuristicValue() > this.heuristicValue) {
                        P.remove(neighbour);
                        neighbour.setHeuristicValue(this.heuristicValue);
                        this.heuristicValue = neighbour.getHeuristicValue();
                        P.add(neighbour);
                    }
                }
            }
        }
        time = (System.nanoTime() - timeStart) / 1000000f;
        this.visitedStates = P.size() + T.size();
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