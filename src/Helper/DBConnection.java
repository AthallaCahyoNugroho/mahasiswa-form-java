/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author lenovo
 */
public class DBConnection {
static Connection con;
    
    public static Connection connection(){
        if (con == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");

                System.out.print(con + "bisa");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("error"+ex);

            }
        }
        return con;
    }
}
