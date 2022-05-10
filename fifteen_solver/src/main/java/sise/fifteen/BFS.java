package sise.fifteen;

import java.util.*;

public class BFS {
    private final Board board;
    public int visitedStates;
    public int processedStates;
    public int depth=0;
    public BFS(Board b) {
        this.board = b;
    }

    public int getVisitedStates() {
        return visitedStates;
    }

    public int getProcessedStates() {
        return processedStates;
    }
    public int getHighestDepth()
    {
        return depth;
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
            this.visitedStates++;
        if(v.getDepth()>depth)
        {
            depth=v.getDepth();
        }
            T.add(v);
            List<Board> neighbours = this.neighbours(movesOrder, v);

            for (Board neighbour : neighbours) {
                if (!T.contains(neighbour) && !Q.contains(neighbour)) {
                    if (neighbour.isOrdered(this.board)) {
                        this.visitedStates = Q.size()+T.size();
                        this.processedStates = T.size();
                        //System.out.println(Q.size());
                        //System.out.println(T.size());
                        //System.out.println(this.board.getDepth());
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
