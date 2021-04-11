/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.data.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ni.edu.uni.programacion.backend.pojo.Vehicle;

/**
 *
 * @author Sistemas-05
 */
public class ListTableModel extends AbstractTableModel implements PropertyChangeListener {
    private final List<Vehicle> data;
    private final String[] columns;

    public ListTableModel(List<Vehicle> data, String[] columns) {
        this.data = data;
        this.columns = columns;
    }
     public void add(Vehicle v){
        this.data.add(v);
    }
     
    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return columns == null ? 0 : columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            return data == null ? null : data.isEmpty() ? null : data.get(rowIndex).asArray()[columnIndex];
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
          add((Vehicle)evt.getNewValue());
        fireTableDataChanged();
    }
    
    /**
     *
     * @param row
     */
    public void removeRow(int row) {
    // remove a row from your internal data structure
    data.remove(row);
    fireTableRowsDeleted(row, row);
}
    
}
