/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahmet
 */
public class GamesTableModell extends AbstractTableModel {
    private GameProvider gp;
    Object[][] obj = new Object[][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
    };
    
    private String[] columnNames = new String [] {
        "Auswählen", "Spielname", "Anzahl Spieler", "Datum/Uhrzeit", "Ort", "Teilname"
    };
    
    protected Class<?>[] dataTypes = new Class[]{
        Boolean.class, String.class, String.class, String.class, String.class, String.class
    };

    
    @Override
    public String getColumnName(int columnIndex)
    {
        return columnNames[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return dataTypes[columnIndex];
    }
    
    public GamesTableModell(GameProvider gp) {
        this.gp = gp;
    }
    
    @Override
    public int getRowCount() {
        return 6;
    }


    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return obj[rowIndex][columnIndex];
    }
    
}
