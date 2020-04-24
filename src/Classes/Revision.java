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
    private String inspection;
    private String observations;
    private String state;
    private String vehicule;

    public Date getDate() {
        return date;
    }

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
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

    public String isInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String isState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Revision(String vehiculeDNI, String technician, String inspection, String observations, String state) {
        System.out.println(technician);
        this.vehicule = vehiculeDNI;
        this.technician = technician;
        this.inspection = inspection;
        this.observations = observations;
        this.state = state;
    }

}
