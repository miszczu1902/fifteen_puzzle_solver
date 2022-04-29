package sise.fifteen;

import java.util.ArrayList;
import java.util.List;

public class State implements Cloneable {
    private final Board board;
    private List<State> nextStates = new ArrayList<>();
    private final String movingOrder;
    private int depth;
    private State previousState;
    private char previousMove;

    public State(Board b, String movingOrder) {
        this.board = b;
        this.movingOrder = movingOrder;
    }

    public State(Board board, String movingOrder, int depth, char previousMove) {
        this.board = board;
        this.movingOrder = movingOrder;
        this.depth = depth;
        this.previousMove = previousMove;
    }

    public Board getBoard() {
        return board;
    }

    public String getMovingOrder() {
        return movingOrder;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isGoalState() {
        return this.board.isOrdered();
    }

    public char getPreviousMove() {
        return previousMove;
    }

    public boolean isGoingBack(char potentialBack) {
        return this.getPreviousMove() == potentialBack;
    }

    public void generateNextStates(String movingOrder) throws CloneNotSupportedException {
        for (int i = 0; i < movingOrder.length(); i++) {
            char moveOperator = movingOrder.charAt(i);
            State nextState = this.clone();

            switch (moveOperator) {
                case 'L':
                    if (this.getBoard().move(Movement.L) && !this.isGoingBack(moveOperator)) {
                        nextState.board.move(Movement.L);
                        nextState.previousMove = moveOperator;
                        nextStates.add(nextState);
                    }
                case 'R':
                    if (this.getBoard().move(Movement.R) && !this.isGoingBack(moveOperator)) {
                        nextState.board.move(Movement.R);
                        nextState.previousMove = moveOperator;
                        nextStates.add(nextState);
                    }
                case 'U':
                    if (this.getBoard().move(Movement.U) && !this.isGoingBack(moveOperator)) {
                        nextState.board.move(Movement.U);
                        nextState.previousMove = moveOperator;
                        nextStates.add(nextState);
                    }
                case 'D':
                    if (this.getBoard().move(Movement.D) && !this.isGoingBack(moveOperator)) {
                        nextState.board.move(Movement.D);
                        nextState.previousMove = moveOperator;
                        nextStates.add(nextState);
                    }
            }
            nextState.previousState = this;
        }
    }

    @Override
    protected State clone() throws CloneNotSupportedException {
        return new State(this.getBoard(), this.getMovingOrder(), this.getDepth(), this.getPreviousMove());
    }
}
