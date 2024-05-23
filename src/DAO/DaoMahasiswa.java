/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOMahasiswa;
import Model.Mahasiswa;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import Helper.DBConnection;


/**
 *
 * @author lenovo
 */
public class DaoMahasiswa implements IDAOMahasiswa{
    Connection con = DBConnection.connection();
    final String insert = "INSERT INTO tblmahasiswa(id, nim, nama, jk, alamat) VALUES (?, ?, ?, ?, ?);" ;
    final String update = "UPDATE tblmahasiswa set nim=?, nama=?, jk=?, alamat=? WHERE id = ?;";
    final String delete = "DELETE FROM tblmahasiswa WHERE id = ?;";
    final String select = "SELECT * FROM tblmahasiswa;";
    final String cariNama = "SELECT * FROM tblmahasiswa WHERE nama like ?";

    @Override
    public void insert(Mahasiswa b) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getNim());
            statement.setString(3, b.getNama());
            statement.setString(4, b.getJk());
            statement.setString(5, b.getAlamat());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Berhasil Input");
        } finally{
            try {
                statement.close();
            } catch (SQLException ex){
                System.out.println("Gagal Input");
            }
        }
    }

    @Override
    public void update(Mahasiswa b) {
    PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(update);
            statement.setString(1, b.getNim());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getJk());
            statement.setString(4, b.getAlamat());
            statement.setInt(5, b.getId());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Berhasil Update");
        } finally{
            try {
                statement.close();
            } catch (SQLException ex){
                System.out.println("Gagal Update");
            }
        }    
    }

    @Override
    public void delete(int id) {
    PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Berhasil Delete");
        } finally{
            try {
                statement.close();
            } catch (SQLException ex){
                System.out.println("Gagal Delete");
            }
        } 
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Mahasiswa>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                Mahasiswa b = new Mahasiswa();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setJk(rs.getString("jk"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lb;
    }

    @Override
    public List<Mahasiswa> getCariNama(String nama) {
        List<Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Mahasiswa>();
            PreparedStatement st = con.prepareStatement(cariNama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Mahasiswa b = new Mahasiswa();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setJk(rs.getString("jk"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lb;
    }
}
