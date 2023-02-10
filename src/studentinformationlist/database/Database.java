/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationlist.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class Database 
{
    
    String url="jdbc:mysql://localhost/studentinformationlist? user=root & password=root";
    Connection conn;
    static Database db;
    private Database() throws SQLException
    {
        connect();
    }
    
    public static Database getInstance() throws SQLException{
        if(db==null){
        db=new Database();
        }
        return db;
    }
    
    private boolean connect() throws SQLException
    {
        conn=DriverManager.getConnection(url);
        return true;
    }
    
    public Connection getConnection(){
        return conn;
    }
}
