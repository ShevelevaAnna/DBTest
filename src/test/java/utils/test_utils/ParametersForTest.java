package utils.test_utils;
import org.testng.annotations.DataProvider;

public class ParametersForTest {
    @DataProvider(name = "SQLTestData")
    public static Object[][] SQLTestData() {
        return new Object[][]{
                {"jdbc:mysql://localhost/compDB","root","password"}
        };
    }
}
