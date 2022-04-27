package sise.fifteen;

import java.util.ArrayList;
import java.util.List;

public class State {
    private final Board board;
    private List<State> nextStates = new ArrayList<>();
    private State previousState;
    public State(Board b) {
        this.board = b;
    }

    public Board getBoard() {
        return board;
    }

}
