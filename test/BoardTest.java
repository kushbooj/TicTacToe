import com.company.Board;
import com.company.Player;
import org.junit.*;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void shouldReturnTrueWhenMoveIsValid() {
        Board board = new Board();

        assertTrue(board.move(Player.X, 2,1));
    }

    @Test
    public void shouldReturnFalseWhenThePositionGivenIsNegative() {
        Board board = new Board();

        assertFalse(board.move(Player.X, -2, -7));
    }

    @Test
    public void shouldReturnFalseWhenThePositionGivenIsMoreThanTheBoardSize() {
        Board board = new Board();

        assertFalse(board.move(Player.X, 4, 100));
    }

    @Test
    public void shouldReturnThePlayerAtGivenPosition() {
        Board board = new Board();
        int y = 1, x = 2;
        board.move(Player.X, x, y);

        assertEquals(board.playerAt(x, y), Player.X);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnNullPointerExceptionWhenTheGivenPositionIsInvalid() {
        Board board = new Board();

        board.playerAt(-2,200);
    }

    @Test
    public void shouldReturnNullIfNoPlayerIsAtTheGivenPosition() {
        Board board = new Board();
        int y = 1, x = 2;

        assertNull(board.playerAt(x, y));
    }

    @Test(expected = ArrayStoreException.class)
    public void shouldThrowExceptionWhenTheGivenPositionIsAlreadyOccupied() {
        Board board = new Board();
        int x = 2;
        int y = 2;
        board.move(Player.X, x, y);

        board.move(Player.O, x, y);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotMakeTwoMovesBySamePlayer() {
        Board board = new Board();

        board.move(Player.O, 2, 1);
        board.move(Player.O, 1, 1);
    }

    @Test
    public void shouldReturnTrueWhenMovesMadeByAlternatePlayers() {
        Board board = new Board();

        board.move(Player.O, 2, 1);
        assertTrue(board.move(Player.X, 1, 1));
        assertTrue(board.move(Player.O, 0, 1));
    }

    @Test
    public void shouldReturnThePlayerWhoHasWon() {

        Board board = new Board();

        board.move(Player.O, 2, 1);
        board.move(Player.X, 0, 1);
        board.move(Player.O, 2, 0);
        board.move(Player.X, 1, 1);
        board.move(Player.O, 2, 2);

        assertTrue(board.whoWon());
    }
}
