
package ni.edu.uni.programacion.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.views.panels.pnlView;

public class pnlViewController  extends AbstractTableModel
{
     pnlView pnlv;
     private  Class[] tipoColumnas ;
     private String[] titleColumnas;
     private List<Vehicle> list;
     
     public List<Vehicle> getVehicle(){
         return list;
     }
     
     public void setVehicle(List<Vehicle> list){
         this.list = list;
     }

    public pnlViewController() {
       
        list = new ArrayList();
        
        this.titleColumnas = new String []{"Stock Number " , "Year ", "Make","Model","Style","Vin",
            "Exterior Color", "Interior Color","Miles","Price","Transmission","Engine","Status"};
       this.tipoColumnas = new Class[]{Integer.class , Integer.class, String.class , String.class, String.class, Integer.class
                                     , String.class, String.class , Integer.class , Integer.class, String.class , String.class ,String.class};
       
       
    }
     
     @Override
    public String getColumnName(int column){
        return titleColumnas[column];
    }
     
     @Override
    public Class<?> getColumnClass(int columnIndex){
        return tipoColumnas[columnIndex];
    }
    
     @Override
    public boolean isCellEditable(int rowindex , int columnIndex){
        return true;   
    }
  
    private void initComponent()throws FileNotFoundException{
         
    }

    @Override
    public int getRowCount() {
          return list.size();
    
    }

    @Override
    public int getColumnCount() {
             return titleColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            
            case 0 :
                 return list.get(rowIndex).getStockNumber();
            case 1 :
                 return list.get(rowIndex).getYear();
        
            case 3 :
                 return list.get(rowIndex).getMake();
            case 4 :
                 return list.get(rowIndex).getModel();
            case 5 :
                 return list.get(rowIndex).getStyle();
            case 6 :
                 return list.get(rowIndex).getVin();
            case 7 :
                 return list.get(rowIndex).getExteriorColor();
            case 8 :
                 return list.get(rowIndex).getExteriorColor();
            case 9 :
                 return list.get(rowIndex).getMiles();    
            case 10:
                  return list.get(rowIndex).getPrice();
            case 11 :
                 return list.get(rowIndex).getTransmission();
            case 12 :
                 return list.get(rowIndex).getEngine();    
        
            case 13 :
                 return list.get(rowIndex).getStatus();    
            default:
                 return null;
        }    
    }
    
     @Override
   public void setValueAt(Object aValue , int rowIndex , int columnIndex){
           switch(columnIndex){
               case 0 :
                   list.get(rowIndex).setStockNumber((int) aValue);
                   break;
               case 1 :    
                   list.get(rowIndex).setYear((int) aValue);
               case 2 :
                   list.get(rowIndex).setMake(aValue.toString());
               case 3 : 
                   list.get(rowIndex).setModel(aValue.toString());
               case 4:
                   list.get(rowIndex).setStyle(aValue.toString());
               case 5 : 
                   list.get(rowIndex).setVin(aValue.toString());
               case 6 : 
                   list.get(rowIndex).setExteriorColor(aValue.toString());
               case 7 :
                   list.get(rowIndex).setInteriorColor(aValue.toString());
               case 8 : 
                   list.get(rowIndex).setMiles(aValue.toString());
               case 9 : 
                   list.get(rowIndex).setPrice((float) aValue);
               case 10 :
                   list.get(rowIndex).setTransmission((Vehicle.Transmission) aValue);
               case 11 :
                   list.get(rowIndex).setEngine(aValue.toString());
               case 12 :
                   list.get(rowIndex).setStatus(aValue.toString());          
          }         
           this.fireTableCellUpdated(rowIndex, columnIndex);
           this.fireTableRowsUpdated(rowIndex, rowIndex);      
   }
}
