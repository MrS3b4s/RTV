/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.Revision;
import Classes.User;
import View.Desktop;

/**
 *
 * @author Sebas
 */
public class RevisionsControl {
    public boolean addRevision(Revision r){
        return Desktop.db.create("insert into revisions values('"+
                r.getId()+"','"+
                r.getDate()+"','"+ 
                r.getTime()+"','"+
                r.isInspection()+"','"+
                r.getObservations()+"','"+
                r.isState()+"')"
        );
    }
}
