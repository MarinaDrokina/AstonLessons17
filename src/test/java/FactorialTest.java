import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void validateFactorialOne() {
        Assert.assertEquals(Factorial.factorial(0), 1);
    }

    @Test
    public void valiateFactorialTwo() {
        Assert.assertEquals(Factorial.factorial(1), 1);
    }

    @Test
    public void validateFactorialThee() {
        Assert.assertEquals(Factorial.factorial(5), 120);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void factorialNegative() {
        throw new IllegalArgumentException();
    }

    @Ignore("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("Это в игнор");
    }
}