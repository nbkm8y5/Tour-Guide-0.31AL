package data_access_layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Andy.
 * This class is fully functional. Do not modify unless you know what you are doing.
 */
public class DatabaseRead {

    databaseConnection db;
    private String query;
    ResultSet resultSet;

    //when databaseRead is instantiated it gets the singleton instance from dbConnection. Andy

    /**
     *
     */
    public DatabaseRead() {
        db = db.getInstance();
    }

    /**
     * gets a list of tours (ids) user has created, given username.
     *
     * @param username
     * @return array of tour ids corresponding to user
     */
    public ArrayList<Integer> getTours(String username) {
        query = "select tour_id from `User` as u INNER JOIN Create_Tour as c ON u.user_id = c.user_id WHERE username = " + "'" + username + "'";
        ArrayList<Integer> idArray = new ArrayList<>();

        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            while (resultSet.next()) {
                idArray.add(resultSet.getInt("tour_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idArray;
    }


    /**
     * @param username
     * @return
     */
    public int getUserId(String username) {
        query = "select user_id from User where username = " + "'" + username + "'";
        int id = 0;
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            resultSet.next();
            id = resultSet.getInt("user_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * @param username
     * @return
     */
    public String getPassword(String username) {
        query = "select password from User where username = " + "'" + username + "'";
        String passComparison = "";
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            resultSet.next();
            passComparison = resultSet.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passComparison;
    }

    /**
     * @param username
     * @return
     */
    public String getFirstName(String username) {
        query = "select first_name from User where username = " + "'" + username + "'";
        String firstname = "";
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            resultSet.next();
            firstname = resultSet.getString("first_name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firstname;
    }

    /**
     * @param username
     * @return
     */
    public String getLastName(String username) {
        query = "select last_name from User where username = " + "'" + username + "'";
        String lastname = "";
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            resultSet.next();
            lastname = resultSet.getString("last_name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastname;
    }

    /**
     * @param email
     * @return
     */
    public boolean checkEmail(String email) {
        query = "select * from User where email = " + "'" + email + "'";
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            resultSet.next();
            if (resultSet.getString("email") == null)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    /**
     * @param username
     * @return
     */
    public String getEmail(String username) {
        query = "select email from User where username = " + "'" + username + "'";
        String email = "";
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            resultSet.next();
            email = resultSet.getString("email");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    /**
     * @param tourId
     * @return
     */
    public ArrayList<Object> getTourById(int tourId) {
        ArrayList<Object> tour = new ArrayList<>();
        query = "select * from Tour where tour_id = " + "'" + tourId + "'";
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            while (resultSet.next()) {
                tour.add(resultSet.getObject("name"));
                tour.add(resultSet.getObject("description"));
                tour.add(resultSet.getObject("city"));
                tour.add(resultSet.getObject("state"));
                tour.add(resultSet.getObject("zipcode"));
                tour.add(resultSet.getObject("date"));
                tour.add(resultSet.getObject("address_line1"));
                tour.add(resultSet.getObject("apartment_number"));
                tour.add(resultSet.getObject("time"));
            }
            //email = resultSet.getString("first_name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tour;
    }

    /**
     * @param userId
     * @return
     */
    public ArrayList<Integer> userFollowTours(int userId) {
        ArrayList<Integer> followTours = new ArrayList<>();
        query = "select * from Signup_Tour where user_id = " + "'" + userId + "'";
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            while (resultSet.next()) {
                followTours.add(resultSet.getInt("tour_id"));
            }
            //email = resultSet.getString("first_name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return followTours;
    }
}
