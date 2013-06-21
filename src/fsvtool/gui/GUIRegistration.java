/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.gui;

import fsvtool.controller.AuthentificationController;

/**
 *
 * @author WellY
 */
public class GUIRegistration extends javax.swing.JFrame {
    private AuthentificationController controller;
    public static final String CANCEL = "Abbrechen";
    public static final String REGISTER = "Anmelden";
    /**
     * Creates new form GUIRegistration
     */
    public GUIRegistration() {
        initComponents();
        setLocationRelativeTo(null);
        this.errorEmail.setVisible(false);
        this.errorEmail2.setVisible(false);
        this.errorPassword.setVisible(false);
        this.errorPassword2.setVisible(false);
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
        phoneInput = new javax.swing.JTextField();
        errorEmail = new javax.swing.JLabel();
        errorPassword = new javax.swing.JLabel();
        errorPassword2 = new javax.swing.JLabel();
        errorEmail2 = new javax.swing.JLabel();
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

        buttonRegister.setText(GUIRegistration.REGISTER);
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });
        buttonRegister.setBounds(470, 510, 120, 40);
        jLayeredPane1.add(buttonRegister, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonCancel.setText(GUIRegistration.CANCEL);
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });
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

        mailInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mailInputFocusLost(evt);
            }
        });
        mailInput.setBounds(370, 190, 280, 30);
        jLayeredPane1.add(mailInput, javax.swing.JLayeredPane.DEFAULT_LAYER);

        repeatedMailInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                repeatedMailInputFocusLost(evt);
            }
        });
        repeatedMailInput.setBounds(370, 240, 280, 30);
        jLayeredPane1.add(repeatedMailInput, javax.swing.JLayeredPane.DEFAULT_LAYER);

        passwordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordInputFocusLost(evt);
            }
        });
        passwordInput.setBounds(370, 390, 110, 30);
        jLayeredPane1.add(passwordInput, javax.swing.JLayeredPane.DEFAULT_LAYER);

        repeatedPasswordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                repeatedPasswordInputFocusLost(evt);
            }
        });
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
        phoneInput.setBounds(370, 290, 150, 30);
        jLayeredPane1.add(phoneInput, javax.swing.JLayeredPane.DEFAULT_LAYER);

        errorEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        errorEmail.setForeground(new java.awt.Color(255, 0, 51));
        errorEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorEmail.setText("!");
        errorEmail.setToolTipText("Wiederholung stimmt nicht überein oder keine Mail-Adresse eingegeben!!!");
        errorEmail.setBounds(650, 190, 20, 30);
        jLayeredPane1.add(errorEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        errorPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        errorPassword.setForeground(new java.awt.Color(255, 0, 51));
        errorPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorPassword.setText("!");
        errorPassword.setToolTipText("Keine 4-stellige Eingabe!!!");
        errorPassword.setBounds(480, 390, 20, 30);
        jLayeredPane1.add(errorPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

        errorPassword2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        errorPassword2.setForeground(new java.awt.Color(255, 0, 51));
        errorPassword2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorPassword2.setText("!");
        errorPassword2.setToolTipText("Wiederholung stimmt nicht überein!!!");
        errorPassword2.setBounds(480, 440, 20, 30);
        jLayeredPane1.add(errorPassword2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        errorEmail2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        errorEmail2.setForeground(new java.awt.Color(255, 0, 51));
        errorEmail2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorEmail2.setText("!");
        errorEmail2.setToolTipText("Wiederholung stimmt nicht überein oder keine Mail eingegeben!!!");
        errorEmail2.setBounds(650, 240, 20, 30);
        jLayeredPane1.add(errorEmail2, javax.swing.JLayeredPane.DEFAULT_LAYER);

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


    
    /**
     * @param args the command line arguments
     */

    
    public void setController(AuthentificationController ac){
        this.controller = ac;
    }
    public String getFirstNameInput(){
        return firstNameInput.getText();
    }
    
    public String getSurnameInput(){
        return surnameInput.getText();
    }
    
    public String getPhoneInput(){
        return phoneInput.getText();
    }
    
    public String getUsernameInput(){
        return usernameInput.getText();
    }
    
    public String getRepeatedMailInput(){
        return repeatedMailInput.getText();
    }
    
    public String getPasswordInput(){
        return new String(passwordInput.getPassword());
    }
    
    public String getRepeatedPasswordInput(){
        return new String(repeatedPasswordInput.getPassword());
    }
    
    public String getMailInput(){
        return mailInput.getText();
    }
    
    private boolean checkRepeatedPassword(){
        if(getRepeatedPasswordInput().equals(getPasswordInput()))
            return true;
        else
            return false;
    }
    
    private boolean checkMail(){
        if(getMailInput().contains("@") && getMailInput().contains(".")){
          if(getMailInput().indexOf("@")<(getMailInput().indexOf(".")-1))
              return true;
          else
              return false;      
        }            
        else
            return false;
    }
    
    private boolean checkPasswordLength(){
        if(getPasswordInput().length() >=4)
            return true;
        else
            return false;
    }
    
    private boolean checkRepeatedMail(){
        if(getMailInput().equals(getRepeatedMailInput()))
            return true;
        else
            return false;
    }
        //</editor-fold>
    
    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        controller.action(evt);
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void repeatedMailInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repeatedMailInputFocusLost
        this.errorEmail2.setVisible(!checkRepeatedMail());
    }//GEN-LAST:event_repeatedMailInputFocusLost

    private void passwordInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordInputFocusLost
        this.errorPassword.setVisible(!checkPasswordLength());
    }//GEN-LAST:event_passwordInputFocusLost

    private void repeatedPasswordInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repeatedPasswordInputFocusLost
        this.errorPassword2.setVisible(!checkRepeatedPassword());
    }//GEN-LAST:event_repeatedPasswordInputFocusLost

    private void mailInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailInputFocusLost
        this.errorEmail.setVisible(!checkMail());
    }//GEN-LAST:event_mailInputFocusLost

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        controller.action(evt);
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorEmail2;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorPassword2;
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
    private javax.swing.JTextField phoneInput;
    private javax.swing.JTextField repeatedMailInput;
    private javax.swing.JPasswordField repeatedPasswordInput;
    private javax.swing.JTextField surnameInput;
    private javax.swing.JLabel tipPassword;
    private javax.swing.JLabel tipRepeatedPassword;
    private javax.swing.JLabel tipUsername;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
