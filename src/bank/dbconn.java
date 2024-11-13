package bank;

import java.sql.*;

public class dbconn {
    Connection connection;
    java.sql.Statement statement;

    public dbconn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmsDb","root","root_password");
            statement = connection.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
