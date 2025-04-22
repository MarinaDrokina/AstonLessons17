import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleAreaTests {

    @Test
    public void validateTriangleAreaOne() {
        Assertions.assertEquals(TriangleArea.calculateArea(3.0, 4.0, 5.0), 6.0);
    }

    @Test
    public void validateTriangleAreaTwo() {
        Assertions.assertEquals(TriangleArea.calculateArea(1.0, 2.0, 3.0), 0.0);

    }

    @Test
    public void validateTriangleAreaThree() {
        Assertions.assertEquals(TriangleArea.calculateArea(3.0, 4.0, 5.0), 7.0, ("calculateArea(3.0,4.0,5.0) test failed"));
    }

    @ParameterizedTest
    @CsvSource({
            "4.0,6.93",
            "5.5,7.99",
            "5.0,7.81",
            "3.5,6.29"
    })
    public void validateTriangleAreaParam(double a, double b) {
        Assertions.assertEquals(TriangleArea.calculateArea(4.0, 4.0, a), b);
    }

    @Ignore("Message for ignored test")
    public void ignoredTest() {
        System.out.println("Это не будет печататься");
    }
}