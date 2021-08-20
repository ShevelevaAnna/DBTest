package tests.usecases;

import org.testng.annotations.Test;
import utils.SQLUtils;
import utils.test_utils.ParametersForTest;
import utils.test_utils.PrintTerminalTestSQL;
import utils.test_utils.TestDataRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BDTest {
    /**
     * 1)Найдите номер модели, объем памяти и размеры экранов ПК-блокнотов, цена которых превышает 1000 дол.
     * 2)Найти тех производителей ПК, все модели ПК которых имеются в таблице PC.
     * 3) Найдите производителей, которые производили бы как ПК со скоростью не менее 750 МГц,
     * так и ПК-блокноты со скоростью не менее 750 МГц.
     * Вывести: Maker
     * 4)Для каждого значения скорости ПК, превышающего 600 МГц, определите среднюю цену ПК с такой же скоростью.
     * Вывести: speed, средняя цена.
     *
     *
     *
     * 
     */
    @Test (dataProvider = "SQLTestData", dataProviderClass = ParametersForTest.class)
    private void test(String url, String username, String password) throws SQLException {
        ResultSet result = SQLUtils.sqlRequest(url, username, password, TestDataRequest.PRICE_OVER_1000.getRequest());
        PrintTerminalTestSQL.printModelRamScreen(result,"Request 1");

        result = SQLUtils.sqlRequest(url, username, password, TestDataRequest.MAKER_PK_PR.getRequest());
        PrintTerminalTestSQL.printMaker(result, "Request 2");

        result = SQLUtils.sqlRequest(url, username, password, TestDataRequest.MAKER_LAPTOP_PC.getRequest());
        PrintTerminalTestSQL.printMaker(result, "Request 3");

        result = SQLUtils.sqlRequest(url, username, password, TestDataRequest.SPEED_AVG_PRICE.getRequest());
        PrintTerminalTestSQL.printSpeedPrice(result, "Request 4");
    }
}
