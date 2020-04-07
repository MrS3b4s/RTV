/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey
 */
public class Salarycontrol {

    private int id;
    private String description;
    private String date;
    File SalaryFile = new File("Wages.txt");

    ArrayList<Salarycontrol> List = new ArrayList<Salarycontrol>();
    Salarycontrol object = null;

    public Salarycontrol(int id, String description) {
        this.id = id;
        this.description = description;

    }

    public Salarycontrol() {
    }

    //obtener el valor de las variables
    public int getId() {
        return this.id;

    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return this.description;

    }

    //Modificar variables
    public int setId(int n) {
        return id = n;

    }

    public String setDescription(String n) {
        return description = n;

    }

    //Zona de metodos importantes
    public void checkBd() {
        try {
            //Varialble con la ruta donde esta el archivo de la bd de los productos  
            //File FicheroProducto= new File("./Bd/productos.txt");
            //crear el fichero de base de datos de productos   
            if (!SalaryFile.exists()) {
                SalaryFile.createNewFile();
                System.out.println("BD has been created");
            } else {
                System.out.println("BD already exists");
            }
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }

    public void insertData(int id, String description) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date f = new Date();
            this.id = id;
            this.description = description;


            /* 
         * Abro el flujo de escritura, sobre el fichero con codificacion utf8
         * con la clase BufferedWriter
             */
            BufferedWriter Fwrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(SalaryFile, true), "utf-8"));
            /*Escribe en el fichero la cadena que recibe la función.  
           *el string "\r\n" significa salto de linea  y el \t significa tabulacion  */
            Fwrite.write(getId() + ",\t" + getDescription() + ",\t" + formato.format(f) + "\r\n");
            System.out.println("Data has been inserted");           //Cierra el flujo de escritura  
            Fwrite.close();

        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }

    public void FromtxttoObject() {
        try {
            String line = null;
            BufferedReader readfiles = new BufferedReader(new FileReader(SalaryFile));
            while ((line = readfiles.readLine()) != null) {
                //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el 
                //en esta parte le digo que lo separe en tokens pero ojo estos tokens son solo Strings tengo que convertirlos para poder emterlos en el objeto y trabajar con ellos
                StringTokenizer mytokens = new StringTokenizer(line, "\t");
                String id = mytokens.nextToken().trim();
                String description = mytokens.nextToken().trim();

                //transformo los tipo de String a los tipos que hace falta int double 
                int idOperate = Integer.parseInt(id);

                //lo paso al constructor para que me cree los objetos
                object = new Salarycontrol(idOperate, description);
                //lo añado al vecto para poder jugetear con el 
                List.add(object);

            }
            readfiles.close();

        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }

    public void modify(int Id, String tochange) {

        if (List.size() == 0) {
            FromtxttoObject();
        }
        for (Salarycontrol n : List) {

            if (n.getId() == Id) {
                //n.date = formato.format(f);
                n.description = tochange;
                System.out.println("=========================== SALARY =========================================================================================================================================================================================");
                System.out.println("The id is:" + n.getId() + "\t" + "The description is:" + n.getDescription() + "\t" );
                System.out.println("============================FIN==============================================================================================================================================================================================");
                break;
            } else {
                System.out.println("el producto no ha sido encontrado");
            }
        }
        save();

    }

    public void save() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date f = new Date();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(SalaryFile));
            for (Salarycontrol n : List) {
                bw.write(n.id + "\t" + n.description + "\t"+formato.format(f)+"\r\n");
            }
            bw.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }

    public String finder(int Id) {
        if (List.size() == 0) {
            FromtxttoObject();
        }
        Collections.reverse(List);
        for (Salarycontrol n : List) {

            if (n.getId() == Id) {

                System.out.println("=========================== SALARY =========================================================================================================================================================================================");
                System.out.println("The salary is :" + n.getDescription());
                System.out.println("============================FIN==============================================================================================================================================================================================");
                 return n.getDescription();

                
            } else {
                System.out.println("This Id doesn't exist ");
            }
        }
        //save();
        return null;

    }
}
