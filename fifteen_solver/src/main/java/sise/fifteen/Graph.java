package sise.fifteen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Node, List<Node>> elements = new HashMap<>();

    public void addElement(Node el) {
        elements.put(el, new LinkedList<>());
    }

    public void addNeighbours(Node src, Node dst, boolean ifBidirect) {
        if (!elements.containsKey(src)) {
            addElement(src);
        }
        if (!elements.containsKey(dst)) {
            addElement(dst);
        }

        elements.get(src).add(dst);

        if (ifBidirect) {
            elements.get(dst).add(src);
        }
    }
}
