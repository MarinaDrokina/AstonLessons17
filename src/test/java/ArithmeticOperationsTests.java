import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticOperationsTests {

    @Test(description = "Addition a & b")
    public void validateAdd() {
        Assert.assertEquals(ArithmeticOperations.add(3, 4), 7);
    }

    @Test(description = "Subtract a from b")
    public void validateSubtraction() {
        Assert.assertEquals(ArithmeticOperations.subtraction(8, 3), 5);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void divideException() {
        throw new IllegalArgumentException();
    }

    @Test(description = "a devide by b")
    public void divideTwo() {
        Assert.assertEquals(ArithmeticOperations.divide(10, 2), 5);
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

    @DataProvider(name = "validateMultiplyParam")
    public static Object[][] validateMultiplyParamProvider() {
        return new Object[][]{
                {5, 3, 15},
                {-2, -3, 6},
                {-1, 5, -5},
                {0, 5, 0}
        };
    }

    @Test(dataProvider = "validateMultiplyParam")
    public void validateMultiplyParam(int a, int b, int result) {
        Assert.assertEquals(result, ArithmeticOperations.multiply(a, b));
    }
}