package evs.labs.w401Assgnmt;

import java.sql.*;

/**
 * Database Handler handles DB operations
 * Reference: https://www.sqlitetutorial.net/sqlite-java
 */
public class DBHandler {
    // SQLite Connection String
    private String url = "jdbc:sqlite:";

    /**
     * Constructor to initialize {@link DBHandler} object
     *
     * @param dbPath File System's absolute path e.g. <path>/filename.db
     */
    DBHandler(String dbPath) {
        url += dbPath;
    }

    /**
     * Connect to the *.db database
     *
     * @return the {@link Connection} object
     */
    public Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Closing SQLite db connection
     */
    public void closeConnection() {
        try {
            Connection connection = connect();
            if (!connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create all queried tables in db
     */
    public String createDBTables() {
        String message;
        try {
            createTable("CREATE TABLE IF NOT EXISTS Company (\n" +
                    "    cid INTEGER PRIMARY KEY,\n" +
                    "    name TEXT NOT NULL,\n" +
                    "    brand_name VARCHAR(30),\n" +
                    "    since VARCHAR(4),\n" +
                    "    location TEXT NOT NULL\n" +
                    ")");
            createTable("CREATE TABLE IF NOT EXISTS Product (\n" +
                    "    pid INTEGER PRIMARY KEY,\n" +
                    "    cid INTEGER,\n" +
                    "    name TEXT NOT NULL,\n" +
                    "    category VARCHAR(30),\n" +
                    "    price BIGINT,\n" +
                    "    details TEXT NOT NULL,\n" +
                    "    added_date DATETIME,\n" +
                    "    added_by VARCHAR(30) NOT NULL,\n" +
                    "    expiry_date DATETIME,\n" +
                    "    FOREIGN KEY (cid) REFERENCES Company(cid)\n" +
                    ")");
            createTable("CREATE TABLE IF NOT EXISTS Store (\n" +
                    "    tag TEXT,\n" +
                    "    pid INTEGER,\n" +
                    "    FOREIGN KEY (pid) REFERENCES Product(pid)\n" +
                    ")");
            message = "DB Tables created successfully\n";
        } catch (Exception e) {
            message = e.getMessage() + "\n";
            e.printStackTrace();
        }
        return message;
    }

    public String dropDBTables() {
        String message;
        try {
            dropTable("DROP TABLE Store");
            dropTable("DROP TABLE Product");
            dropTable("DROP TABLE Company");
            message = "DB Tables dropped successfully\n";
        } catch (Exception e) {
            message = e.getMessage() + "\n";
            e.printStackTrace();
        }
        return message;
    }

    /**
     * Insert a new Product
     *
     * @param product
     */
    public String insert(Product product) {
        String message;
        try {
            if (product.getCompanyName() != null)
                insertCompany("INSERT INTO Company VALUES (?,?,?,?,?)", product.getCompany());

            insertProduct("INSERT INTO Product VALUES (?,?,?,?,?,?,?,?,?)", product);
            insertStore("INSERT INTO Store VALUES (?,?)", product);
            message = "Product inserted successfully\n";
        } catch (Exception e) {
            message = e.getMessage() + "\n";
            e.printStackTrace();
        }
        return message;
    }

    public String update(Product product) {
        String message;
        try {
            if (product.getProductId() > -1 && product.getProductName() != null) {
                updateProduct("UPDATE Product SET name = ? WHERE pid = ?", product);
            }
            message = "Product updated successfully\n";
        } catch (Exception e) {
            message = e.getMessage() + "\n";
            e.printStackTrace();
        }
        return message;
    }

    public String delete(int pid) {
        String message;
        try {
            delete("DELETE FROM Product WHERE pid = ?", pid);
            message = "Product deleted successfully\n";
        } catch (Exception e) {
            message = e.getMessage() + "\n";
            e.printStackTrace();
        }
        return message;
    }

    public String changeStoreTag(String tag) {
        String message;
        try {
            Store.tag = tag;
            Product product = new Product();
            updateStore("UPDATE Store SET tag = ?", product);
            message = "Stored Tag changed successfully\n";
        } catch (Exception e) {
            message = e.getMessage() + "\n";
            e.printStackTrace();
        }
        return message;
    }

    public String getAllProductsForCompanyName(String cName) {
        StringBuilder message = new StringBuilder();
        try {
            ResultSet resultSet = select("SELECT p.pid, p.name\n" +
                    "FROM Product p\n" +
                    "INNER JOIN Company c ON p.cid = c.cid\n" +
                    "WHERE c.name = '" + cName + "'");
            message.append("-------------------\nProducts for company name "
                    + cName + " are\n");
            while (resultSet.next()) {
                message.append(resultSet.getInt("pid")).append(",")
                        .append(resultSet.getString("name")).append(" | ");
            }
        } catch (Exception e) {
            message = new StringBuilder(e.getMessage());
            e.printStackTrace();
        }
        return message.toString() + "\n";
    }

    public String getAllProductsForLessPrice(int price) {
        StringBuilder message = new StringBuilder();
        try {
            ResultSet resultSet = select("SELECT p.pid, p.name\n" +
                    "FROM product p\n" +
                    "WHERE p.price < " + price);
            message.append("-------------------\nProducts for less price "
                    + price + " are\n");
            while (resultSet.next()) {
                message.append(resultSet.getInt("pid")).append(",")
                        .append(resultSet.getString("name")).append(" | ");
            }
        } catch (Exception e) {
            message = new StringBuilder(e.getMessage());
        }
        return message.toString() + "\n";
    }

    /**
     * Get all products added on a date
     *
     * @param addedDate String should be in format yyyy-MM-dd
     * @return
     */
    public String getAllProductsForAddedDate(String addedDate) {
        StringBuilder message = new StringBuilder();
        try {
            ResultSet resultSet = select("SELECT p.pid, p.name\n" +
                    "FROM product p\n" +
                    "WHERE p.added_date = '" + addedDate + "'");
            message.append("-------------------\nProducts for Added Date "
                    + addedDate + " are\n");
            while (resultSet.next()) {
                message.append(resultSet.getInt("pid")).append(",")
                        .append(resultSet.getString("name")).append(" | ");
            }
        } catch (Exception e) {
            message = new StringBuilder(e.getMessage());
        }
        return message.toString() + "\n";
    }

    public String getAllProductsForAddedDateInADateRange(String start, String end) {
        StringBuilder message = new StringBuilder();
        try {
            ResultSet resultSet = select("SELECT p.pid, p.name\n" +
                    "FROM product p\n" +
                    "WHERE p.added_date > '" + start + "' AND p.added_date < '" + end + "'");
            message.append("-------------------\nProducts Added in a date range from:"
                    + start + " and end:" + end + " are\n");
            while (resultSet.next()) {
                message.append(resultSet.getInt("pid")).append(",")
                        .append(resultSet.getString("name")).append(" | ");
            }
        } catch (Exception e) {
            message = new StringBuilder(e.getMessage());
        }
        return message.toString() + "\n";
    }

    public String getAllProductsExpiredTillDate(String date) {
        StringBuilder message = new StringBuilder();
        try {
            ResultSet resultSet = select("SELECT p.pid, p.name\n" +
                    "FROM product p\n" +
                    "WHERE p.expiry_date <= '" + date + "'");
            message.append("-------------------\nProducts Expired till date "
                    + date + " are\n");
            while (resultSet.next()) {
                message.append(resultSet.getInt("pid")).append(",")
                        .append(resultSet.getString("name")).append(" | ");;
            }
        } catch (Exception e) {
            message = new StringBuilder(e.getMessage());
        }
        return message.toString() + "\n";
    }

    /**
     * Create a new table in the database
     *
     * @param sql Create table SQLite query
     */
    private void createTable(String sql) {
        Connection connection;
        try {
            connection = connect();
            Statement statement = connection.createStatement();
            // Creating table
            statement.execute(sql);
            // Closing connection
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Drop table from the test database
     *
     * @param sql Drop table SQLite query
     */
    private void dropTable(String sql) {
        Connection connection;
        try {
            connection = connect();
            Statement statement = connection.createStatement();
            // Dropping table
            statement.execute(sql);
            // Closing connection
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert a new row into the Company table
     *
     * @param sql
     * @param company
     */
    private void insertCompany(String sql, Company company) {

        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, company.cid);
            statement.setString(2, company.companyName);
            statement.setString(3, company.brandName);
            statement.setString(4, company.since);
            statement.setString(5, company.location);
            int result = statement.executeUpdate();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertProduct(String sql, Product product) {
        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product.getProductId());
            statement.setInt(2, product.getCompanyId());
            statement.setString(3, product.getProductName());
            statement.setString(4, product.getCategory());
            statement.setInt(5, product.getPrice());
            statement.setString(6, product.getDetails());
            statement.setString(7, product.getAddedDate());
            statement.setString(8, product.getAddedBy());
            statement.setString(9, product.getExpiryDate());
            statement.executeUpdate();
            /*int result = statement.executeUpdate();
            if (result == 1)
                System.out.println("Inserted Product Successfully");*/
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert a new row into the Store table
     *
     * @param sql
     * @param product
     */
    public void insertStore(String sql, Product product) {

        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getStoreTag());
            statement.setInt(2, product.getProductId());
            statement.executeUpdate();
            /*int result = statement.executeUpdate();
            if (result == 1)
                System.out.println("Inserted Store Successfully");*/
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update row data of product table specified by the id
     *
     * @param sql
     * @param product
     */
    private void updateProduct(String sql, Product product) {
        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(2, product.getProductId());
            statement.setString(1, product.getProductName());
            statement.executeUpdate();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateStore(String sql, Product product) {
        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getStoreTag());
            statement.executeUpdate();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a row of product table specified by the id
     *
     * @param sql Delete SQLite query
     * @param id  product id needs to be deleted
     */
    private void delete(String sql, int id) {
        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            // set the corresponding param
            statement.setInt(1, id);
            // execute the delete statement
            statement.executeUpdate();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select all rows in the table, make sure to call {@link DBHandler#closeConnection()}
     * after consuming the {@link ResultSet}.
     */
    public ResultSet select(String sql) {
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
