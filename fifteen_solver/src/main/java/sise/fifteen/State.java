//package sise.fifteen;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class State implements Cloneable {
//    private final Board board;
//    private List<State> nextStates = new ArrayList<>();
//    private final String movingOrder;
//    private int depth;
//    private State previousState;
//    private char previousMove;
//
//    public State(Board b, String movingOrder) {
//        this.board = b;
//        this.movingOrder = movingOrder;
//    }
//
//    public State(Board board, String movingOrder, int depth, char previousMove) {
//        this.board = board;
//        this.movingOrder = movingOrder;
//        this.depth = depth;
//        this.previousMove = previousMove;
//    }
//
//    public Board getBoard() {
//        return board;
//    }
//
//    public String getMovingOrder() {
//        return movingOrder;
//    }
//
//    public int getDepth() {
//        return depth;
//    }
//
//    public List<State> getNextStates() {
//        return nextStates;
//    }
//
//    public boolean isGoalState() {
//        return this.board.isOrdered();
//    }
//
//    public char getPreviousMove() {
//        return previousMove;
//    }
//
//    public boolean isGoingBack(char potentialBack) {
//        return this.getPreviousMove() == potentialBack;
//    }
//
//    public void generateNextStates() throws CloneNotSupportedException {
//        for (int i = 0; i < this.movingOrder.length(); i++) {
//            if (this.depth == 20) {
//                return;
//            }
//            char moveOperator = this.movingOrder.charAt(i);
//            //System.out.println(moveOperator);
//            State nextState = this.clone();
//
//            switch (moveOperator) {
//                case 'L':
//                    if (this.getBoard().move(Movement.L) ) {
//                        clone2(Collections.singletonList(this.getBoard().getFields()));
//
//                    } break;
//                case 'R':
//                    if (this.getBoard().move(Movement.R) ) {
//
//                    } break;
//                case 'U':
//                    if (this.getBoard().move(Movement.U)) {
//
//                    } break;
//                case 'D':
//                    if (this.getBoard().move(Movement.D)) {
//
//                    } break;
//                default:
//                    continue;
//            }
//            nextState.previousMove = moveOperator;
//            nextState.depth += 1;
//            nextState.previousState = this;
//            nextStates.add(nextState);
//        }
//    }
//
//    private <T> void clone2(List<T> singletonList) {
//    }
//
//    @Override
//    protected State clone() throws CloneNotSupportedException {
//        Board newBoard = new Board();
//        newBoard.setFields(this.getBoard().getFields());
//        newBoard.setWidth(this.getBoard().getWidth());
//        newBoard.setHeight(this.getBoard().getHeight());
//        String newMovingOrder = new String(this.getMovingOrder());
//        int newDepth = this.getDepth();
//        char newPreviousMove = this.getPreviousMove();
//        return new State(newBoard, newMovingOrder, newDepth, newPreviousMove);
//    }
//
//
//
//
//}
