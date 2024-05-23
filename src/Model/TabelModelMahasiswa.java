/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenovo
 */
public class TabelModelMahasiswa extends AbstractTableModel {
    List<Mahasiswa> lstMhs;
    
    public TabelModelMahasiswa (List<Mahasiswa> lstMhs){
        this.lstMhs = lstMhs;
    }
    
    @Override
    public int getRowCount() {
        return this.lstMhs.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    
    public String getColumnName(int row, int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NIM";
            case 2:
                return "Nama";
            case 3:
                return "Jenis Kelamin";
            case 4:
                return "Alamat";
            default:
                return null;
                
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lstMhs.get(rowIndex).getId();
            case 1:
                return lstMhs.get(rowIndex).getNim();
            case 2:
                return lstMhs.get(rowIndex).getNama();
            case 3:
                return lstMhs.get(rowIndex).getJk();
            case 4:
                return lstMhs.get(rowIndex).getAlamat();
            default:
                return null;
                
        }
    }
}
