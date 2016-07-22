package data_access_layer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class updates the database.
 *
 * @author Kathryn Bello - 6/30/2016
 */
public class DatabaseUpdate {

    databaseConnection conn;
    private String sql;
    PreparedStatement stmnt;

    public DatabaseUpdate() {
        conn = conn.getInstance();
    }

    /**
     * Inserts user data into the User table in the database.
     *
     * @param id
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     */
    public void createUser(int id, String userName, String password,
                           String firstName, String lastName, String email) {
        try {
            // The mysql insert statement
            sql = "INSERT INTO User("
                    + "username,"
                    + "password,"
                    + "first_name,"
                    + "last_name,"
                    + "email,"
                    + "VALUES(?,?,?,?,?)";
            stmnt = conn.getCon().prepareStatement(sql);

            // Set values
            stmnt.setString(1, userName);
            stmnt.setString(2, password);
            stmnt.setString(3, firstName);
            stmnt.setString(4, lastName);
            stmnt.setString(5, email);

            // Insert
            stmnt.executeUpdate();
            stmnt.close();

        } catch (SQLException e) {
        }
    }

    /**
     * Inserts tour data into Tour table in the database.
     *
     * @param tourId
     * @param name
     * @param desc
     * @param addr
     * @param apt
     * @param city
     * @param state
     * @param zip
     * @param date
     * @param time
     */
    public void createTour(int tourId, String name, String desc,
                           String addr, String apt, String city,
                           String state, String zip, String date, String time) {
        try {
            // The mysql insert statement
            sql = "INSERT INTO Tour("
                    + "name,"
                    + "description,"
                    + "address_line1,"
                    + "apartment_number,"
                    + "city,"
                    + "state,"
                    + "zipcode,"
                    + "date, "
                    + "time) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            stmnt = conn.getCon().prepareStatement(sql);

            // Set values
            stmnt.setString(1, name);
            stmnt.setString(2, desc);
            stmnt.setString(3, addr);
            stmnt.setString(4, apt);
            stmnt.setString(5, city);
            stmnt.setString(6, state);
            stmnt.setString(7, zip);
            stmnt.setString(8, date);
            stmnt.setString(9, time);

            // Insert
            stmnt.executeUpdate();
            stmnt.close();

        } catch (SQLException e) {
        }
    }

    /**
     * Creates a new row in the Create_Tour table in the database with the userId and tourId.
     * @param userId
     * @param tourId
     */
    public void createTour(int userId, int tourId) {
        try {
            // The mysql insert statement
            sql = "INSERT INTO Create_Tour("
                    + "user_id,"
                    + "tour_id) "
                    + "VALUES(?,?)";
            stmnt = conn.getCon().prepareStatement(sql);

            // Set values
            stmnt.setInt(1, userId);
            stmnt.setInt(2, tourId);

            // Insert
            stmnt.executeUpdate();
            stmnt.close();

        } catch (SQLException e) {
        }
    }

    /**
     * Creates a new row in the SignUp_Tour table in the database with the userId and tourId.
     *
     * @param tourId
     * @param userId
     */
    public void signUpUserTour(int userId, int tourId) {
        try {
            // The mysql insert statement
            sql = "INSERT INTO Signup_Tour("
                    + "user_id,"
                    + "tour_id) "
                    + "VALUES(?,?)";
            stmnt = conn.getCon().prepareStatement(sql);

            // Set values
            stmnt.setInt(1, userId);
            stmnt.setInt(2, tourId);

            // Insert
            stmnt.executeUpdate();
            stmnt.close();

        } catch (SQLException e) {
        }
    }

    /**
     * Deletes a row from Tour, Signup_Tour and Create_Tour table in the database.
     *
     * @param tourId
     */
    public void cancelTour(int tourId) {
        try {
            // The mysql insert statement
            sql = "DELETE t1, t2, t3 FROM Tour AS t1 " +
                    "INNER JOIN Create_Tour AS t2 ON t1.tour_id = t2.tour_id " +
                    "INNER JOIN Signup_Tour AS t3 ON t1.tour_id = t3.tour_id " +
                    "WHERE t1.tour_id = ?";
            stmnt = conn.getCon().prepareStatement(sql);

            // Set values
            stmnt.setInt(1, tourId);

            // Insert
            stmnt.executeUpdate();
            stmnt.close();

        } catch (SQLException e) {
        }
    }

}
