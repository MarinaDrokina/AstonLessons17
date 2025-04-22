import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void validateFactorialOne() {
        Assert.assertTrue(Factorial.factorial(0) == 1);
    }

    @Test
    public void valiateFactorialTwo() {
        Assert.assertTrue(Factorial.factorial(1) == 1);
    }

    @Test
    public void validateFactorialThee() {
        Assert.assertTrue(Factorial.factorial(5) == 120);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void factorialNegative() {
        Factorial.factorial(-1);
    }

    @Ignore("Message for ignored test")

    @Test
    public void ignoredTest() {
        System.out.println("Это в игнор");
    }

    @DataProvider(name = "validateFactorialParam")
    public static Object[][] validateFactorialParamProvider() {
        return new Object[][]{
                {2},
                {5},
                {8},
                {9},
                {12},
                {38}
        };
    }

    @Test(dataProvider = "validateFactorialParam")
    public void validateFactorialParam(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        Assert.assertEquals(result, Factorial.factorial(number));
    }
}