package data_access_layer;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by Andy (SpeedGrapher)
 * Fully implemented. DO NOT CHANGE ANYTHING HERE.
 */
public class databaseConnection { //extends AsyncTask<String, String, Boolean> { //not needed.

    private static databaseConnection db = null; //instance of this class
    private static Connection connection;
    private Statement statement;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://mysql.toury.greasyhacks.com/toury_app";
    private String username = "toury";
    private String password = "cen4010team5";
    private boolean flag = false;

    //protected constructor for singleton pattern. prevents instantiation from other classes.

    /**
     *
     */
    protected databaseConnection() {
    }

    /**
     * @return
     */
    public Boolean connect() {
        if (connection == null)
            DbConnection();
        return flag;
    }
    /*@Override
    public Boolean doInBackground(String... params) {

    String username = params[0];
    String password = params[1];

        if (connection == null)
            DbConnection();

        return flag;
    }*/

    /**
     * connects to http://www.freesqldatabase.com/ database and retrieves the
     * information
     */
    public void DbConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            Log.e("@@mytag,", "Established connection with the server!");
            flag = true;
        } catch (Exception e) {
            Log.e("@@mytag,", "ERROR" + e);
            flag = false;
        }

    }

    //global point of access to get instance of this class. if it's null creates an instance. (only 1 instance possible)

    /**
     * @return
     */
    public static databaseConnection getInstance() {
        if (db == null)
            db = new databaseConnection();
        return db;
    }

    /**
     *
     */
    public void disconnect() {
        try {
            statement.close();
            Log.e("@Disconnection,", "Succesfully Logged Out!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public Connection getCon() {
        return connection;
    }

}
