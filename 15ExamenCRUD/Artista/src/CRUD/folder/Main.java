package CRUD.folder;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        if (!ConexionBD.probarConexion()) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos Dibujo");
            return;
        }

        ArtistaDAO artistaDAO   = new ArtistaDAO();
        DibujoDAO  dibujoDAO    = new DibujoDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        DibujoVista vista       = new DibujoVista();

        new DibujoControlador(artistaDAO, dibujoDAO, materialDAO, vista);

        vista.setVisible(true);
    }
}