import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 38})
    public void validateFactorialParam(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        Assertions.assertEquals(result, Factorial.factorial(number));
    }
}

