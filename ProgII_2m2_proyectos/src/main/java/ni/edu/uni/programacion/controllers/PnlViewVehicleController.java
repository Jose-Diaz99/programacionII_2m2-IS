/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.view.frames.IFrmVehicle;
import ni.edu.uni.programacion.view.models.VehicleTableModel;
import ni.edu.uni.programacion.view.panels.PnlViewVehicles;

/**
 *
 * @author LENOVO 17
 */
public class PnlViewVehicleController {
    private IFrmVehicle iframeVehicle;
    private PnlViewVehicleController pnlViewVehicleController;
    private PnlViewVehicles pnlViewVehicles;
    private JsonVehicleDaoImpl jsonVehicleDaoImpl;
    private VehicleTableModel tblViewModel;
    private List<Vehicle> vehicles;
    private String[] HEADERS = new String[]{"StockNumber", "Year", "Make", "Model", "Style",
        "Vin", "Exterior color", "Interior color", "Miles", "Price", "Transmission", "Engine", "Image", "Status"};
    private TableRowSorter<VehicleTableModel> tblRowSorter;

    public PnlViewVehicleController(PnlViewVehicles pnlViewVehicles) {
        this.pnlViewVehicles = pnlViewVehicles;
        initComponent();
    }

    
    public VehicleTableModel getTblViewModel() {
        return tblViewModel;
    }
    
    
    private void initComponent() {
        try {
            jsonVehicleDaoImpl = new JsonVehicleDaoImpl();

            loadTable();

            pnlViewVehicles.getTxtFinder().addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    txtFinderKeyType(e);
                }
            });
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PnlViewVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PnlViewVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtFinderKeyType(KeyEvent e) {
        RowFilter<VehicleTableModel, Object> rf = null;
        rf = RowFilter.regexFilter(pnlViewVehicles.getTxtFinder().getText(),0,1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        tblRowSorter.setRowFilter(rf);
    }

    private void loadTable() throws IOException {
        vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
        tblViewModel = new VehicleTableModel(vehicles, HEADERS);
        tblRowSorter = new TableRowSorter<>(tblViewModel);

        pnlViewVehicles.getTblViewVehicle().setModel(tblViewModel);
        pnlViewVehicles.getTblViewVehicle().setRowSorter(tblRowSorter);
        
    }
    
    }
    
    

