package sise.fifteen;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS extends StrategyBlind {
    public DFS(State state) {
        super(state);
    }

    @Override
    public int getReachedDepth() {
        return super.getReachedDepth();
    }

    @Override
    public void setReachedDepth(int reachedDepth) {
        super.setReachedDepth(reachedDepth);
    }

    @Override
    public long getStartTime() {
        return super.getStartTime();
    }

    @Override
    public void setStartTime(long startTime) {
        super.setStartTime(startTime);
    }

    @Override
    public long getEndTime() {
        return super.getEndTime();
    }

    @Override
    public void setEndTime(long endTime) {
        super.setEndTime(endTime);
    }

    @Override
    public State getState() {
        return super.getState();
    }

    @Override
    public void setState(State state) {
        super.setState(state);
    }

    @Override
    public Board getBoard() {
        return super.getBoard();
    }

    @Override
    public void setBoard(Board board) {
        super.setBoard(board);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public boolean check() {
//        Board board = this.getBoard();
//        int width = this.getWidth();
//        int height = this.getHeight();
        State v;

        if (board.isOrdered()) {
            System.out.println("git");
            return true;
        }
//        System.out.println("zle");
//        return false;
        Stack<State> S = new Stack<>();
        Set<State> T = new HashSet<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                S.push(state);
            }
        }

        while (!S.isEmpty()) {
            v = S.pop();
            if (!T.contains(v)) {
                T.add(v);
            }


//            System.out.println(T);
//            System.out.println(v);
//        System.out.println("magia");
//        System.out.println(Arrays.deepToString(startboard));
//            System.out.println("a");
//            board.move(Movement.D,startboard,width,height);
//        System.out.println(Arrays.deepToString(startboard));
//        System.out.println("magia2");
//            if(board.isOrdered(startboard,width,height))
//            {System.out.println("git");
//
//                return true;
//
//          }
        }

        System.out.println("Aa");
        System.out.println(S);
        System.out.println("av");
        return true;
    }
}
