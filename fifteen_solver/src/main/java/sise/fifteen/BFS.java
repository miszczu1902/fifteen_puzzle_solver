package sise.fifteen;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private final Board board;


    public BFS(Board b) {
        this.board = b;
    }

    public Board check(Board s, Movement[] movementStrategy) {

        if (s.isOrdered(this.board)) {
            return s;
        }
        Queue<Board> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Board element = queue.poll();
            for (int i = 0; i < movementStrategy.length; i++) {

                if (element.canMove(this.board,movementStrategy[i])) {
                    Board newBoard = new Board(this.board,element);
                    newBoard.move(movementStrategy[i]);
                    queue.add(newBoard);
                }
                if (element.isOrdered(this.board)) {
                    return element;
                }
            }
        }

        return null;
    }
}
