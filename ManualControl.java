/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinocontroller;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Nick
 */
public class ManualControl extends javax.swing.JFrame {

    /**
     * Creates new form ManualControl
     */
    public ManualControl() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mcButtonPump = new javax.swing.JButton();
        mcSolonoid2Button = new javax.swing.JButton();
        mcSolonoid1Button = new javax.swing.JButton();
        mcSolonoid3Button = new javax.swing.JButton();
        mcSolonoid4Button = new javax.swing.JButton();
        eStopButton = new javax.swing.JButton();
        manualControlButton = new javax.swing.JButton();
        eStopResetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Arduino Manual Control:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Pump Enable: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enable Solonoid 1:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Enable Solonoid 2:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Enable Solonoid 3:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("EMERGENCY STOP:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Enable Solonoid 4:");

        mcButtonPump.setText("Disabled");
        mcButtonPump.setEnabled(false);
        mcButtonPump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcButtonPumpActionPerformed(evt);
            }
        });

        mcSolonoid2Button.setText("Disabled");
        mcSolonoid2Button.setEnabled(false);
        mcSolonoid2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcSolonoid2ButtonActionPerformed(evt);
            }
        });

        mcSolonoid1Button.setText("Disabled");
        mcSolonoid1Button.setEnabled(false);
        mcSolonoid1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcSolonoid1ButtonActionPerformed(evt);
            }
        });

        mcSolonoid3Button.setText("Disabled");
        mcSolonoid3Button.setEnabled(false);
        mcSolonoid3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcSolonoid3ButtonActionPerformed(evt);
            }
        });

        mcSolonoid4Button.setText("Disabled");
        mcSolonoid4Button.setEnabled(false);
        mcSolonoid4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcSolonoid4ButtonActionPerformed(evt);
            }
        });

        eStopButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eStopButton.setText("ESTOP");
        eStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eStopButtonActionPerformed(evt);
            }
        });

        manualControlButton.setText("Disabled");
        manualControlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualControlButtonActionPerformed(evt);
            }
        });

        eStopResetButton.setText("Reset EStop");
        eStopResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eStopResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eStopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eStopResetButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manualControlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mcSolonoid2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mcSolonoid3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mcButtonPump, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mcSolonoid1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mcSolonoid4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manualControlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mcButtonPump))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(mcSolonoid1Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mcSolonoid2Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(mcSolonoid3Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(mcSolonoid4Button))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eStopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eStopResetButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void manualControlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualControlButtonActionPerformed
       
        Variables.isManualControlEnabled = !Variables.isManualControlEnabled;
        if(Variables.isManualControlEnabled)
        {
            SerialTest.serialWrite("[SEND]manualControl=1");
            mcButtonPump.setEnabled(true);
            mcSolonoid1Button.setEnabled(true);
            mcSolonoid2Button.setEnabled(true);
            mcSolonoid3Button.setEnabled(true);
            mcSolonoid4Button.setEnabled(true);
            manualControlButton.setText("Enabled");
            MainFrame.printStringToConsole("[INFO] Manual Control Enabled.");
            MainFrame.printStringToConsole("- Normal Operation has Been Paused.");
        }
        else
        {
            SerialTest.serialWrite("[SEND]manualControl=0");
            mcButtonPump.setEnabled(false);
            mcSolonoid1Button.setEnabled(false);
            mcSolonoid2Button.setEnabled(false);
            mcSolonoid3Button.setEnabled(false);
            mcSolonoid4Button.setEnabled(false);
            manualControlButton.setText("Disabled");
            MainFrame.printStringToConsole("[INFO] Manual Control Disabled.");
            MainFrame.printStringToConsole("- Normal Operation has Been Resumed.");
        }
    }//GEN-LAST:event_manualControlButtonActionPerformed

    private void eStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eStopButtonActionPerformed
        
        SerialTest.serialWrite("[SEND]STOP=1");
    }//GEN-LAST:event_eStopButtonActionPerformed

    private void eStopResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eStopResetButtonActionPerformed
        
        SerialTest.serialWrite("[SEND]STOP=0");
    }//GEN-LAST:event_eStopResetButtonActionPerformed

    private void mcButtonPumpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcButtonPumpActionPerformed
       
        if(Variables.mcRelay1Enabled || Variables.mcRelay2Enabled || Variables.mcRelay3Enabled || Variables.mcRelay4Enabled)
        {
            Variables.mcPumpEnabled = !Variables.mcPumpEnabled;
            if(Variables.mcPumpEnabled == true)
            {
                SerialTest.serialWrite("[SEND]pumpEnable=1");
                MainFrame.printStringToConsole("[INFO] Pump Enabled.");
                mcButtonPump.setText("Enabled");
            }
            else
            {
                SerialTest.serialWrite("[SEND]pumpEnable=0");
                MainFrame.printStringToConsole("[INFO] Pump Disabled.");
                mcButtonPump.setText("Disabled");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Relay 1, 2, 3 or 4 Must Be Enabled\nBefore Using This Feature");
        }
    }//GEN-LAST:event_mcButtonPumpActionPerformed

    private void mcSolonoid1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcSolonoid1ButtonActionPerformed

        Variables.mcRelay1Enabled = !Variables.mcRelay1Enabled; 
        if(Variables.mcRelay1Enabled)
        {
            SerialTest.serialWrite("[SEND]relay1Enable=1");
            MainFrame.printStringToConsole("[INFO] Relay 1 Enabled.");
            mcSolonoid1Button.setText("Enabled");
        }
        else
        {
            SerialTest.serialWrite("[SEND]relay1Enable=0");
            MainFrame.printStringToConsole("[INFO] Relay 1 Disabled.");
            mcSolonoid1Button.setText("Disabled");
        }
    }//GEN-LAST:event_mcSolonoid1ButtonActionPerformed

    private void mcSolonoid2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcSolonoid2ButtonActionPerformed
        
        Variables.mcRelay2Enabled = !Variables.mcRelay2Enabled; 
        if(Variables.mcRelay2Enabled)
        {
            SerialTest.serialWrite("[SEND]relay2Enable=1");
            MainFrame.printStringToConsole("[INFO] Relay 2 Enabled.");
            mcSolonoid2Button.setText("Enabled");
        }
        else
        {
            SerialTest.serialWrite("[SEND]relay2Enable=0");
            MainFrame.printStringToConsole("[INFO] Relay 2 Disabled.");
            mcSolonoid2Button.setText("Disabled");
        }
    }//GEN-LAST:event_mcSolonoid2ButtonActionPerformed

    private void mcSolonoid3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcSolonoid3ButtonActionPerformed
        
        Variables.mcRelay3Enabled = !Variables.mcRelay3Enabled; 
        if(Variables.mcRelay3Enabled)
        {
            SerialTest.serialWrite("[SEND]relay3Enable=1");
            MainFrame.printStringToConsole("[INFO] Relay 3 Enabled.");
            mcSolonoid3Button.setText("Enabled");
        }
        else
        {
            SerialTest.serialWrite("[SEND]relay3Enable=0");
            MainFrame.printStringToConsole("[INFO] Relay 3 Disabled.");
            mcSolonoid3Button.setText("Disabled");
        }
    }//GEN-LAST:event_mcSolonoid3ButtonActionPerformed

    private void mcSolonoid4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcSolonoid4ButtonActionPerformed
        
        Variables.mcRelay4Enabled = !Variables.mcRelay4Enabled; 
        if(Variables.mcRelay4Enabled)
        {
            SerialTest.serialWrite("[SEND]relay4Enable=1");
            MainFrame.printStringToConsole("[INFO] Relay 4 Enabled.");
            mcSolonoid4Button.setText("Enabled");
        }
        else
        {
            SerialTest.serialWrite("[SEND]relay4Enable=0");
            MainFrame.printStringToConsole("[INFO] Relay 4 Disabled.");
            mcSolonoid4Button.setText("Disabled");
        }
    }//GEN-LAST:event_mcSolonoid4ButtonActionPerformed

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManualControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ManualControl().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton eStopButton;
    public static javax.swing.JButton eStopResetButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JButton manualControlButton;
    public static javax.swing.JButton mcButtonPump;
    public static javax.swing.JButton mcSolonoid1Button;
    public static javax.swing.JButton mcSolonoid2Button;
    public static javax.swing.JButton mcSolonoid3Button;
    public static javax.swing.JButton mcSolonoid4Button;
    // End of variables declaration//GEN-END:variables
}