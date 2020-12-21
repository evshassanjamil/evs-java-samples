package evs.labs.w4lab.jdbc;

import java.sql.ResultSet;

public class TestJDBC {
    public static void main(String[] args) {// CREATING DATABASE BY SETTING DB PATH
        String dbFilePath = "E:\\Development\\Workspaces\\IntellijWorkspace\\evs\\evs-java-samples\\db\\ProductDb.db";
        //String dbPath = "Project-Absolute-Path\\db\\ProductDb.db";
        DBHandler dbHandler = new DBHandler(dbFilePath);
        dbHandler.createNewDatabase();

        ///////// CREATE TABLE ///////////
        String create = "CREATE TABLE IF NOT EXISTS product (\n"
                + "    id INTEGER PRIMARY KEY,\n"
                + "    name TEXT NOT NULL,\n"
                + "    category VARCHAR(30),\n"
                + "    added_date DATETIME,\n"
                + "    expiry_date DATETIME\n"
                + ");";
        dbHandler.createTable(create);


        /////////// INSERT ///////////////
        String insert = "INSERT INTO product(id, name, category, added_date,  expiry_date)  VALUES(?,?,?,?,?)";
        String[] values1 = new String[]{"10", "Pepsi", "Beverages", "2020-12-21 13:06:30", "2020-12-27 13:06:30"};
        dbHandler.insert(insert, values1);
        String[] values2 = new String[]{"20", "Coca Cola", "Beverages", "2020-12-21 13:06:30", "2020-12-27 13:06:30"};
        dbHandler.insert(insert, values2);


        ////////////// SELECT ALL ///////////////
        try {
            ResultSet resultSet = dbHandler.select("SELECT * FROM product");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("category") + "\t" +
                        resultSet.getString("added_date") + "\t\t" +
                        resultSet.getString("expiry_date"));
            }
            dbHandler.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ////////////// UPDATE ROW ///////////////
        /*String update = "UPDATE product "
                + "SET name = ? "
                + "WHERE id = ?";
        String[] updateValues = new String[]{"10", "Slice Mango"};
        dbHandler.update(update, updateValues);*/

        ////////////// DELETE ROW ///////////////
        /*String delete = "DELETE FROM product WHERE id = ?";
        dbHandler.delete(delete, 10);*/
    }
}
