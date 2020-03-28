package evs.labs.w4lab.jdbc;

public class TestJDBC {
    public static void main(String[] args) {
        try {
            String dbPath = "E:\\Development\\Workspaces\\IntellijWorkspace\\SampleJavaProject\\db\\main.db";
            DBHandler db = new DBHandler(dbPath);

            ////////////// DROP TABLE ///////////////
            /*String drop = "DROP TABLE product";
            db.dropTable(drop);*/

            ////////////// CREATE TABLE ///////////////
            String create = "CREATE TABLE IF NOT EXISTS product (\n"
                    + "    id INTEGER PRIMARY KEY,\n"
                    + "    name TEXT NOT NULL,\n"
                    + "    category VARCHAR(30),\n"
                    + "    added_date DATETIME,\n"
                    + "    expiry_date DATETIME\n"
                    + ");";
            db.createTable(create);

            ////////////// INSERT ROW ///////////////
            /*String insert = "INSERT INTO product(id, name, category, added_date, expiry_date) " +
                    " VALUES(?,?,?,?,?)";
            String[] insertValues = new String[]{"1", "Pepsi", "Beverage", "2017-12-10 19:34:00",
                    "2018-12-10 19:34:00"};
            db.insert(insert, insertValues);*/

            ////////////// UPDATE ROW ///////////////
            /*String update = "UPDATE product "
                    + "SET name = ? "
                    + "WHERE id = ?";
            String[] updateValues = new String[]{"1", "Slice"};
            db.update(update, updateValues);*/

            ////////////// DELETE ROW ///////////////
            /*String delete = "DELETE FROM product WHERE id = ?";
            db.delete(delete, 1);*/

            ////////////// SELECT ROWS ///////////////
            /*ResultSet resultSet = db.selectAll("SELECT * FROM product");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("category") + "\t" +
                        resultSet.getString("added_date") + "\t" +
                        resultSet.getString("expiry_date"));
            }
            db.closeConnection();*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
