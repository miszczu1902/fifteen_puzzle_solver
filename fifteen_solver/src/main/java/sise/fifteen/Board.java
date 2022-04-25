package sise.fifteen;

import java.util.List;

public class Board {
    private int[][] fields;
    private int width;
    private int height;

    public Board() {
    }

    public Board(List<Integer> params) {
        this.width = params.get(0);
        this.height = params.get(1);

        int[][] tmp = new int[width][height];
        int index = 2;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tmp[x][y] = params.get(index);
                index++;
            }
        }
        this.fields = tmp;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getFields() {
        return fields;
    }

    public void move(Movement move) {
        boolean flag = false;
        System.out.println("a");

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (fields[x][y] == 0) {
                    switch (move) {
                        case R:
                            if (y + 1 < height) {
                                int tmp = fields[x][y + 1];
                                fields[x][y] = tmp;
                                fields[x][y + 1] = 0;
                            } else {
                                return;
                            }
                        case L:
                            if (y - 1 >= 0) {
                                int tmp = fields[x][y - 1];
                                fields[x][y] = tmp;
                                fields[x][y - 1] = 0;
                                System.out.println("aaaa");
                            } else {
                                return;
                            }
                    }
                    flag = true;
                    break;
                }
                if (flag) {
                    break;
                }
            }
        }
    }
}
