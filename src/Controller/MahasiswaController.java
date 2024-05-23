/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author lenovo
 */

import DAO.DaoMahasiswa;
import DAOInterface.IDAOMahasiswa;
import Model.Mahasiswa;
import Model.TabelModelMahasiswa;
import View.FormMahasiswa;
import java.util.List;
import javax.swing.JOptionPane;

public class MahasiswaController {
    FormMahasiswa frame;
    IDAOMahasiswa implMahasiswa;
    List<Mahasiswa> lb;
    
    public MahasiswaController(FormMahasiswa frame){
        this.frame = frame;
        implMahasiswa = new DaoMahasiswa();
        lb = implMahasiswa.getAll();
    }
    
    public void reset(){
        frame.getTxtID().setText("");
        frame.getTxtNim().setText("");
        frame.getTxtNama().setText("");
        frame.getTxtJk().setSelectedItem("");
        frame.getTxtAlamat().setText("");
        
    }
    
    public void isiTable()
    {
        lb = implMahasiswa.getAll();
        TabelModelMahasiswa tmb = new TabelModelMahasiswa(lb);
        frame.getTabelData().setModel(tmb);
    }
    
    public void isiField(int row) {
        frame.getTxtID().setText(lb.get(row).getId().toString());
        frame.getTxtNim().setText(lb.get(row).getNim());
        frame.getTxtNama().setText(lb.get(row).getNama());
        frame.getTxtJk().setSelectedItem(lb.get(row).getJk());
        frame.getTxtAlamat().setText(lb.get(row).getAlamat());
    }
    
    public void insert() {
        if(!frame.getTxtNim().getText().trim().isEmpty() & ! frame.getTxtNama().getText().trim().isEmpty()){
            Mahasiswa b = new Mahasiswa();
            b.setId(Integer.parseInt(frame.getTxtID().getText()));
            b.setNim(frame.getTxtNim().getText());
            b.setNama(frame.getTxtNama().getText());
            b.setJk(frame.getTxtJk().getSelectedItem().toString());
            b.setAlamat(frame.getTxtAlamat().getText());
            implMahasiswa.insert(b);
            JOptionPane.showMessageDialog(null, "Simpan Data Success");
        } else {
            JOptionPane.showConfirmDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
    public void update() {
        if(!frame.getTxtID().getText().trim().isEmpty()){
            Mahasiswa b = new Mahasiswa();
            b.setId(Integer.parseInt(frame.getTxtID().getText()));
            b.setNim(frame.getTxtNim().getText());
            b.setNama(frame.getTxtNama().getText());
            b.setJk(frame.getTxtJk().getSelectedItem().toString()); 
            b.setAlamat(frame.getTxtAlamat().getText());
            implMahasiswa.update(b);
            JOptionPane.showMessageDialog(null, "Update Data Success");
        } else {
            JOptionPane.showConfirmDialog(frame, "Pilih Data yang Diubah");
        }
    }
    public void delete() {
        if(!frame.getTxtID().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame.getTxtID().getText());
            implMahasiswa.delete(id);
            JOptionPane.showMessageDialog(null, "Delete Data Success");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih Data yang Akan Dihapus");
        }
    }
    public void isiTabelCariNama(){
        lb = implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
        TabelModelMahasiswa tmb = new TabelModelMahasiswa(lb);
        frame.getTabelData().setModel(tmb);
    }
    public void cariNama(){
        if(!frame.getTxtCariNama().getText().trim().isEmpty()){
            implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
            isiTabelCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "Silahkan Pilih Data");
        }
    }
}
