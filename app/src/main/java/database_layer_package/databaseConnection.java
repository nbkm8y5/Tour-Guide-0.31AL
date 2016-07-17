package database_layer_package;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by Ale on 6/17/2016.
 */
public class databaseConnection extends AsyncTask<String, String, Boolean> {

    private static databaseConnection db = null; //instance of this class
    private static Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String query;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://mysql.toury.greasyhacks.com/toury_app";
    private String username = "toury";
    private String password = "cen4010team5";
    private boolean flag = false;

    //protected constructor for singleton pattern. prevents instantiation from other classes.
    protected databaseConnection(){}

    @Override
    public Boolean doInBackground(String... params) {

    String username = params[0];
    String password = params[1];

        if (connection == null)
            DbConnection();

        return flag;
    }
    /**
     * connects to http://www.freesqldatabase.com/ database and retrieves the
     * information
     */
    public void DbConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            Log.e("@@mytag,", "Connected!");
            flag = true;
        } catch (Exception e) {
            Log.e("@@mytag,", "ERROR" + e);
            flag = false;
        }

    }
    //This is old code. Unneeded
    /*public void getData() {
        try {
            query = "select * from User";
            resultSet = statement.executeQuery(query);

            //System.out.println("Records from database:");
            while (resultSet.next()) {
                String name = resultSet.getString("user_name");
                String age = resultSet.getString("password");
                //System.out.println("UserName: "+ name+" Password: "+ age);
                Log.e("@mytag,", "UserName: " + name + " Password: " + age);

            }

        } catch (Exception e) {
            // System.out.println(e.getMessage());
            Log.e("@@mytag,", " " + e);

        }

    }//end getData()

    public boolean checkAccount(String username, String password) {

        query = "select password from User where username = " + "'" + username + "'";
        String passComparison = "";

        try {
            resultSet = statement.executeQuery(query);

            resultSet.next();
            passComparison = resultSet.getString("password");

            //Log.e("e @@@@@@@@@@@@@@@@@@", "passComparison: @@@@@@@@@@@@@ : " + passComparison);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passComparison.equals(password);
    }*/

    //global point of access to get instance of this class. if it's null creates an instance. (only 1 instance possible)
    public static databaseConnection getInstance() {
        if (db == null)
            db = new databaseConnection();
        return db;
    }
    public void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getCon()  {
        return connection;
    }

}
