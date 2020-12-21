package evs.labs.w4lab.jdbc;

import java.sql.*;

/**
 * Database Handler handles DB operations
 * Reference: https://www.sqlitetutorial.net/sqlite-java
 */
class DBHandler {
    // SQLite Connection String
    private String mPath = "jdbc:sqlite:";

    /**
     * Constructor to initialize {@link DBHandler}
     *
     * @param dbPath Db File System's absolute path e.g. ProjectAbsolutePath/db/filename.db
     */
    DBHandler(String dbPath) {
        mPath += dbPath;
    }

    /**
     * Connect to the *.db database
     *
     * @return the {@link Connection} object
     */
    public Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(mPath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creating database by doing a try establishing connection with DB File,
     * Automatically creates new db file if not exists.
     */
    public void createNewDatabase() {
        try (Connection conn = connect()) {
            Class.forName("org.sqlite.JDBC");
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
     * Create a new table in the database
     *
     * @param query Create table SQLite query
     */
    public void createTable(String query) {
        Connection connection;
        try {
            connection = connect();
            Statement statement = connection.createStatement();
            // Creating table
            boolean result = statement.execute(query);
            if (result)
                System.out.println("Table created successfully");
            // Closing connection
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Drop table from the test database
     *
     * @param query Drop table SQLite query
     */
    public void dropTable(String query) {
        Connection connection;
        try {
            connection = connect();
            Statement statement = connection.createStatement();
            // Dropping table
            boolean result = statement.execute(query);
            if (result)
                System.out.println("Table Dropped");
            // Closing connection
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert a new row into the product table
     *
     * @param query
     * @param values
     */
    public void insert(String query, String[] values) {

        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.valueOf(values[0]));
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            statement.setString(4, values[3]);
            statement.setString(5, values[4]);
            int result = statement.executeUpdate();
            if (result == 1)
                System.out.println("Record Inserted");
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update row data of product table specified by the id
     *
     * @param query  SQL update query
     * @param values sequenced String values array
     */
    public void update(String query, String[] values) {
        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(query);
            // set the corresponding param
            statement.setString(1, values[1]);
            statement.setInt(2, Integer.parseInt(values[0]));
            // update
            int result = statement.executeUpdate();
            if (result > 0)
                System.out.println("Record Updated with id = " + values[0]);
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a row of product table specified by the id
     *
     * @param query Delete SQLite query
     * @param id    product id needs to be deleted
     */
    public void delete(String query, int id) {
        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(query);
            // set the corresponding param
            statement.setInt(1, id);
            // execute the delete statement
            int result = statement.executeUpdate();
            if (result > 0)
                System.out.println("Record deleted with id = " + result);
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select all rows in the table, make sure to call {@link DBHandler#closeConnection()}
     * after consuming the {@link ResultSet}.
     */
    public ResultSet select(String query) {
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
