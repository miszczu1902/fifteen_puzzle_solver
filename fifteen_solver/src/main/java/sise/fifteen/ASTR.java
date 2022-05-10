package sise.fifteen;

import java.util.*;

public class ASTR {
    private final Board board;
    public int visitedStates;
    public int processedStates;

    public ASTR(Board b) {
        this.board = b;
    }

    public int getVisitedStates() {
        return visitedStates;
    }
    public int getProcessedStates() {return processedStates;}

    public Board check(Board s, Movement[] movesOrder) {

        if (s.isOrdered(this.board)) {
            return s;
        }

        PriorityQueue<Board> P = new PriorityQueue<>();
        Set<Board> T = new HashSet<>();
        P.add(s);

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
