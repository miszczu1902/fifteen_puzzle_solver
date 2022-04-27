package sise.fifteen;

import java.util.List;

public class State {
    private final Board board;
    private List<State> nextStates;
    private List<State> previousStates;
    private Movement movement;
    private String movementList;
    public State(Board b) {
        this.board = b;
    }

    public Board getBoard() {
        return board;
    }

}
