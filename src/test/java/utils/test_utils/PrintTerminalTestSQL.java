package utils.test_utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintTerminalTestSQL {
    private final static String formatModelRamScreenStr = "%5s | %6s | %6s\n";
    private final static String formatModelRamScreenDec = "%5d | %6d | %6d\n";
    private final static String formatMakerSTR = "%5s\n";
    private final static String formatSpeedPriceStr = "%5s | %8s\n";
    private final static String formatSpeedPriceDec = "%5d | %8f\n";

    public static void printModelRamScreen(ResultSet result, String text) throws SQLException {
        System.out.println("\n"+text);
        System.out.format(formatModelRamScreenStr, "MODEL","RAM","SCREEN");
        while (result.next())
            System.out.format(formatModelRamScreenDec, result.getInt(1),  result.getInt(2),result.getInt(3));
    }

    public static void printMaker(ResultSet result, String text) throws SQLException {
        System.out.println("\n"+text);
        System.out.println( "MAKER");
        while (result.next())
            System.out.format(formatMakerSTR, result.getObject(1).toString());
    }

    public static void printSpeedPrice(ResultSet result, String text) throws SQLException {
        System.out.println("\n"+text);
        System.out.format(formatSpeedPriceStr, "SPEED", "PRICE_COUNT");
        while (result.next())
            System.out.format(formatSpeedPriceDec, result.getInt(1), result.getFloat(2));
    }
}
