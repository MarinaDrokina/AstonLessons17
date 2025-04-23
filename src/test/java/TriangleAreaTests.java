import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TriangleAreaTests {

    @Test
    public void validateTriangleAreaOne() {
        Assert.assertEquals(TriangleArea.calculateArea(3.0, 4.0, 5.0), 6.0);
    }

    @Test
    public void validateTriangleAreaThree() {
        Assert.assertEquals(TriangleArea.calculateArea(3.0, 4.0, 5.0), 7.0, ("calculateArea(3.0,4.0,5.0) test failed"));
    }

    @Test(dataProvider = "validateTriangleAreaParam")
    public void validateTriangleAreaParam(double a, double b) {
        Assert.assertEquals(TriangleArea.calculateArea(4.0, 4.0, a), b);
    }

    @DataProvider(name = "validateTriangleAreaParam")
    public static Object[][] validateTriangleAreaParamProvider() {
        return new Object[][]{
                {4.0, 6.93},
                {5.5, 7.99},
                {5.0, 7.81},
                {3.5, 6.29}
        };
    }

    @Ignore("Message for ignored test")
    public void ignoredTest() {
        System.out.println("Это не будет печататься");
    }
}