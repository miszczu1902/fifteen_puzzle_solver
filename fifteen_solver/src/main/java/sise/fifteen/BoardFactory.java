package sise.fifteen;

public class BoardFactory {
    public static Board getBoard(int[][] fields, int width, int height) {
        return new Board(fields, width, height);
    }
}
