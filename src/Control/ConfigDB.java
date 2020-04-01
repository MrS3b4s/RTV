/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class ConfigDB {

    private File file;
    private BufferedReader br;
//    private BufferedWriter bw;
    
    
    private String[] config;

    public void setConfig(String[] config) {
        this.config = config;
    }
    
    public String[] getConfig(){
        return this.config;
    }
    
    public ConfigDB() {
        this.file = new File("config.ini");
        this.config = new String[5];
        if (!file.exists()) {
            try {
                file.createNewFile();
                this.write("[DATA BASE]\n"
                    + "motor=\n"
                    + "ip=\n"
                    + "db=\n"
                    + "user=\n"
                    + "password=\n"
                );
            } catch (IOException ex) {
                Logger.getLogger(ConfigDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            FileReader fr = new FileReader(file);
            this.br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.fillConfig(this.config);
    }
    
    public void fillConfig(String[] parametros) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String l;
            br.readLine();
            for (int i = 0; i < 5; i++) {
                l = br.readLine();
                if(l != null){
                    parametros[i] = parametro(l);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public String parametro(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '='){
                return s.substring(i+1, s.length());
            }
        }
        return null;
    }
       
    public void saveConfig(String[] c) {
        this.write("[DATA BASE]\n"
            + "motor=" + c[0] + "\n"
            + "ip=" + c[1] + "\n"
            + "db=" + c[2] + "\n"
            + "user=" + c[3] + "\n"
            + "password=" + c[4] + "\n"
        );
    }

    public String read() {
        try {
            String l = br.readLine();
            return l;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void write(String s) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String args[]){
        ConfigDB c = new ConfigDB();
        for (int i = 0; i < c.config.length; i++) {
            System.out.println(c.config[i]);
        }
    }

}
