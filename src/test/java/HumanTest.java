import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    @ParameterizedTest
    @MethodSource("source")
    public void testAttack(Human h, Orc o, int a, int d, int k, int expected) {
        //expected
        h.attack(h, o, a, d, k);
        //act
        int actual = h.getHealth();
        //assert
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {

        Human human = new Human("Human", 50, 5);
        Orc orc = new Orc("Orc", 100, 10);

        return Stream.of(Arguments.of(human, orc, 1, 1, 0, 50),
                Arguments.of(human, orc, 1, 2, 0, 40),
                Arguments.of(human, orc, 2, 3, 0, 30),
                Arguments.of(human, orc, 3, 3, 0, 30));
    }


}
