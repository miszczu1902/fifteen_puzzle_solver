package sise.fifteen;

import java.util.*;

public class BFS {
    private final Board board;


    public BFS(Board b) {
        this.board = b;
    }

    public Board check(Board s, Movement[] movementStrategy) {

        if (s.isOrdered()) {
            return s;
        }
        Queue<Board> queue = new LinkedList<>();
        HashSet<Board> T = new HashSet<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Board Velement = queue.poll();
            T.add(Velement);
            // w tym forze cos trzeba zmienic z tym wezlami
            //for (int n = 0; n < movementStrategy.length; n++) {
            List<Board> neighbours = Velement.neighbours(movementStrategy);
            for (Board neighbour : neighbours)
            {
                if (!T.contains(neighbour) && !queue.contains(neighbour)) {
                    if (neighbour.isOrdered()) {
                        return neighbour;
                    }
                    queue.add(neighbour);
                }

//                if (Velement.canMove(this.board,movementStrategy[i])) {
//                    Board newBoard = new Board(this.board,Velement);
//                    newBoard.move(movementStrategy[i]);
//                    queue.add(newBoard);
//                }
//                if (Velement.isOrdered(this.board)) {
//                    return Velement;
//                }
            }
        }

        return null;
    }
}
