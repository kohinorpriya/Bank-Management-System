import java.sql.*;
public class Connect {
    Connection c;
    Statement s;

    public Connect(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement1", "root", "kohinor");
            s = c.createStatement();

        } catch (Exception e){
            System.out.println(e);

        }

    }
}