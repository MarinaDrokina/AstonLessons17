import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

public class FactorialTest {

    @Test
    public void validateFactorialOne() {
        Assertions.assertEquals(1, Factorial.factorial(0));
    }

    @Test
    public void validateFactorialTwo() {
        Assertions.assertEquals(1, Factorial.factorial(1));
    }

    @Test
    public void validateFactorialThee() {
        Assertions.assertEquals(120, Factorial.factorial(5));
    }

    @Test
    public void factorialNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> System.out.println(Factorial.factorial(-1)));
    }

    @Disabled("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("Это в игнор");
    }
}

