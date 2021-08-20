package utils.test_utils;

public enum TestDataRequest {
    PRICE_OVER_1000("SELECT MODEL, RAM, SCREEN FROM computer.Laptop " +
            "where PRICE > 1000;"),
    MAKER_PK_PR("SELECT DISTINCT a.MAKER " +
            "FROM Product a " +
            "INNER JOIN " +
            "(" +
            "  SELECT n.MAKER, count(DISTINCT n.MODEL) as pc_count " +
            "  FROM Product n " +
            "  JOIN PC s ON s.MODEL = n.MODEL " +
            "  group by n.MAKER " +
            ") b ON a.MAKER = b.MAKER " +
            "INNER JOIN " +
            "(" +
            "    SELECT MAKER, count(MAKER) as mc_c " +
            "FROM Product n " +
            "group by MAKER " +
            ") c ON a.MAKER = c.MAKER " +
            "where b.pc_count=c.mc_c"),
    MAKER_LAPTOP_PC("SELECT DISTINCT a.MAKER " +
            "FROM Product a " +
            "INNER JOIN" +
            "(" +
            "SELECT m.MODEL, m.SPEED " +
            "FROM PC m " +
            "WHERE m.SPEED >= 750" +
            ") c ON a.MODEL = c.MODEL and a.PTYPE = \"PC\" " +
            "WHERE EXISTS (" +
            "SELECT d.MAKER " +
            "FROM Product d " +
            "INNER JOIN" +
            "(" +
            "SELECT n.MODEL, n.SPEED " +
            "FROM Laptop n " +
            "WHERE n.SPEED >= 750 " +
            ") b ON d.MODEL = b.MODEL and d.PTYPE = \"Laptop\" " +
            "where d.MAKER=a.MAKER)"),
    SPEED_AVG_PRICE("SELECT SPEED, avg(PRICE) " +
            "FROM PC " +
            "where SPEED > 600 " +
            "group by SPEED;");

    private final String request;

    TestDataRequest(String request) {
        this.request = request;
    }

    public String getRequest() { return request; }
}
