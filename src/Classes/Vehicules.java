/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Andrey
 */
public class Vehicules {
    
    private String vehiculeDNI;
    private String brand;
    private String model;
    private int year;
    private Date inscriptionDate;
    private int ageVehicule;

    public int getAgeVehicule() {
        return ageVehicule;
    }

    private void setAgeVehicule(int ageVehicule) {
        Date d = new Date();
        this.ageVehicule = d.getYear()-this.getYear();
    }

    public String getVehiculeDNI() {
        return vehiculeDNI;
    }

    public void setVehiculeDNI(String vehiculeDNI) {
        this.vehiculeDNI = vehiculeDNI;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public int getOwnerDNI() {
        return ownerDNI;
    }

    public void setOwnerDNI(int ownerDNI) {
        this.ownerDNI = ownerDNI;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    private int ownerDNI;
    private String ownerName;

    public Vehicules(String vehiculeDNI, String brand, String model, int year, Date inscriptionDate, int ownerDNI, String ownerName) {
        this.vehiculeDNI = vehiculeDNI;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.inscriptionDate = inscriptionDate;
        this.ownerDNI = ownerDNI;
        this.ownerName = ownerName;
    }
    
    
    
}
