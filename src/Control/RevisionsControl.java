/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.Appointment;
import Classes.Revision;
import Classes.User;
import Classes.Vehicules;
import View.Desktop;
import static View.ViewEditUser.user;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 *
 * @author Sebas
 */
public class RevisionsControl {

    public boolean addRevision(Revision r) {
        System.out.println(r.getVehicule());
        System.out.println(r.getTechnician());
        System.out.println(r.isInspection());
        System.out.println(r.getObservations());
        System.out.println(r.isState());
        return Desktop.db.create("insert into checking values(null,'"+r.getVehicule()+"',CURDATE(),CURTIME(),'"+r.getTechnician()+"','"+r.isInspection()+"','"+r.getObservations()+"','"+r.isState()+"')");
    }
    public ArrayList revisionsList() {
        ArrayList<Revision> a = new ArrayList<>();
        ResultSet resultSet = Desktop.db.list("select * from checking");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    a.add( new Revision(
                            resultSet.getString(2),
                            resultSet.getDate(3),
                            resultSet.getTime(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8))
                    );
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsersControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return a;
    }
    
    public Revision searchRevision(String dniVehicule){
        ResultSet resultSet = Desktop.db.search("SELECT * FROM `checking` where DNIvehicule='"+dniVehicule+"'");
        if(resultSet!= null){
            try{
                resultSet.next();
                return new Revision(
                            resultSet.getString(2),
                            resultSet.getDate(3),
                            resultSet.getTime(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8));
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
        return null;
    }
    
    public ArrayList revisionFilter(Date date){
        ArrayList<Revision> revisions = new ArrayList<>();
        ResultSet resultSet = Desktop.db.list("select * from checking where Date='"+date+"'");
        if(resultSet != null){
            try{
                while(resultSet.next()){
                    revisions.add(new Revision(
                            resultSet.getString(2),
                            resultSet.getDate(3),
                            resultSet.getTime(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8)));
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }
        return revisions;
    }
}
