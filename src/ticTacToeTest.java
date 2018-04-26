import static org.junit.jupiter.api.Assertions.*;

class ticTacToeTest {
    @org.junit.jupiter.api.Test
    void addX() {
        TicTacToe ticTacToeHelp = new TicTacToe(5);
        ticTacToeHelp.addX(3,4);
        assertEquals(ticTacToeHelp.get(3,4), TicTacToe.Field.X);
    }
    @org.junit.jupiter.api.Test
    void addO() {
        try {
            TicTacToe ticTacToeHelp = new TicTacToe(1);
            ticTacToeHelp.addO(3,4);
            assertEquals(ticTacToeHelp.get(3,4), TicTacToe.Field.O);
        } catch (IllegalArgumentException e){}
    }

    @org.junit.jupiter.api.Test
    void clean() {
        TicTacToe ticTacToeHelp = new TicTacToe(5);
        ticTacToeHelp.addO(3,4);
        ticTacToeHelp.clean(3,4);
        assertEquals(ticTacToeHelp.get(3,4),null);
    }

    @org.junit.jupiter.api.Test
    void checkO() {
        TicTacToe ticTacToeHelp = new TicTacToe(5);
        ticTacToeHelp.addO(1,1);
        ticTacToeHelp.addO(2,1);
        ticTacToeHelp.addO(3,1);
        int[] O = {1,1,3,1};
        assertArrayEquals(O, ticTacToeHelp.checkO());
    }

    @org.junit.jupiter.api.Test
    void checkX() {
        TicTacToe ticTacToeHelp = new TicTacToe(5);
        ticTacToeHelp.addX(1,1);
        ticTacToeHelp.addX(2,2);
        ticTacToeHelp.addX(3,3);
        ticTacToeHelp.addX(4,4);
        int[] X = {4, 4, 1, 1};
        assertArrayEquals(X, ticTacToeHelp.checkX());
    }
}