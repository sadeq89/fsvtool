/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahmet
 */
public class GamesTableModell extends AbstractTableModel {
    private GameProvider gp;
    
    private String[] columnNames = new String [] {
        "Auswählen", "Anzahl Spieler", "Datum/Uhrzeit", "Ort", "Teilname"
    };
    
    protected Class<?>[] dataTypes = new Class[]{
        Boolean.class, String.class, String.class, String.class, String.class, String.class
    };
    private List<IGame> list;

    
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
        return this.gp.getCount();
    }


    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (this.list == null) {
            this.setValues();
        }
        switch (columnIndex) {
            case 0:
                // Checkbox
                return false;
            case 1:
                // Anzahl Spieler
                return this.list.get(rowIndex).getPlayerCount();
            case 2:
                // Datum
                return this.list.get(rowIndex).getDate();
            case 3:
                // Ort
                return this.list.get(rowIndex).getLocation();
            case 4:
                return this.list.get(rowIndex).isInGame();
        }
        return null;
    }
    
    private void setValues() {
        list = gp.getAllGames();
    }
}
