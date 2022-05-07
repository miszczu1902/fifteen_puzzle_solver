//package sise.fifteen;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class Graph {
//
//    private Map<Board, List<Board>> map = new HashMap<>();
//
//    public void addVertex(Board s) {
//        map.put(s, new LinkedList<Board>());
//    }
//
//    // This function adds the edge
//    // between source to destination
//    public void addEdge(Board source,
//                        Board destination,
//                        boolean bidirectional) {
//
//        if (!map.containsKey(source))
//            addVertex(source);
//
//        if (!map.containsKey(destination))
//            addVertex(destination);
//
//        map.get(source).add(destination);
//        if (bidirectional) {
//            map.get(destination).add(source);
//        }
//    }
//
//    // This function gives the count of vertices
//    public void getVertexCount() {
//        System.out.println("The graph has "
//                + map.keySet().size()
//                + " vertex");
//    }
//
//    // This function gives the count of edges
//    public void getEdgesCount(boolean bidirection) {
//        int count = 0;
//        for (Board v : map.keySet()) {
//            count += map.get(v).size();
//        }
//        if (bidirection == true) {
//            count = count / 2;
//        }
//        System.out.println("The graph has "
//                + count
//                + " edges.");
//    }
//
//    // This function gives whether
//    // a vertex is present or not.
//    public void hasVertex(Board s) {
//        if (map.containsKey(s)) {
//            System.out.println("The graph contains "
//                    + s + " as a vertex.");
//        } else {
//            System.out.println("The graph does not contain "
//                    + s + " as a vertex.");
//        }
//    }
//
//    // This function gives whether an edge is present or not.
//    public void hasEdge(Board s, Board d) {
//        if (map.get(s).contains(d)) {
//            System.out.println("The graph has an edge between "
//                    + s + " and " + d + ".");
//        } else {
//            System.out.println("The graph has no edge between "
//                    + s + " and " + d + ".");
//        }
//    }
//}
