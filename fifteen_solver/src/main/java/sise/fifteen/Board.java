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

    public void setFields(int[][] fields) {
        this.fields = fields;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean move(Movement move) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (fields[x][y] == 0) {
                    switch (move) {
                        case R:
                            if (y + 1 < height) {
                                int tmp = fields[x][y + 1];
                                fields[x][y] = tmp;
                                fields[x][y + 1] = 0;
                                return true;
                            } else {
                                return false;
                            }
                        case L:
                            if (y - 1 >= 0) {
                                int tmp = fields[x][y - 1];
                                fields[x][y] = tmp;
                                fields[x][y - 1] = 0;
                                return true;
                            } else {
                                return false;
                            }
                        case D:
                            if (x + 1 < height) {
                                int tmp = fields[x + 1][y];
                                fields[x][y] = tmp;
                                fields[x + 1][y] = 0;
                                return true;
                            } else {
                                return false;
                            }
                        case U:
                            if (x - 1 >= 0) {
                                int tmp = fields[x - 1][y];
                                fields[x][y] = tmp;
                                fields[x - 1][y] = 0;
                                return true;
                            } else {
                                return false;
                            }
                    }
                }
            }
        }
        return false;
    }

    public boolean isOrdered() {

        int expectedValue = 1;
        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                if (x == width - 1 && y == height - 1) {
                    if (fields[x][y] != 0) {
                        return false;
                    }
                } else {
                    if (fields[x][y] != expectedValue) {
                        return false;
                    }
                }
                expectedValue++;
            }
        }
        return true;
    }
}

