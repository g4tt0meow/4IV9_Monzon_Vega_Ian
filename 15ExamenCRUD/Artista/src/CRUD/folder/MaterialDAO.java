/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.folder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class MaterialDAO {
 
    public void agregar(Material m) throws Exception {
        String sql = "INSERT INTO Materiales (nombre_material, tipo, id_dibujo) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, m.getNombreMaterial());
            ps.setString(2, m.getTipo());
            ps.setInt(3, m.getIdDibujo());
            ps.executeUpdate();
        }
    }
 
    public void actualizar(Material m) throws Exception {
        String sql = "UPDATE Materiales SET nombre_material=?, tipo=?, id_dibujo=? WHERE id_material=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, m.getNombreMaterial());
            ps.setString(2, m.getTipo());
            ps.setInt(3, m.getIdDibujo());
            ps.setInt(4, m.getIdMaterial());
            ps.executeUpdate();
        }
    }
 
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM Materiales WHERE id_material=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
 
    public List<Material> listarTodos() throws Exception {
        List<Material> lista = new ArrayList<>();
        String sql = "SELECT * FROM Materiales ORDER BY id_material";
        try (Connection con = ConexionBD.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Material(
                    rs.getInt("id_material"),
                    rs.getString("nombre_material"),
                    rs.getString("tipo"),
                    rs.getInt("id_dibujo")
                ));
            }
        }
        return lista;
    }
 
    public Material buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Materiales WHERE id_material=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Material(
                    rs.getInt("id_material"),
                    rs.getString("nombre_material"),
                    rs.getString("tipo"),
                    rs.getInt("id_dibujo")
                );
            }
        }
        return null;
    }
}