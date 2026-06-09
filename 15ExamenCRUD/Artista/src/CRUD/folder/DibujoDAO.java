package CRUD.folder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DibujoDAO {

    public void agregar(Dibujo d) throws Exception {
        String sql = "INSERT INTO Dibujos (titulo, tecnica, fecha_creacion, id_artista) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getTitulo());
            ps.setString(2, d.getTecnica());
            ps.setString(3, d.getFechaCreacion());
            ps.setInt(4, d.getIdArtista());
            ps.executeUpdate();
        }
    }

    public void actualizar(Dibujo d) throws Exception {
        String sql = "UPDATE Dibujos SET titulo=?, tecnica=?, fecha_creacion=?, id_artista=? WHERE id_dibujo=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getTitulo());
            ps.setString(2, d.getTecnica());
            ps.setString(3, d.getFechaCreacion());
            ps.setInt(4, d.getIdArtista());
            ps.setInt(5, d.getIdDibujo());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM Dibujos WHERE id_dibujo=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Dibujo> listarTodos() throws Exception {
        List<Dibujo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Dibujos ORDER BY id_dibujo";
        try (Connection con = ConexionBD.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Dibujo(
                    rs.getInt("id_dibujo"),
                    rs.getString("titulo"),
                    rs.getString("tecnica"),
                    rs.getString("fecha_creacion"),
                    rs.getInt("id_artista")
                ));
            }
        }
        return lista;
    }

    public Dibujo buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Dibujos WHERE id_dibujo=?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dibujo(
                    rs.getInt("id_dibujo"),
                    rs.getString("titulo"),
                    rs.getString("tecnica"),
                    rs.getString("fecha_creacion"),
                    rs.getInt("id_artista")
                );
            }
        }
        return null;
    }
}