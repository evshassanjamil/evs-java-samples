package evs.labs.w401Assgnmt;

/**
 * Class to execute/consume the system's functionality, owner can execute the functionality inside
 * {@link TestW401Assignment#main(String[])} function mentioned in the
 * <a href="https://drive.google.com/open?id=13uDnJkMPYw4H3h64Vz5N7T92SW8nTfje">assignment</a>
 */
public class TestW401Assignment {

    private static String dbPath = "E:\\Development\\Workspaces\\IntellijWorkspace\\SampleJavaProject\\db\\main.db";

    /**
     * Function to test the functionality of the system in console
     */
    public static void main(String[] args) {
        String message = "";
        DBHandler db = new DBHandler(dbPath);
        FileIOHelper fsh = new FileIOHelper("C:/Users/hassanjamil/Desktop/dboutput.txt");

        /*message += db.dropDBTables();
        System.out.println(message);*/

        // CREATING/INSERT ROWS IN TABLES
        //message += db.createDBTables();
        /*message += db.insert(new Product(1, "Pepsico", "Pepsi", "1950", "ISB",
                1, "Pepsi", "Beverage", 30, "250ml",
                "2015-12-01", "B", "2016-02-01"));
        message += db.insert(new Product(2, "Loreal", "Shampoo", "1975", "RWP",
                2, "Loreal", "Beverage", 350, "Daily Use 300ml",
                "2016-12-02", "A", "2017-02-01"));
        message += db.insert(new Product(1, 3, "Pepsi", "Beverage", 50, "500ml",
                "2017-12-03", "C", "2018-02-01"));
        message += db.insert(new Product(1, 4, "Lays", "Junk Food", 30, "Small Pack",
                "2018-11-04", "D", "2019-03-01"));*/
        //System.out.println(message);

        // ASSIGNMENT REQUIREMENTS
        message += db.changeStoreTag("SaveMart");
        message += db.getAllProductsForCompanyName("Pepsico");
        message += db.getAllProductsForLessPrice(50);
        message += db.getAllProductsForAddedDate("2017-12-03");
        message += db.getAllProductsForAddedDateInADateRange("2015-12-01", "2018-12-30");
        message += db.getAllProductsExpiredTillDate("2019-03-02");
        System.out.println(message);
        fsh.writeFile(message.getBytes());

        // UPDATE & DELETE
        /*message += db.update(new Product(3, "Slice"));
        message += db.delete(3);
        System.out.println(message);*/
    }
}
