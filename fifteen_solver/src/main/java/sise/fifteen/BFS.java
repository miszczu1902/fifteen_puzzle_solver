package sise.fifteen;

import java.util.*;

public class BFS {
    private final Board board;

    public BFS(Board b) {
        this.board = b;
    }

    public Board check(Board s, Movement[] movementStrategy) {

        if (s.isOrdered(this.board)) {
            return s;
        }

        Queue<Board> Q = new LinkedList<>();
        Set<Board> T = new HashSet<>();
        Q.add(s);

        while (!Q.isEmpty()) {
            Board v = Q.poll();
            T.add(v);
            List<Board> neighbours = this.neighbours(movementStrategy, v);

            for (Board neighbour : neighbours) {
                if (!T.contains(neighbour) && !Q.contains(neighbour)) {
                    if (neighbour.isOrdered(this.board)) {
                        System.out.println(Q.size());
                        System.out.println(T.size());
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
