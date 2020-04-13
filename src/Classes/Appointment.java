/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Andrey
 */
public class Appointment {
    private Date date;
    private Time time;

    public Appointment() {
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

    public Appointment(Date date, Time time) {
        this.date = date;
        this.time = time;
    }
    
    
}
