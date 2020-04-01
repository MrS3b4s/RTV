/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Sebas
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public boolean connect(String[] config) {
        try {
            this.connection=DriverManager.getConnection
            ("jdbc:"+config[0]+"://"+config[1]+"/"+config[2]+"?useServerPrepStmts=true", config[3], config[4]);
            this.statement = this.connection.createStatement();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}

