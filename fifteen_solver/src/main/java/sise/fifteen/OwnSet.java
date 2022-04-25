package sise.fifteen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OwnSet {
    private Set<Board> set = new HashSet<>();

    public void add(Board board) {
        set.add(board);
    }
}
