import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComparingNumTests {
    @Test(description = "The Second is less than the First")
    public void validateCompareOne() {
        Assert.assertEquals(ComparingNum.numericComparison(3, 2), 1);
    }

    @Test(description = "The First is less than the Second")
    public void validateCompareTwo() {
        Assert.assertEquals(ComparingNum.numericComparison(2, 4), -1);
    }

    @Test(description = "The First number is equal to the Second")
    public void validateCompareThee() {
        Assert.assertEquals(ComparingNum.numericComparison(4, 4), 0);
    }

    @DataProvider(name = "validateCompareParam")
    public static Object[][] validateCompareParamProvider() {
        return new Object[][]{
                {1, 1, 0},
                {2, 3, -1},
                {-8, -6, -1},
                {8, 6, 1}
        };
    }

    @Test(dataProvider = "validateCompareParam")
    public void validateCompareParam(int first, int second, int result) {
        Assert.assertEquals(result, ComparingNum.numericComparison(first, second));
    }
}