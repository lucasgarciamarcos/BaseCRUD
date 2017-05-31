/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 16000002533
 */
public class DBF {
    private static Connection con;

    private DBF() {
        try{
            Class.forName("org.sqlite.JDBC").newInstance();
            con = DriverManager.getConnection("jdbc:sqlite:clientes.db");
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o driver.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if(con== null) {
            new DBF();
        }
        return con;
    }
    
    public static void releseadConnection() {
        con= null;
    }    
}
