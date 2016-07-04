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


    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private boolean valid = false;
    private String query;




    @Override
    protected Boolean doInBackground(String... params) {


    String username = params[0];
    String password = params[1];

    // Log.e("e @@@@@@@@@@@@@@@@@@", "pass: @@@@@@@@@@@@@ : " + password);


    if(connection == null)//check if allready connected
            this.DbConnection();
    // this.getData();


    return checkAccount(username, password);

}//end doInBackground


    /**
     * connects to http://www.freesqldatabase.com/ database and retrieves the
     * information
     */
    public void DbConnection() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);

            String url = "jdbc:mysql://mysql.toury.greasyhacks.com/toury_app";
            String username = "toury";
            String password = "cen4010team5";

            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

            //System.out.println("Connected\n");
            Log.e("@@mytag,", "Connected!");

        } catch (Exception e) {
            // System.out.println(e);
            Log.e("@@mytag,", "ERROR" + e);
        }

    }//end DbConnection


    /**
     * gets all the data
     */
    public void getData() {
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

        query = "select password from User where user_name = " + "'" + username + "'";
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
    }


}
