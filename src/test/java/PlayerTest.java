import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    Player sut;

    @BeforeEach
    public void init() {
        System.out.println("test start");
        sut = new Player("test", 100, 10);
    }

    @AfterEach
    public void close() {
        System.out.println("test finished");
        sut = null;
    }

    @Test
    public void testGetName() {
        //arange
        String expected = "test";
        //act
        String actual = sut.getName();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetHealth() {
        //arange
        int expected = 100;
        //act
        int actual = sut.getHealth();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetHitPoints() {
        //arange
        int expected = 10;
        //act
        int actual = sut.getHitPoints();
        //assert
        assertEquals(expected, actual);
    }
}
