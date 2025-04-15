import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class FactorialTest {

    @Test
    public void validateFactorialOne() {
        Assertions.assertTrue(Factorial.factorial(0) == 1);
    }

    @Test
    public void valiateFactorialTwo() {
        Assertions.assertTrue(Factorial.factorial(1) == 1);
    }

    @Test
    public void validateFactorialThee() {
        Assertions.assertTrue(Factorial.factorial(5) == 120);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        Factorial.factorial(-1);
    }

    @Ignore("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("Это в игнор");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 8, 9, 12, 38})
    public void validateFactorialParam(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        Assertions.assertEquals(result, Factorial.factorial(number));
    }
}

