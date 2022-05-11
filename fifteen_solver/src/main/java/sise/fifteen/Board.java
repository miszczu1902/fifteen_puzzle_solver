package sise.fifteen;

import java.util.Arrays;

import java.util.List;
import java.util.Objects;

public class Board implements Comparable<Board> {
    private int[][] fields;
    private int width;
    private int height;
    private String path = "";
    private Movement previousMove;
    private int xZeroCoordinate;
    private int yZeroCoordinate;
    public int depth;

    private int heuristicValue = 0;

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
        findZero();

    }

    public Board(Board board, Board newBoard) {
        fields = new int[board.getHeight()][board.getWidth()];

        for (int i = 0; i < board.getHeight(); i++) {
            fields[i] = Arrays.copyOf(newBoard.fields[i], board.getHeight());
        }

        xZeroCoordinate = newBoard.xZeroCoordinate;
        yZeroCoordinate = newBoard.yZeroCoordinate;
        path = newBoard.path;
        depth = newBoard.depth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPath() {
        return path;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth++;
    }

    public int getHeuristicValue() {
        return heuristicValue;
    }

    public void setHeuristicValue(int heuristicValue) {
        this.heuristicValue = heuristicValue;
    }

    private int getField(int y, int x) {
        return fields[y][x];
    }

    private void setField(int y, int x, int tile) {
        fields[y][x] = tile;
    }

    private boolean ifCanMove(Movement move) {
        switch (move) {
            case U:
                if (previousMove == Movement.D) {
                    return false;
                }
                break;
            case D:
                if (previousMove == Movement.U) {
                    return false;
                }
                break;
            case L:
                if (previousMove == Movement.R) {
                    return false;
                }
                break;
            case R:
                if (previousMove == Movement.L) {
                    return false;
                }
                break;
        }
        return true;
    }

    public boolean canMove(Board board, Movement move) {
        if (!this.ifCanMove(move)) {
            return false;
        }
        switch (move) {
            case U:
                if (yZeroCoordinate != 0) {
                    return true;
                }
                break;
            case D:
                if (yZeroCoordinate != board.getHeight() - 1) {
                    return true;
                }
                break;
            case L:
                if (xZeroCoordinate != 0) {
                    return true;
                }
                break;
            case R:
                if (xZeroCoordinate != board.getWidth() - 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    public void move(Movement move) {
        switch (move) {
            case U -> {
                depth++;
                swap(yZeroCoordinate, xZeroCoordinate, (yZeroCoordinate - 1), xZeroCoordinate);
                path += "U";
                previousMove = Movement.U;


            }
            case D -> {
                depth++;
                swap(yZeroCoordinate, xZeroCoordinate, (yZeroCoordinate + 1), xZeroCoordinate);
                path += "D";
                previousMove = Movement.D;


            }
            case L -> {
                depth++;
                swap(yZeroCoordinate, xZeroCoordinate, yZeroCoordinate, (xZeroCoordinate - 1));
                path += "L";
                previousMove = Movement.L;


            }
            case R -> {
                depth++;
                swap(yZeroCoordinate, xZeroCoordinate, yZeroCoordinate, (xZeroCoordinate + 1));
                path += "R";
                previousMove = Movement.R;


            }
        }
    }

    private void swap(int y1, int x1, int y2, int x2) {
        int tmp = getField(y1, x1);

        setField(y1, x1, getField(y2, x2));
        setField(y2, x2, tmp);
        yZeroCoordinate = y2;
        xZeroCoordinate = x2;
    }

    private void findZero() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (fields[y][x] == 0) {
                    yZeroCoordinate = y;
                    xZeroCoordinate = x;
                }
            }
        }
    }

    public boolean isOrdered(Board board) {
        int expectedValue = 1;

        for (int x = 0; x < board.getWidth(); x++) {

            for (int y = 0; y < board.getHeight(); y++) {

                if (x == board.getWidth() - 1 && y == board.getHeight() - 1) {
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

    public static Movement[] setOrder(String operators) {
        Movement[] strategy = new Movement[4];

        for (int i = 0; i < operators.length(); i++) {
            char move = operators.charAt(i);

            switch (move) {
                case 'U' -> strategy[i] = Movement.U;
                case 'D' -> strategy[i] = Movement.D;
                case 'L' -> strategy[i] = Movement.L;
                case 'R' -> strategy[i] = Movement.R;
            }
        }

        return strategy;
    }

    public void calculateHeuristic(String heuristic, int depth) {
        int value = 0;

        if (Objects.equals(heuristic, "hamm")) {
            int expectedValue = 1;
            for (int x = 0; x < this.getWidth(); x++) {
                for (int y = 0; y < this.getHeight(); y++) {
                        if (fields[x][y] != expectedValue) {
                            value++;
                        }
                    expectedValue++;
                }
            }

        }
        this.heuristicValue = value + depth;
    }

    @Override
    public int compareTo(Board o) {
        if (this.getHeuristicValue() > o.getHeuristicValue()) {
            return 1;
        } else if (this.getHeuristicValue() == o.getHeuristicValue()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Board board = (Board) o;

        return Arrays.deepEquals(fields, board.fields);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(fields);
    }
}