/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.Appointment;
import Classes.Vehicules;
import View.Desktop;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey
 */
public class ControlAppointments {
     int appointment = 0;

    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public boolean addAppointment(Appointment appointment, Vehicules vehicule) {
        return Desktop.db.create("insert into appointments values(null,'"
                + appointment.getDate() + "','"
                + appointment.getTime() + "','"
                + vehicule.getVehiculeDNI() + "','"
                + vehicule.getBrand() + "','"
                + vehicule.getModel() + "','"
                + vehicule.getYear() + "','"
                + vehicule.getInscriptionDate() + "','"
                + vehicule.getOwnerDNI() + "','"
                + vehicule.getOwnerName() + "')"
        );
    }

    public int verify(Appointment appoint) {
       
        try {
        ResultSet resultSet = Desktop.db.search("SELECT * FROM `appointments` where DATE='" + appoint.getDate() + "' AND HOUR= '"+appoint.getTime()+"'");
            while(resultSet.next()){
                appointment++;
                System.out.println(appointment);
            }
             System.out.println(appointment);
            return appointment;
              
        } catch (SQLException ex) {
            //Logger.getLogger(ControladorVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appointment;
    }

    public boolean verifyCarDNI(Vehicules vehicule) {
        ResultSet resultSet = Desktop.db.search("SELECT  FROM appointments where vehiculeDNI='" + vehicule.getVehiculeDNI() + "'");
        if (resultSet != null) {
            return true;
        }
        return false;
    }

}
