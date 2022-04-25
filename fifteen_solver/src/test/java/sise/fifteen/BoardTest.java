package sise.fifteen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private final String content ="441234567891011013141512";
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(content);
    }

    @Test
    void getWidth() {
        assertEquals(board.getWidth(), 4);
    }

    @Test
    void getHeight() {
        assertEquals(board.getHeight(), 4);
    }
}