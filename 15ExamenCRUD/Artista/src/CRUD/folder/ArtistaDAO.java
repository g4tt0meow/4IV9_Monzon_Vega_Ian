package CRUD.folder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {

    public void agregar(Artista a) throws Exception {
        String sql = "INSERT INTO Artistas (nombre, edad, experiencia) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getEdad());
            ps.setString(3, a.getExperiencia());
            ps.executeUpdate();
        }
    }

    public void actualizar(Artista a) throws Exception {
        String sql = "UPDATE Artistas SET nombre=?, edad=?, experiencia=? WHERE id_artista=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getEdad());
            ps.setString(3, a.getExperiencia());
            ps.setInt(4, a.getIdArtista());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM Artistas WHERE id_artista=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Artista> listarTodos() throws Exception {
        List<Artista> lista = new ArrayList<>();
        String sql = "SELECT * FROM Artistas ORDER BY id_artista";
        try (Connection con = ConexionBD.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Artista(
                    rs.getInt("id_artista"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("experiencia")
                ));
            }
        }
        return lista;
    }

    public Artista buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Artistas WHERE id_artista=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Artista(
                    rs.getInt("id_artista"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("experiencia")
                );
            }
        }
        return null;
    }
}