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
import java.sql.Time;

public class Revision {
    private int id;
    private Date date;
    private Time time;
    private String technician;
    private boolean inspection;
    private String observations;
    private boolean state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public boolean isInspection() {
        return inspection;
    }

    public void setInspection(boolean inspection) {
        this.inspection = inspection;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Revision(int id, Date date, Time time, String technician, boolean inspection, String observations, boolean state) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.technician = technician;
        this.inspection = inspection;
        this.observations = observations;
        this.state = state;
    }
    
    
}
