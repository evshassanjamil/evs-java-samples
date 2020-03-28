package evs.labs.w4lab.jdbc;

import java.sql.*;

/**
 * Database Handler handles DB operations
 * Reference: https://www.sqlitetutorial.net/sqlite-java
 */
class DBHandler {
    // SQLite Connection String
    private String url = "jdbc:sqlite:";

    /**
     * Constructor to initialize {@link DBHandler} object
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
     * Create a new table in the database
     * @param sql Create table SQLite query
     */
    public void createTable(String sql) {
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
     * @param sql Drop table SQLite query
     */
    public void dropTable(String sql) {
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
     * Insert a new row into the product table
     * @param sql
     * @param values
     */
    public void insert(String sql, String[] values) {

        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(values[0]));
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            statement.setString(4, values[3]);
            statement.setString(5, values[4]);
            int result = statement.executeUpdate();
            if (result == 1)
                System.out.println("Inserted Successfully");
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update row data of product table specified by the id
     * @param sql
     * @param values
     */
    public void update(String sql, String[] values) {
        try {
            Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            // set the corresponding param
            statement.setString(1, values[1]);
            statement.setInt(2, Integer.valueOf(values[0]));
            // update
            statement.executeUpdate();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a row of product table specified by the id
     * @param sql Delete SQLite query
     * @param id product id needs to be deleted
     */
    public void delete(String sql, int id) {
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
    public ResultSet selectAll(String sql) {
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
