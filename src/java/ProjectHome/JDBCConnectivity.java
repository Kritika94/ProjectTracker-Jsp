package ProjectHome;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kritika
 */
import java.sql.*;
public class JDBCConnectivity {
    public static Connection  cn1=null;
    public static PreparedStatement ps;
    public static void Connect(){
     try
       {
           Class.forName("com.mysql.jdbc.Driver");
            cn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/cumin", "root", "123456");
             
       }catch(Exception e){System.out.println(e);}
           }
    
    
}
