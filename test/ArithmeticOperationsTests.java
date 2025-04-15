import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTests {

    @DisplayName("Addition a & b")
    @Test
    public void validateAdd() {
        Assertions.assertEquals(7, ArithmeticOperations.add(3, 4));
    }

    @DisplayName("Subtract a from b")
    @Test
    public void validateSubtraction() {
        Assertions.assertEquals(5, ArithmeticOperations.subtraction(8, 3));
    }

    @DisplayName("a devide by 0")
    @Test
    public void divideException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticOperations.divide(10, 0);
        });
        Assertions.assertEquals("Деление на ноль не допустимо", exception.getMessage());
    }

    @DisplayName("a devide by b")
    @Test
    public void divideTwo() {
        Assertions.assertEquals(5, ArithmeticOperations.divide(10, 2));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
            "-1,-1,-2",
            "0,5,5"
    })
    public void validateAddParam(int a, int b, int result) {
        Assertions.assertEquals(result, ArithmeticOperations.add(a, b));
    }
}


