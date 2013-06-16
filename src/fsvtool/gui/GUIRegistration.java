/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.gui;

/**
 *
 * @author WellY
 */
public class GUIRegistration extends javax.swing.JFrame {

    /**
     * Creates new form GUIRegistration
     */
    public GUIRegistration() {
        initComponents();
        this.errorEmail.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        labelLogin = new javax.swing.JLabel();
        buttonRegister = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelFirstName = new javax.swing.JLabel();
        labelSurname = new javax.swing.JLabel();
        labelMail = new javax.swing.JLabel();
        labelPhone = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        labelRepeatedPassword = new javax.swing.JLabel();
        labelRepeatedMail = new javax.swing.JLabel();
        firstNameInput = new javax.swing.JTextField();
        mailInput = new javax.swing.JTextField();
        repeatedMailInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        repeatedPasswordInput = new javax.swing.JPasswordField();
        surnameInput = new javax.swing.JTextField();
        tipPassword = new javax.swing.JLabel();
        tipRepeatedPassword = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        tipUsername = new javax.swing.JLabel();
        phoneRest = new javax.swing.JTextField();
        errorEmail = new javax.swing.JLabel();
        errorPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FSVTool - Anmeldung");
        setMaximumSize(new java.awt.Dimension(850, 593));
        setMinimumSize(new java.awt.Dimension(850, 593));
        setResizable(false);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(850, 593));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(850, 593));

        labelLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelLogin.setText("Anmeldung");
        labelLogin.setBounds(370, 20, 110, 30);
        jLayeredPane1.add(labelLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonRegister.setText("Anmelden");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });
        buttonRegister.setBounds(470, 510, 120, 40);
        jLayeredPane1.add(buttonRegister, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonCancel.setText("Abbrechen");
        buttonCancel.setBounds(640, 510, 120, 40);
        jLayeredPane1.add(buttonCancel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelFirstName.setText("Vorname");
        labelFirstName.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        labelFirstName.setBounds(190, 90, 130, 30);
        jLayeredPane1.add(labelFirstName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelSurname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSurname.setText("Nachname");
        labelSurname.setBounds(190, 140, 120, 30);
        jLayeredPane1.add(labelSurname, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelMail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelMail.setText("E-Mail");
        labelMail.setBounds(190, 190, 130, 30);
        jLayeredPane1.add(labelMail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelPhone.setText("Tel.");
        labelPhone.setBounds(190, 290, 130, 30);
        jLayeredPane1.add(labelPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelPassword.setText("Kennwort");
        labelPassword.setToolTipText("Erklärung auf rechts !!!");
        labelPassword.setBounds(190, 390, 130, 30);
        jLayeredPane1.add(labelPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelRepeatedPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelRepeatedPassword.setText("Kennwort wiederholen");
        labelRepeatedPassword.setToolTipText("Erklärung auf rechts !!!");
        labelRepeatedPassword.setBounds(190, 440, 130, 30);
        jLayeredPane1.add(labelRepeatedPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelRepeatedMail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelRepeatedMail.setText("E-Mail wiederholen");
        labelRepeatedMail.setBounds(190, 240, 130, 30);
        jLayeredPane1.add(labelRepeatedMail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        firstNameInput.setBounds(370, 90, 280, 30);
        jLayeredPane1.add(firstNameInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mailInput.setBounds(370, 190, 280, 30);
        jLayeredPane1.add(mailInput, javax.swing.JLayeredPane.DEFAULT_LAYER);

        repeatedMailInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                repeatedMailInputFocusLost(evt);
            }
        });
        repeatedMailInput.setBounds(370, 240, 280, 30);
        jLayeredPane1.add(repeatedMailInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        passwordInput.setBounds(370, 390, 110, 30);
        jLayeredPane1.add(passwordInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        repeatedPasswordInput.setBounds(370, 440, 110, 30);
        jLayeredPane1.add(repeatedPasswordInput, javax.swing.JLayeredPane.DEFAULT_LAYER);
        surnameInput.setBounds(370, 140, 280, 30);
        jLayeredPane1.add(surnameInput, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tipPassword.setForeground(new java.awt.Color(153, 153, 153));
        tipPassword.setText("(Geben Sie bitte ein 4 bis 8-stelliges Kennwort ein)");
        tipPassword.setBounds(520, 390, 290, 30);
        jLayeredPane1.add(tipPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tipRepeatedPassword.setForeground(new java.awt.Color(153, 153, 153));
        tipRepeatedPassword.setText("(Wiederholen Sie bitte Ihr eingegebenes Kennwort)");
        tipRepeatedPassword.setBounds(520, 440, 290, 30);
        jLayeredPane1.add(tipRepeatedPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelUsername.setText("Benutzername");
        labelUsername.setToolTipText("Erklärung auf rechts !!!");
        labelUsername.setBounds(190, 340, 130, 30);
        jLayeredPane1.add(labelUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        usernameInput.setBounds(370, 340, 110, 30);
        jLayeredPane1.add(usernameInput, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tipUsername.setForeground(new java.awt.Color(153, 153, 153));
        tipUsername.setText("(Geben Sie bitte eine 3 bis 8-stellige Benutzername ein)");
        tipUsername.setBounds(520, 340, 320, 30);
        jLayeredPane1.add(tipUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        phoneRest.setBounds(370, 290, 150, 30);
        jLayeredPane1.add(phoneRest, javax.swing.JLayeredPane.DEFAULT_LAYER);

        errorEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        errorEmail.setForeground(new java.awt.Color(255, 0, 51));
        errorEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorEmail.setText("!");
        errorEmail.setToolTipText("Wiederholung stimmt nicht überein!!!");
        errorEmail.setBounds(650, 190, 20, 30);
        jLayeredPane1.add(errorEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        errorPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        errorPassword.setForeground(new java.awt.Color(255, 0, 51));
        errorPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorPassword.setText("!");
        errorPassword.setToolTipText("Wiederholung stimmt nicht überein!!!");
        errorPassword.setBounds(480, 390, 20, 30);
        jLayeredPane1.add(errorPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fsvtool/background.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel1.setMaximumSize(new java.awt.Dimension(850, 593));
        jLabel1.setMinimumSize(new java.awt.Dimension(850, 593));
        jLabel1.setPreferredSize(new java.awt.Dimension(850, 593));
        jLabel1.setBounds(0, 0, 850, 593);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getMailInput(){
        return mailInput.getText();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
        }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIRegistration().setVisible(true);
            }
        });
    }
    
    public String getRepeatedMailInput(){
        return repeatedMailInput.getText();
    }
    
    private boolean checkRepeatedMail(){
        if(getMailInput().equals(getRepeatedMailInput()))
            return true;
        else
            return false;
    }
        //</editor-fold>
    
    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void repeatedMailInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repeatedMailInputFocusLost
        this.errorEmail.setVisible(!checkRepeatedMail());
    }//GEN-LAST:event_repeatedMailInputFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JTextField firstNameInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel labelFirstName;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelMail;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelRepeatedMail;
    private javax.swing.JLabel labelRepeatedPassword;
    private javax.swing.JLabel labelSurname;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField mailInput;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JTextField phoneRest;
    private javax.swing.JTextField repeatedMailInput;
    private javax.swing.JPasswordField repeatedPasswordInput;
    private javax.swing.JTextField surnameInput;
    private javax.swing.JLabel tipPassword;
    private javax.swing.JLabel tipRepeatedPassword;
    private javax.swing.JLabel tipUsername;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
