import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticOperationsTests {

    @Test(description = "Addition a & b")
    public void validateAdd() {
        Assert.assertEquals(7, ArithmeticOperations.add(3, 4));
    }

    @Test(description = "Subtract a from b")
    public void validateSubtraction() {
        Assert.assertEquals(5, ArithmeticOperations.subtraction(8, 3));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void divideException() {
        ArithmeticOperations.divide(10, 0);
    }

    @Test(description = "a devide by b")
    public void divideTwo() {
        Assert.assertEquals(5, ArithmeticOperations.divide(10, 2));
    }

    @DataProvider(name = "validateAddParam")
    public static Object[][] validateAddParamProvider() {
        return new Object[][]{
                {1, 1, 2},
                {2, 3, 5},
                {-1, -1, -2},
                {0, 5, 5}
        };
    }

    @Test(dataProvider = "validateAddParam")
    public void validateAddParam(int a, int b, int result) {
        Assert.assertEquals(result, ArithmeticOperations.add(a, b));
    }
}