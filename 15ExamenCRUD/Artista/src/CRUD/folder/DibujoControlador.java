package CRUD.folder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DibujoControlador {

    private ArtistaDAO artistaDAO;
    private DibujoDAO dibujoDAO;
    private MaterialDAO materialDAO;
    private DibujoVista vista;

    public DibujoControlador(ArtistaDAO artistaDAO, DibujoDAO dibujoDAO,
                              MaterialDAO materialDAO, DibujoVista vista) {
        this.artistaDAO = artistaDAO;
        this.dibujoDAO  = dibujoDAO;
        this.materialDAO = materialDAO;
        this.vista = vista;
        inicializarEventos();
        cargarTablaArtistas();
        cargarTablaDibujos();
        cargarTablaMateriales();
    }

    // ─────────────────────── EVENTOS ─────────────────────────────────────────

    private void inicializarEventos() {
        // Artistas
        vista.getBtnArtAgregar().addActionListener(e -> agregarArtista());
        vista.getBtnArtActualizar().addActionListener(e -> actualizarArtista());
        vista.getBtnArtEliminar().addActionListener(e -> eliminarArtista());
        vista.getBtnArtBuscar().addActionListener(e -> buscarArtista());
        vista.getBtnArtLimpiar().addActionListener(e -> limpiarArtistas());
        vista.getTablaArtistas().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) seleccionarFilaArtista();
            }
        });

        // Dibujos
        vista.getBtnDibAgregar().addActionListener(e -> agregarDibujo());
        vista.getBtnDibActualizar().addActionListener(e -> actualizarDibujo());
        vista.getBtnDibEliminar().addActionListener(e -> eliminarDibujo());
        vista.getBtnDibBuscar().addActionListener(e -> buscarDibujo());
        vista.getBtnDibLimpiar().addActionListener(e -> limpiarDibujos());
        vista.getTablaDibujos().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) seleccionarFilaDibujo();
            }
        });

        // Materiales
        vista.getBtnMatAgregar().addActionListener(e -> agregarMaterial());
        vista.getBtnMatActualizar().addActionListener(e -> actualizarMaterial());
        vista.getBtnMatEliminar().addActionListener(e -> eliminarMaterial());
        vista.getBtnMatBuscar().addActionListener(e -> buscarMaterial());
        vista.getBtnMatLimpiar().addActionListener(e -> limpiarMateriales());
        vista.getTablaMateriales().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) seleccionarFilaMaterial();
            }
        });
    }

    // ─────────────────────── ARTISTAS ────────────────────────────────────────

    private void cargarTablaArtistas() {
        try {
            DefaultTableModel m = vista.getModeloArtistas();
            m.setRowCount(0);
            for (Artista a : artistaDAO.listarTodos()) {
                m.addRow(new Object[]{a.getIdArtista(), a.getNombre(), a.getEdad(), a.getExperiencia()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar artistas: " + ex.getMessage());
        }
    }

    private Artista construirArtista() {
        try {
            int id = vista.getTxtArtId().getText().isEmpty() ? 0
                     : Integer.parseInt(vista.getTxtArtId().getText());
            String nombre = vista.getTxtArtNombre().getText().trim();
            int edad = Integer.parseInt(vista.getTxtArtEdad().getText());
            String exp = vista.getTxtArtExperiencia().getText().trim();
            return new Artista(id, nombre, edad, exp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos del artista (verifique Edad)");
            return null;
        }
    }

    private void agregarArtista() {
        Artista a = construirArtista();
        if (a == null) return;
        try {
            artistaDAO.agregar(a);
            JOptionPane.showMessageDialog(vista, "Artista agregado exitosamente");
            cargarTablaArtistas();
            limpiarArtistas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar artista: " + ex.getMessage());
        }
    }

    private void actualizarArtista() {
        Artista a = construirArtista();
        if (a == null) return;
        try {
            artistaDAO.actualizar(a);
            JOptionPane.showMessageDialog(vista, "Artista actualizado");
            cargarTablaArtistas();
            limpiarArtistas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar artista: " + ex.getMessage());
        }
    }

    private void eliminarArtista() {
        try {
            int id = Integer.parseInt(vista.getTxtArtId().getText());
            int conf = JOptionPane.showConfirmDialog(vista, "¿Eliminar artista ID " + id + "?");
            if (conf == 0) {
                artistaDAO.eliminar(id);
                JOptionPane.showMessageDialog(vista, "Artista eliminado");
                cargarTablaArtistas();
                limpiarArtistas();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un ID válido");
        }
    }

    private void buscarArtista() {
        try {
            int id = Integer.parseInt(vista.getTxtArtId().getText());
            Artista a = artistaDAO.buscarPorId(id);
            if (a != null) {
                vista.getTxtArtNombre().setText(a.getNombre());
                vista.getTxtArtEdad().setText(String.valueOf(a.getEdad()));
                vista.getTxtArtExperiencia().setText(a.getExperiencia());
            } else {
                JOptionPane.showMessageDialog(vista, "Artista no encontrado");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese ID válido");
        }
    }

    private void seleccionarFilaArtista() {
        int fila = vista.getTablaArtistas().getSelectedRow();
        if (fila >= 0) {
            DefaultTableModel m = vista.getModeloArtistas();
            vista.getTxtArtId().setText(m.getValueAt(fila, 0).toString());
            vista.getTxtArtNombre().setText(m.getValueAt(fila, 1).toString());
            vista.getTxtArtEdad().setText(m.getValueAt(fila, 2).toString());
            vista.getTxtArtExperiencia().setText(m.getValueAt(fila, 3).toString());
        }
    }

    private void limpiarArtistas() {
        vista.getTxtArtId().setText("");
        vista.getTxtArtNombre().setText("");
        vista.getTxtArtEdad().setText("");
        vista.getTxtArtExperiencia().setText("");
    }

    // ─────────────────────── DIBUJOS ─────────────────────────────────────────

    private void cargarTablaDibujos() {
        try {
            DefaultTableModel m = vista.getModeloDibujos();
            m.setRowCount(0);
            for (Dibujo d : dibujoDAO.listarTodos()) {
                m.addRow(new Object[]{d.getIdDibujo(), d.getTitulo(), d.getTecnica(),
                                      d.getFechaCreacion(), d.getIdArtista()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar dibujos: " + ex.getMessage());
        }
    }

    private Dibujo construirDibujo() {
        try {
            int id = vista.getTxtDibId().getText().isEmpty() ? 0
                     : Integer.parseInt(vista.getTxtDibId().getText());
            String titulo = vista.getTxtDibTitulo().getText().trim();
            String tecnica = vista.getTxtDibTecnica().getText().trim();
            String fecha = vista.getTxtDibFecha().getText().trim();
            int idArtista = Integer.parseInt(vista.getTxtDibIdArtista().getText());
            return new Dibujo(id, titulo, tecnica, fecha, idArtista);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos del dibujo (verifique ID Artista)");
            return null;
        }
    }

    private void agregarDibujo() {
        Dibujo d = construirDibujo();
        if (d == null) return;
        try {
            dibujoDAO.agregar(d);
            JOptionPane.showMessageDialog(vista, "Dibujo agregado exitosamente");
            cargarTablaDibujos();
            limpiarDibujos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar dibujo: " + ex.getMessage());
        }
    }

    private void actualizarDibujo() {
        Dibujo d = construirDibujo();
        if (d == null) return;
        try {
            dibujoDAO.actualizar(d);
            JOptionPane.showMessageDialog(vista, "Dibujo actualizado");
            cargarTablaDibujos();
            limpiarDibujos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar dibujo: " + ex.getMessage());
        }
    }

    private void eliminarDibujo() {
        try {
            int id = Integer.parseInt(vista.getTxtDibId().getText());
            int conf = JOptionPane.showConfirmDialog(vista, "¿Eliminar dibujo ID " + id + "?");
            if (conf == 0) {
                dibujoDAO.eliminar(id);
                JOptionPane.showMessageDialog(vista, "Dibujo eliminado");
                cargarTablaDibujos();
                limpiarDibujos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un ID válido");
        }
    }

    private void buscarDibujo() {
        try {
            int id = Integer.parseInt(vista.getTxtDibId().getText());
            Dibujo d = dibujoDAO.buscarPorId(id);
            if (d != null) {
                vista.getTxtDibTitulo().setText(d.getTitulo());
                vista.getTxtDibTecnica().setText(d.getTecnica());
                vista.getTxtDibFecha().setText(d.getFechaCreacion());
                vista.getTxtDibIdArtista().setText(String.valueOf(d.getIdArtista()));
            } else {
                JOptionPane.showMessageDialog(vista, "Dibujo no encontrado");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese ID válido");
        }
    }

    private void seleccionarFilaDibujo() {
        int fila = vista.getTablaDibujos().getSelectedRow();
        if (fila >= 0) {
            DefaultTableModel m = vista.getModeloDibujos();
            vista.getTxtDibId().setText(m.getValueAt(fila, 0).toString());
            vista.getTxtDibTitulo().setText(m.getValueAt(fila, 1).toString());
            vista.getTxtDibTecnica().setText(m.getValueAt(fila, 2).toString());
            vista.getTxtDibFecha().setText(m.getValueAt(fila, 3) != null ? m.getValueAt(fila, 3).toString() : "");
            vista.getTxtDibIdArtista().setText(m.getValueAt(fila, 4).toString());
        }
    }

    private void limpiarDibujos() {
        vista.getTxtDibId().setText("");
        vista.getTxtDibTitulo().setText("");
        vista.getTxtDibTecnica().setText("");
        vista.getTxtDibFecha().setText("");
        vista.getTxtDibIdArtista().setText("");
    }

    // ─────────────────────── MATERIALES ──────────────────────────────────────

    private void cargarTablaMateriales() {
        try {
            DefaultTableModel m = vista.getModeloMateriales();
            m.setRowCount(0);
            for (Material mat : materialDAO.listarTodos()) {
                m.addRow(new Object[]{mat.getIdMaterial(), mat.getNombreMaterial(),
                                      mat.getTipo(), mat.getIdDibujo()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar materiales: " + ex.getMessage());
        }
    }

    private Material construirMaterial() {
        try {
            int id = vista.getTxtMatId().getText().isEmpty() ? 0
                     : Integer.parseInt(vista.getTxtMatId().getText());
            String nombre = vista.getTxtMatNombre().getText().trim();
            String tipo = vista.getTxtMatTipo().getText().trim();
            int idDibujo = Integer.parseInt(vista.getTxtMatIdDibujo().getText());
            return new Material(id, nombre, tipo, idDibujo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos del material (verifique ID Dibujo)");
            return null;
        }
    }

    private void agregarMaterial() {
        Material mat = construirMaterial();
        if (mat == null) return;
        try {
            materialDAO.agregar(mat);
            JOptionPane.showMessageDialog(vista, "Material agregado exitosamente");
            cargarTablaMateriales();
            limpiarMateriales();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar material: " + ex.getMessage());
        }
    }

    private void actualizarMaterial() {
        Material mat = construirMaterial();
        if (mat == null) return;
        try {
            materialDAO.actualizar(mat);
            JOptionPane.showMessageDialog(vista, "Material actualizado");
            cargarTablaMateriales();
            limpiarMateriales();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar material: " + ex.getMessage());
        }
    }

    private void eliminarMaterial() {
        try {
            int id = Integer.parseInt(vista.getTxtMatId().getText());
            int conf = JOptionPane.showConfirmDialog(vista, "¿Eliminar material ID " + id + "?");
            if (conf == 0) {
                materialDAO.eliminar(id);
                JOptionPane.showMessageDialog(vista, "Material eliminado");
                cargarTablaMateriales();
                limpiarMateriales();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un ID válido");
        }
    }

    private void buscarMaterial() {
        try {
            int id = Integer.parseInt(vista.getTxtMatId().getText());
            Material mat = materialDAO.buscarPorId(id);
            if (mat != null) {
                vista.getTxtMatNombre().setText(mat.getNombreMaterial());
                vista.getTxtMatTipo().setText(mat.getTipo());
                vista.getTxtMatIdDibujo().setText(String.valueOf(mat.getIdDibujo()));
            } else {
                JOptionPane.showMessageDialog(vista, "Material no encontrado");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese ID válido");
        }
    }

    private void seleccionarFilaMaterial() {
        int fila = vista.getTablaMateriales().getSelectedRow();
        if (fila >= 0) {
            DefaultTableModel m = vista.getModeloMateriales();
            vista.getTxtMatId().setText(m.getValueAt(fila, 0).toString());
            vista.getTxtMatNombre().setText(m.getValueAt(fila, 1).toString());
            vista.getTxtMatTipo().setText(m.getValueAt(fila, 2).toString());
            vista.getTxtMatIdDibujo().setText(m.getValueAt(fila, 3).toString());
        }
    }

    private void limpiarMateriales() {
        vista.getTxtMatId().setText("");
        vista.getTxtMatNombre().setText("");
        vista.getTxtMatTipo().setText("");
        vista.getTxtMatIdDibujo().setText("");
    }
}