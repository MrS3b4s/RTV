/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Classes.Vehicules;
import Classes.Vehicules;
import View.Desktop;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juergen Segura
 */
public class VehiculesControl {
    
    public boolean addVehicule(Vehicules vehicule){
        return Desktop.db.create("insert into vehicules values(null,'"+
                vehicule.getVehiculeDNI()+"','"+
                vehicule.getBrand()+"','"+
                vehicule.getModel()+"','"+
                vehicule.getYear()+"','"+
                vehicule.getInscriptionDate()+"','"+
                vehicule.getOwnerDNI()+"','"+
                vehicule.getOwnerName()+"')"
        );
    }
    
    public Vehicules searchVehicule(String dniVehicule){
        ResultSet resultSet = Desktop.db.search("SELECT * FROM `vehicules` where vehiculeDNI='"+dniVehicule+"'");
        if(resultSet!= null){
            try{
                resultSet.next();
                return new Vehicules(resultSet.getString(2),
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        Integer.parseInt(resultSet.getString(5)), 
                        Date.valueOf(resultSet.getString(6)), 
                        Integer.parseInt(resultSet.getString(7)), 
                        resultSet.getString(8));
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }
        return null;
    }
    
    public boolean deleteVehicule(Vehicules vehicule){
        if(vehiculesList().size() >=2){
            return Desktop.db.delete("delete from vehicules where vehiculeDNI='"+vehicule.getVehiculeDNI()+"'");
        }
        return false;
    }
    
    public ArrayList vehiculesList(){
        ArrayList<Vehicules> vehicules = new ArrayList<>();
        ResultSet resultSet = Desktop.db.list("select * from vehicules");
        if(resultSet != null){
            try{
                while(resultSet.next()){
                    vehicules.add(new Vehicules(resultSet.getString(2),
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        Integer.parseInt(resultSet.getString(5)), 
                        Date.valueOf(resultSet.getString(6)), 
                        Integer.parseInt(resultSet.getString(7)), 
                        resultSet.getString(8)));
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }
        return vehicules;
    }
    
    public ArrayList filterVehiculesListByDNI(String filter){
        ArrayList<Vehicules> vehicules = new ArrayList<>();
        ResultSet resultSet = Desktop.db.list("select * from vehicules where vehiculeDNI like '%"+filter+"%'");
        if(resultSet != null){
            try{
                while(resultSet.next()){
                    vehicules.add(new Vehicules(resultSet.getString(2),
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        Integer.parseInt(resultSet.getString(5)), 
                        Date.valueOf(resultSet.getString(6)), 
                        Integer.parseInt(resultSet.getString(7)), 
                        resultSet.getString(8)));
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }
        return vehicules;
    }
    
    
    
}
