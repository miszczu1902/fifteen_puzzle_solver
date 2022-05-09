package sise.fifteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private int[][] fields;
    private int width;
    private int height;
    private String path = "";
    private int xZeroCoordinate;
    private int yZeroCoordinate;
    private Movement previousMove;


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

    public Board(int[][] fields, int width, int height) {
        this.fields = fields;
        this.width = width;
        this.height = height;
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

    }


    public int[][] getFields() {
        return fields;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isNotPreviousMove(Movement move) {
        switch (move) {
            case U:
                if (previousMove == Movement.D) {
                    return false;
                }
            case D:
                if (previousMove == Movement.U) {
                    return false;
                }
            case L:
                if (previousMove == Movement.R) {
                    return false;
                }
            case R:
                if (previousMove == Movement.L) {
                    return false;
                }
        }
        return true;
    }


    public boolean canMove(Movement move) {
        switch (move) {
            case U:
                if (xZeroCoordinate > 0) {
                    return true;
                }
            case D:
                if (xZeroCoordinate < height - 1) {
                    return true;
                }
            case L:
                if (yZeroCoordinate > 0) {
                    return true;
                }
            case R:
                if (xZeroCoordinate < height - 1) {
//                    System.out.println("Rka"+xZeroCoordinate);
//                    System.out.println("Rka"+yZeroCoordinate);
                    return true;
                }
        }
        return false;
    }


    public void move(Movement move) {
        switch (move) {
            case U -> {
//                swap(yZeroCoordinate, xZeroCoordinate, (yZeroCoordinate - 1), xZeroCoordinate);
                swap(xZeroCoordinate, yZeroCoordinate, xZeroCoordinate - 1, yZeroCoordinate);
                path += "U";
                previousMove = Movement.U;
            }
            case D -> {
//                swap(yZeroCoordinate, xZeroCoordinate, (yZeroCoordinate + 1), xZeroCoordinate);
                swap(xZeroCoordinate, yZeroCoordinate, xZeroCoordinate + 1, yZeroCoordinate);
                path += "D";
                previousMove = Movement.D;
            }
            case L -> {
//                swap(yZeroCoordinate, xZeroCoordinate, yZeroCoordinate, (xZeroCoordinate - 1));
                swap(xZeroCoordinate, yZeroCoordinate, xZeroCoordinate, yZeroCoordinate - 1);
                path += "L";
                previousMove = Movement.L;
            }
            case R -> {
//                swap(yZeroCoordinate, xZeroCoordinate, yZeroCoordinate, (xZeroCoordinate + 1));
                swap(xZeroCoordinate, yZeroCoordinate, xZeroCoordinate, yZeroCoordinate + 1);
                path += "R";
                previousMove = Movement.R;
            }
        }
    }

    private void swap(int x1, int y1, int x2, int y2) {
        int tmp = getField(x1, y1);
        setField(x1, y1, getField(x2, y2));
        setField(x2, y2, tmp);
//        System.out.println("X1y1");
//        System.out.println(this .fields[x1][y1]);
//        System.out.println("X2y2");
//        System.out.println(fields[x2][y2]);
//        int tmp = this.fields[x1][y1];
//        this.fields[x1][y1] = this.fields[x2][y2];
//        this.fields[x2][y2] = tmp;
        this.yZeroCoordinate = y2;
        this.xZeroCoordinate = x2;
    }

    private void setField(int x, int y, int tile) {
        fields[x][y] = tile;
    }

    private int getField(int x, int y) {
//        System.out.println(x + " " + y);
        return fields[x][y];
    }

    private void findZero() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (fields[x][y] == 0) {
                    xZeroCoordinate = x;
                    yZeroCoordinate = y;
                }
            }
        }
    }

    public String getPath() {
        return path;
    }


    public boolean isOrdered() {

        int expectedValue = 1;
        for (int x = 0; x < this.getWidth(); x++) {

            for (int y = 0; y < this.getHeight(); y++) {

                if (x == this.getWidth() - 1 && y == this.getHeight() - 1) {
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

    public static Movement[] setStrategy(String operators) {
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

    public List<Board> neighbours(Movement[] movementStrategy) {
        List<Board> neighbours = new ArrayList<>();

        for (int i = 0; i < movementStrategy.length; i++) {
//            System.out.println(Arrays.deepToString(this.getFields()));
//            System.out.println(this.canMove(movementStrategy[i]));
            Board newBoard = BoardFactory.getBoard(this.getFields(), this.getWidth(), this.getHeight());
            newBoard.previousMove = this.previousMove;

            if (newBoard.canMove(movementStrategy[i]) && newBoard.isNotPreviousMove(movementStrategy[i])) {
//                System.out.println(movementStrategy[i]);
                newBoard.move(movementStrategy[i]);
                neighbours.add(newBoard);
            }
        }
        return neighbours;
    }

}