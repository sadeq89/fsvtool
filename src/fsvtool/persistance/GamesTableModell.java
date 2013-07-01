/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahmet
 */
public class GamesTableModell extends AbstractTableModel {

    private GameProvider gp;
    private String[] columnNames = new String[]{
        "Sportart", "Anzahl Spieler", "Datum/Uhrzeit", "Ort", "Teilnahme"
    };
    protected Class<?>[] dataTypes = new Class[]{
        String.class, String.class, String.class, String.class, String.class, String.class
    };
    private List<IGame> list;
    private final DateFormat dateFormat;
    private final Calendar calendar;

    public GamesTableModell(GameProvider gp) {
        this.gp = gp;
        this.dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        this.calendar = Calendar.getInstance();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return dataTypes[columnIndex];
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
                // Sportart
                switch(this.list.get(rowIndex).getGameType()) {
                    case IGame.TYPE_VOLLEYBALL:
                        return "Volleyball";
                    case IGame.TYPE_SOCCER:
                        return "Fußball";
                    case IGame.TYPE_HANDBALL:
                        return "Handball";
                }
            case 1:
                // Anzahl Spieler
                return this.list.get(rowIndex).getPlayerInGameCount()
                        + "/" 
                        + this.list.get(rowIndex).getMaxPlayerCount();
            case 2:
                // Datum
                this.calendar.setTime(this.list.get(rowIndex).getDate());
                this.calendar.add(
                    Calendar.MILLISECOND,
                    (int) this.list.get(rowIndex).getTime().getTime()
                );
                return this.dateFormat.format(this.calendar.getTime());
            case 3:
                // Ort
                return this.list.get(rowIndex).getGameLocation();
            case 4:
                String inGame;
                if (this.list.get(rowIndex).isInGame()) {
                    inGame = "Ja";
                } else {
                    inGame = "Nein";
                }
                return inGame;
        }
        return null;
    }
    
    public IGame getValue(int index) {
         System.out.println("value" + list.get(index));   
        return list.get(index);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
        list = gp.getAllGames();
    }
    
    

    private void setValues() {
        list = gp.getAllGames();
    }
}
