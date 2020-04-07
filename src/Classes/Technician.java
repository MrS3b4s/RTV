/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author Sebas
 */
public class Technician extends User{

    public Technician(String dni, String fullName, Date birthday, int phoneNumber, String email, String userName, String password) {
        super(dni, fullName, birthday, phoneNumber, email, userName, password);
    }

}
