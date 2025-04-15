import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComparingNumTests {
    @Test
    @DisplayName("The Second is less than the First")
    public void validateCompareOne() {
        Assertions.assertEquals(1, ComparingNum.numericComparison(3, 2));
    }

    @Test
    @DisplayName("The First is less than the Second")
    public void validateCompareTwo() {
        Assertions.assertEquals(-1, ComparingNum.numericComparison(2, 4));
    }

    @Test
    @DisplayName("The First number is equal to the Second")
    public void validateCompareThee() {
        Assertions.assertEquals(0, ComparingNum.numericComparison(4, 4));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,0",
            "2,3,-1",
            "-8,-6,-1",
            "8,6,1"
    })
    public void validateCompareParam(int first, int second, int result) {
        Assertions.assertEquals(result, ComparingNum.numericComparison(first, second));
    }
}
