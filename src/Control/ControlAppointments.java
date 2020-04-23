/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.Appointment;
import Classes.User;
import Classes.Vehicules;
import View.Desktop;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            ResultSet resultSet = Desktop.db.search("SELECT * FROM `appointments` where DATE='" + appoint.getDate() + "' AND HOUR= '" + appoint.getTime() + "'");
            while (resultSet.next()) {
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
        ResultSet resultSet = Desktop.db.search("SELECT * FROM appointments where vehiculeDNI='" + vehicule.getVehiculeDNI() + "'");
        System.out.println(resultSet);
        try {
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlAppointments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean deleteapp(Appointment appointment){
        if(appoinmentList().size() >= 2){
            return Desktop.db.delete("delete from appointments where vehiculeDNI='"+appointment.getVehicule().getVehiculeDNI()+"'");
        }
        return false;
    }
    
    public ArrayList appoinmentList() {
        ArrayList<Appointment> a = new ArrayList<>();
        ResultSet resultSet = Desktop.db.list("select * from appointments");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    a.add(new Appointment(
                            resultSet.getDate(2),
                            resultSet.getTime(3),
                            new Vehicules(
                                    resultSet.getString(4),
                                    resultSet.getString(5),
                                    resultSet.getString(6),
                                    resultSet.getInt(7),
                                    resultSet.getDate(8),
                                    resultSet.getInt(9),
                                    resultSet.getString(10))
                    ));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsersControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return a;
    }

    public boolean updateAppointment(Appointment app, String vehiculeDNI) {
        return Desktop.db.update("update users set Date='" + app.getDate()
                + "',Hour='" + app.getTime()
                + "',vehiculeDNI='" + app.getVehicule().getVehiculeDNI()
                + "',Brand='" + app.getVehicule().getBrand()
                + "',Model='" + app.getVehicule().getModel()
                + "',Year='" + app.getVehicule().getYear()
                + "',InscriptionDate='" + app.getVehicule().getInscriptionDate()
                + "',OwnerDNI=" + app.getVehicule().getOwnerDNI()
                + "',OwnerName=" + app.getVehicule().getOwnerName()
                + " where vehiculeDNI='" + vehiculeDNI + "'"
        );
    }

    public Appointment searchAppointment(String dni) {

        ResultSet resultSet = Desktop.db.search("SELECT * FROM `appointments` where vehiculeDNI='" + dni + "'");
        if (resultSet != null) {
            try {
                resultSet.next();
                return new Appointment(
                        resultSet.getDate(2),
                        resultSet.getTime(3),
                        new Vehicules(
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getDate(8),
                                resultSet.getInt(9),
                                resultSet.getString(10))
                );
            } catch (SQLException ex) {
                System.out.println(ex);
//                Logger.getLogger(UsersControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
