package sise.fifteen;

import java.util.Stack;

public class OwnStack {
    private final Stack<Board> stack = new Stack<>();

    public void push(Board board) {
        stack.push(board);
    }

    public Board pop() {
        return stack.pop();
    }
}
