package sise.fifteen;

public class Board {
    private int[][] fields = new int[][]{};
    private int width;
    private int height;

    public Board() {
    }

    public Board(String params) {
        this.width = params.charAt(0);
        this.height = params.charAt(1);

        int len = params.length() - 2;
        int X = this.width - len % this.width;
        int Y = this.height - len % this.height;
        int index = 2;

        for (int x = X; x < X + width; x++) {
            for (int y = Y; y < Y + height; y++) {
                this.fields[x][y] = params.charAt(index++);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
