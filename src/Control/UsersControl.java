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
        return Desktop.db.create("insert into users values(null,'"+
                user.getDni()+"','"+ 
                user.getFullName()+"','"+
                user.getBirthday()+"','"+
                user.getPhoneNumber()+"','"+
                user.getEmail()+"','"+
                user.getUserName()+"','"+
                user.getPassword()+"',"+
                user.getUserType()+")"
        );
    }
    
    public boolean updateUser(User user, String userName){
        return Desktop.db.update("update users set DNI='"+user.getDni()
        +"',FullName='"+user.getFullName()
        +"',Birthday='"+user.getBirthday()
        +"',PhoneNumber='"+user.getPhoneNumber()
        +"',Email='"+user.getEmail()
        +"',User='"+user.getUserName()
        +"',Password='"+user.getPassword()
        +"',Technician="+user.getUserType()
        +" where User='"+userName+"'"
        );
    }
    
    public User searchUser(String userName){
        ResultSet resultSet = Desktop.db.search("SELECT * FROM `users` where User='"+userName+"'");
        if(resultSet != null){
            try {
                resultSet.next();
                return new User(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4), resultSet.getInt(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getBoolean(9)
                );
            } catch (SQLException ex) {
                System.out.println(ex);
//                Logger.getLogger(UsersControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return null;
    }
    
    public boolean deleteUser(User user){
        if(usersList().size() >= 2){
            return Desktop.db.delete("delete from users where User='"+user.getUserName()+"'");
        }
        return false;
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
                    resultSet.getString(8),
                    resultSet.getBoolean(9)
                    ));
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
                    resultSet.getString(8),
                    resultSet.getBoolean(9)
                    ));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsersControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return users;
    }
    
    
}
