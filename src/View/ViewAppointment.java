/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Appointment;
import Classes.User;
import Classes.Vehicules;
import Control.ControlAppointments;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Andrey
 */
public class ViewAppointment extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewAppointment
     */
    public static Appointment app;

    public ViewAppointment() {
        initComponents();
    }

    public ViewAppointment(Appointment apointment) {
        this.app = apointment;

        initComponents();

        txtDatecite.setDate(this.app.getDate());
        cmbhour.setSelectedItem(this.app.getTime());
        txtDNI.setText(String.valueOf(this.app.getVehicule().getVehiculeDNI()));
        txtbrand.setText(this.app.getVehicule().getBrand());
        txtOwnerDNI.setText(String.valueOf(this.app.getVehicule().getOwnerDNI()));
        txtInscription.setDate(this.app.getDate());
        txtOwnerName.setText(this.app.getVehicule().getOwnerName());
        txtmodel.setText(this.app.getVehicule().getModel());
        spinyear.setValue(this.app.getVehicule().getYear());
        btnsave.setText("Edit");

    }
    private ArrayList<Observer> observadores = new ArrayList<>();

    public void agregarObservador(Observer o) {
        this.observadores.add(o);
    }

    public void quitarObservador(Observer o) {
        this.observadores.remove(o);
    }

    public void notificarObservadores() {
        for (Observer obj : observadores) {
            obj.update(null, null);
        }
    }
    Control.VehiculesControl Vh = new Control.VehiculesControl();
    Control.ControlAppointments Ap = new ControlAppointments();
    Vehicules vehicule;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtmodel = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        txtOwnerDNI = new javax.swing.JTextField();
        spinyear = new com.toedter.calendar.JYearChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDatecite = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbhour = new javax.swing.JComboBox<>();
        txtOwnerName = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtInscription = new com.toedter.calendar.JDateChooser();
        txtbrand = new javax.swing.JTextField();

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtmodel.setEditable(false);
        txtmodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodelActionPerformed(evt);
            }
        });

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        txtOwnerDNI.setEditable(false);
        txtOwnerDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOwnerDNIActionPerformed(evt);
            }
        });

        spinyear.setDoubleBuffered(false);

        jLabel5.setText("Brand :");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("Appointments");

        jLabel6.setText("Model :");

        jLabel7.setText("Year :");

        jLabel2.setText("Date");

        jLabel8.setText("Inscription Date :");

        jLabel3.setText("Hour");

        jLabel9.setText("Owner DNI :");

        cmbhour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "15:30", "16:00", "16:30", " " }));

        txtOwnerName.setEditable(false);
        txtOwnerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOwnerNameActionPerformed(evt);
            }
        });

        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        jLabel10.setText("Owner Full Name :");

        jLabel4.setText(" Vehicle Registration");

        txtInscription.setDateFormatString("yyyy, MMM d");
        txtInscription.setEnabled(false);

        txtbrand.setEditable(false);
        txtbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbrandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDatecite, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbhour, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnsave)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addComponent(txtInscription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOwnerDNI, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtmodel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtOwnerName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(spinyear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDatecite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbhour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(spinyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtInscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOwnerDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnsave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodelActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        Appointment appointment = new Appointment();
        appointment.setVehicule(vehicule);

        String[] fecha = new SimpleDateFormat("yyyy-MM-dd").format(txtDatecite.getDate()).split("-");
        appointment.setDate(new java.sql.Date(Integer.parseInt(fecha[0]) - 1900, Integer.parseInt(fecha[1]) - 1, Integer.parseInt(fecha[2])));

        String[] hora1 = String.valueOf(cmbhour.getSelectedItem()).split(":");
        appointment.setTime(new java.sql.Time(Integer.parseInt(hora1[0]), Integer.parseInt(hora1[1]), 0));

        if (Ap.verify(appointment) != 4) {
            if (!Ap.verifyCarDNI(vehicule)) {
                if (Ap.addAppointment(appointment, vehicule)) {
                    JOptionPane.showMessageDialog(this, "Appointment successfully added.");
                    this.notificarObservadores();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Appointment added without success.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "This Car have an appointment");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sorry!\nThis schedule is full.\n Please, chage it", "Error", 0);

        }

     

    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtOwnerDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOwnerDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOwnerDNIActionPerformed

    private void txtOwnerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOwnerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOwnerNameActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        if (txtDNI != null) {
            try {
                this.vehicule = Vh.searchVehicule(txtDNI.getText());
                txtbrand.setText(vehicule.getBrand());
                txtmodel.setText(vehicule.getModel());
                spinyear.setValue(vehicule.getYear());
                txtInscription.setDate(vehicule.getInscriptionDate());
                txtOwnerDNI.setText(String.valueOf(vehicule.getOwnerDNI()));
                txtOwnerName.setText(vehicule.getOwnerName());
            } catch (Exception e) {

                int ans = JOptionPane.showConfirmDialog(null, "This Vehicule Registration don't exist.\n Do you wanna create a new car registration ?", "Error", 0);
                if (ans == 0) {
                    ViewNewVehicule vw = new ViewNewVehicule();
                    vw.setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbrandActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbhour;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JYearChooser spinyear;
    private javax.swing.JTextField txtDNI;
    private com.toedter.calendar.JDateChooser txtDatecite;
    private com.toedter.calendar.JDateChooser txtInscription;
    private javax.swing.JTextField txtOwnerDNI;
    private javax.swing.JTextField txtOwnerName;
    private javax.swing.JTextField txtbrand;
    private javax.swing.JTextField txtmodel;
    // End of variables declaration//GEN-END:variables

}
