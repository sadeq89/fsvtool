/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.gui;

import fsvtool.controller.MainController;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.GamesTableModell;
import fsvtool.persistance.IGame;
import fsvtool.persistance.IUser;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Marcel
 */
public class GUIMainFrame extends javax.swing.JFrame {

    private MainController controller;
    public static final String NEUES_SPIEL = "Neues Spiel";
    public static final String TEILNEHMEN = "Teilnehmen";
    public static final String STORNIEREN = "Stornieren";
    public static final String EINSTELLUNGEN = "Einstellungen";
    public static final String LOGOUT = "Logout";
    public static final String MEIN_ACCOUNT = "Mein Account";
    public static final String TEAMS_ANZEIGEN = "Teams Anzeigen";
    private EntityManager em;
    private GamesTableModell tm;

    /**
     * Creates new form GUIMainFrame
     */
    public GUIMainFrame(MainController c) {
        setController(c);
        initComponents();
        initPopupMenu();
        this.tm = c.getTable();
    }

    public void setController(MainController c) {
        this.controller = c;
    }

    private void initPopupMenu() {
        pAccountPopup = new JPopupMenu();
        pAccountPopup.add(new JMenuItem(new AbstractAction("Einstellungen") {
            public void actionPerformed(ActionEvent e) {
                controller.action(e);
            }
        }));
        pAccountPopup.add(new JMenuItem(new AbstractAction("Logout") {
            public void actionPerformed(ActionEvent e) {
                controller.action(e);
            }
        }));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tTable = new javax.swing.JTable();
        bTeilnehmen = new javax.swing.JButton();
        bTeamsAnzeigen = new javax.swing.JButton();
        bNewGame = new javax.swing.JButton();
        bMeinAccount = new javax.swing.JButton();
        iBackground = new javax.swing.JLabel();
        bStornieren = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FSV tool");
        setBackground(new java.awt.Color(255, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setOpaque(true);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setToolTipText("");

        tTable.setModel(this.controller.getTable());
        tTable.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(tTable);

        jScrollPane1.setBounds(100, 60, 859, 480);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bTeilnehmen.setText(this.TEILNEHMEN);
        bTeilnehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeilnehmenActionPerformed(evt);
            }
        });
        bTeilnehmen.setBounds(100, 550, 169, 34);
        jLayeredPane1.add(bTeilnehmen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bTeamsAnzeigen.setText(this.TEAMS_ANZEIGEN);
        bTeamsAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTeamsAnzeigenActionPerformed(evt);
            }
        });
        bTeamsAnzeigen.setBounds(440, 550, 169, 34);
        jLayeredPane1.add(bTeamsAnzeigen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bNewGame.setText(GUIMainFrame.NEUES_SPIEL);
        bNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewGameActionPerformed(evt);
            }
        });
        bNewGame.setBounds(790, 550, 169, 34);
        jLayeredPane1.add(bNewGame, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bMeinAccount.setText(this.MEIN_ACCOUNT);
        bMeinAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bMeinAccountMousePressed(evt);
            }
        });
        bMeinAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMeinAccountActionPerformed(evt);
            }
        });
        bMeinAccount.setBounds(840, 10, 120, 40);
        jLayeredPane1.add(bMeinAccount, javax.swing.JLayeredPane.DEFAULT_LAYER);

        iBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fsvtool/background.png"))); // NOI18N
        iBackground.setText("jLabel1");
        iBackground.setBounds(0, 0, 990, 590);
        jLayeredPane1.add(iBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bStornieren.setText(this.STORNIEREN);
        bStornieren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStornierenActionPerformed(evt);
            }
        });
        bStornieren.setBounds(270, 550, 169, 34);
        jLayeredPane1.add(bStornieren, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTeilnehmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTeilnehmenActionPerformed
        List<IGame> gameList = new ArrayList<IGame>();        
        for (int index : tTable.getSelectedRows()) { 
            gameList.add(tm.getValue(index));
        }
        evt.setSource(gameList);
        this.controller.action(evt);
    }//GEN-LAST:event_bTeilnehmenActionPerformed

    private void bNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewGameActionPerformed
        this.controller.action(evt);
    }//GEN-LAST:event_bNewGameActionPerformed

    private void bTeamsAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTeamsAnzeigenActionPerformed
        IGame game = tm.getValue(tTable.getSelectedRow());
        evt.setSource(game);
        this.controller.action(evt);
    }//GEN-LAST:event_bTeamsAnzeigenActionPerformed

    private void bMeinAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMeinAccountActionPerformed
        
        this.controller.action(evt);
    }//GEN-LAST:event_bMeinAccountActionPerformed

    private void bMeinAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMeinAccountMousePressed
        pAccountPopup.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_bMeinAccountMousePressed

    private void bStornierenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStornierenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bStornierenActionPerformed
    private JPopupMenu pAccountPopup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bMeinAccount;
    private javax.swing.JButton bNewGame;
    private javax.swing.JButton bStornieren;
    private javax.swing.JButton bTeamsAnzeigen;
    private javax.swing.JButton bTeilnehmen;
    private javax.swing.JLabel iBackground;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTable;
    // End of variables declaration//GEN-END:variables

    public void showTeamDialog(List<IUser> team1, List<IUser> team2) {
        System.out.println("Team 1: " + team1.toString() + "/nTeam 2: " + team2.toString());
    }

    public void showNotEnoughPlayer() {
        System.out.println("Es haben sich noch nicht genügend Spieler für das Spiel angemeldet!");
    }
}
