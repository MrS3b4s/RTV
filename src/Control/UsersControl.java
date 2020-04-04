/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.User;
import View.Desktop;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sebas
 */
public class UsersControl {
    
    public boolean addUser(User user){
        return Desktop.db.add("insert into users values(null,'"+
                user.getDni()+"','"+ 
                user.getFullName()+"','"+
                user.getBirthday()+"','"+
                user.getPhoneNumber()+"','"+
                user.getEmail()+"','"+
                user.getUserName()+"','"+
                user.getPassword()+"')"
        );
    }
    
    public ArrayList usersList(){
        ArrayList<User> users = new ArrayList<>();
        ResultSet resultSet = Desktop.db.list("select * from users");
        if(resultSet != null){
            try {
                while(resultSet.next()){
                    users.add(new User(resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4), resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsersControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return users;
    }
    
    public ArrayList filterUsersListByName(String filter){
        ArrayList<User> users = new ArrayList<>();
        ResultSet resultSet = Desktop.db.list("select * from users where FullName like '%"+filter+"%'");
        if(resultSet != null){
            try {
                while(resultSet.next()){
                    users.add(new User(resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4), resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsersControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return users;
    }
    
    
}
