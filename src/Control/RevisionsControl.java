/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.Revision;
import Classes.User;
import View.Desktop;
import static View.ViewEditUser.user;

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
}
