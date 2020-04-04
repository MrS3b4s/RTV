/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Sebas
 */

import java.sql.Date;

public class User {
    private String dni;
    private String fullName;
    private Date birthday;
    private int phoneNumber;
    private String email;
    private String userName;
    private String password;
    private boolean userType;

    public User(String dni, String fullName, Date birthday, int phoneNumber, String email, String userName, String password) {
        this.dni = dni;
        this.fullName = fullName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
   
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "dni=" + dni + ", fullName=" + fullName + ", birthday=" + birthday + ", phoneNumber=" + phoneNumber + ", email=" + email + ", userName=" + userName + ", password=" + password + ", userType=" + userType + '}';
    }
    
    
}
