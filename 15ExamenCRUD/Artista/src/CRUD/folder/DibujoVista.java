package CRUD.folder;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DibujoVista extends JFrame {

    // ── Pestaña Artistas ──────────────────────────────────────────────────────
    private JTable tablaArtistas;
    private DefaultTableModel modeloArtistas;
    private JTextField txtArtId, txtArtNombre, txtArtEdad, txtArtExperiencia;
    private JButton btnArtAgregar, btnArtActualizar, btnArtEliminar, btnArtBuscar, btnArtLimpiar;

    // ── Pestaña Dibujos ───────────────────────────────────────────────────────
    private JTable tablaDibujos;
    private DefaultTableModel modeloDibujos;
    private JTextField txtDibId, txtDibTitulo, txtDibTecnica, txtDibFecha, txtDibIdArtista;
    private JButton btnDibAgregar, btnDibActualizar, btnDibEliminar, btnDibBuscar, btnDibLimpiar;

    // ── Pestaña Materiales ────────────────────────────────────────────────────
    private JTable tablaMateriales;
    private DefaultTableModel modeloMateriales;
    private JTextField txtMatId, txtMatNombre, txtMatTipo, txtMatIdDibujo;
    private JButton btnMatAgregar, btnMatActualizar, btnMatEliminar, btnMatBuscar, btnMatLimpiar;

    public DibujoVista() {
        setTitle("CRUD Dibujo - Gestión de Artistas, Dibujos y Materiales");
        setSize(1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));

        // Título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(70, 130, 180));
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN DE DIBUJO 🎨");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Pestañas
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("🧑‍🎨 Artistas", crearPestanaArtistas());
        tabs.addTab("🖼 Dibujos", crearPestanaDibujos());
        tabs.addTab("🖌 Materiales", crearPestanaMateriales());
        add(tabs, BorderLayout.CENTER);
    }

    // ─────────────────────────── ARTISTAS ────────────────────────────────────

    private JPanel crearPestanaArtistas() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        modeloArtistas = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Edad", "Experiencia"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tablaArtistas = new JTable(modeloArtistas);
        tablaArtistas.setRowHeight(24);
        tablaArtistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(tablaArtistas), BorderLayout.CENTER);

        JPanel sur = new JPanel(new BorderLayout(5, 5));
        sur.add(crearFormArtistas(), BorderLayout.CENTER);
        sur.add(crearBotonesArtistas(), BorderLayout.SOUTH);
        panel.add(sur, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel crearFormArtistas() {
        JPanel p = new JPanel(new GridLayout(2, 4, 8, 8));
        p.setBorder(BorderFactory.createTitledBorder("Datos del Artista"));

        p.add(new JLabel("ID:")); txtArtId = new JTextField(); p.add(txtArtId);
        p.add(new JLabel("Nombre:")); txtArtNombre = new JTextField(); p.add(txtArtNombre);
        p.add(new JLabel("Edad:")); txtArtEdad = new JTextField(); p.add(txtArtEdad);
        p.add(new JLabel("Experiencia:")); txtArtExperiencia = new JTextField(); p.add(txtArtExperiencia);
        return p;
    }

    private JPanel crearBotonesArtistas() {
        JPanel p = new JPanel(new FlowLayout());
        btnArtAgregar   = new JButton("Agregar");
        btnArtActualizar = new JButton("Actualizar");
        btnArtEliminar  = new JButton("Eliminar");
        btnArtBuscar    = new JButton("Buscar");
        btnArtLimpiar   = new JButton("Limpiar");
        p.add(btnArtAgregar); p.add(btnArtActualizar);
        p.add(btnArtEliminar); p.add(btnArtBuscar); p.add(btnArtLimpiar);
        return p;
    }

    // ─────────────────────────── DIBUJOS ─────────────────────────────────────

    private JPanel crearPestanaDibujos() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        modeloDibujos = new DefaultTableModel(
            new String[]{"ID", "Título", "Técnica", "Fecha Creación", "ID Artista"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tablaDibujos = new JTable(modeloDibujos);
        tablaDibujos.setRowHeight(24);
        tablaDibujos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(tablaDibujos), BorderLayout.CENTER);

        JPanel sur = new JPanel(new BorderLayout(5, 5));
        sur.add(crearFormDibujos(), BorderLayout.CENTER);
        sur.add(crearBotonesDibujos(), BorderLayout.SOUTH);
        panel.add(sur, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel crearFormDibujos() {
        JPanel p = new JPanel(new GridLayout(3, 4, 8, 8));
        p.setBorder(BorderFactory.createTitledBorder("Datos del Dibujo"));

        p.add(new JLabel("ID:")); txtDibId = new JTextField(); p.add(txtDibId);
        p.add(new JLabel("Título:")); txtDibTitulo = new JTextField(); p.add(txtDibTitulo);
        p.add(new JLabel("Técnica:")); txtDibTecnica = new JTextField(); p.add(txtDibTecnica);
        p.add(new JLabel("Fecha (yyyy-MM-dd):")); txtDibFecha = new JTextField(); p.add(txtDibFecha);
        p.add(new JLabel("ID Artista:")); txtDibIdArtista = new JTextField(); p.add(txtDibIdArtista);
        // relleno para completar la cuadrícula
        p.add(new JLabel("")); p.add(new JLabel(""));
        return p;
    }

    private JPanel crearBotonesDibujos() {
        JPanel p = new JPanel(new FlowLayout());
        btnDibAgregar   = new JButton("Agregar");
        btnDibActualizar = new JButton("Actualizar");
        btnDibEliminar  = new JButton("Eliminar");
        btnDibBuscar    = new JButton("Buscar");
        btnDibLimpiar   = new JButton("Limpiar");
        p.add(btnDibAgregar); p.add(btnDibActualizar);
        p.add(btnDibEliminar); p.add(btnDibBuscar); p.add(btnDibLimpiar);
        return p;
    }

    // ─────────────────────────── MATERIALES ──────────────────────────────────

    private JPanel crearPestanaMateriales() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        modeloMateriales = new DefaultTableModel(
            new String[]{"ID", "Nombre Material", "Tipo", "ID Dibujo"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tablaMateriales = new JTable(modeloMateriales);
        tablaMateriales.setRowHeight(24);
        tablaMateriales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(tablaMateriales), BorderLayout.CENTER);

        JPanel sur = new JPanel(new BorderLayout(5, 5));
        sur.add(crearFormMateriales(), BorderLayout.CENTER);
        sur.add(crearBotonesMateriales(), BorderLayout.SOUTH);
        panel.add(sur, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel crearFormMateriales() {
        JPanel p = new JPanel(new GridLayout(2, 4, 8, 8));
        p.setBorder(BorderFactory.createTitledBorder("Datos del Material"));

        p.add(new JLabel("ID:")); txtMatId = new JTextField(); p.add(txtMatId);
        p.add(new JLabel("Nombre Material:")); txtMatNombre = new JTextField(); p.add(txtMatNombre);
        p.add(new JLabel("Tipo:")); txtMatTipo = new JTextField(); p.add(txtMatTipo);
        p.add(new JLabel("ID Dibujo:")); txtMatIdDibujo = new JTextField(); p.add(txtMatIdDibujo);
        return p;
    }

    private JPanel crearBotonesMateriales() {
        JPanel p = new JPanel(new FlowLayout());
        btnMatAgregar   = new JButton("Agregar");
        btnMatActualizar = new JButton("Actualizar");
        btnMatEliminar  = new JButton("Eliminar");
        btnMatBuscar    = new JButton("Buscar");
        btnMatLimpiar   = new JButton("Limpiar");
        p.add(btnMatAgregar); p.add(btnMatActualizar);
        p.add(btnMatEliminar); p.add(btnMatBuscar); p.add(btnMatLimpiar);
        return p;
    }

    // ─────────────────────────── GETTERS ─────────────────────────────────────

    // Artistas
    public JTable getTablaArtistas() { return tablaArtistas; }
    public DefaultTableModel getModeloArtistas() { return modeloArtistas; }
    public JTextField getTxtArtId() { return txtArtId; }
    public JTextField getTxtArtNombre() { return txtArtNombre; }
    public JTextField getTxtArtEdad() { return txtArtEdad; }
    public JTextField getTxtArtExperiencia() { return txtArtExperiencia; }
    public JButton getBtnArtAgregar() { return btnArtAgregar; }
    public JButton getBtnArtActualizar() { return btnArtActualizar; }
    public JButton getBtnArtEliminar() { return btnArtEliminar; }
    public JButton getBtnArtBuscar() { return btnArtBuscar; }
    public JButton getBtnArtLimpiar() { return btnArtLimpiar; }

    // Dibujos
    public JTable getTablaDibujos() { return tablaDibujos; }
    public DefaultTableModel getModeloDibujos() { return modeloDibujos; }
    public JTextField getTxtDibId() { return txtDibId; }
    public JTextField getTxtDibTitulo() { return txtDibTitulo; }
    public JTextField getTxtDibTecnica() { return txtDibTecnica; }
    public JTextField getTxtDibFecha() { return txtDibFecha; }
    public JTextField getTxtDibIdArtista() { return txtDibIdArtista; }
    public JButton getBtnDibAgregar() { return btnDibAgregar; }
    public JButton getBtnDibActualizar() { return btnDibActualizar; }
    public JButton getBtnDibEliminar() { return btnDibEliminar; }
    public JButton getBtnDibBuscar() { return btnDibBuscar; }
    public JButton getBtnDibLimpiar() { return btnDibLimpiar; }

    // Materiales
    public JTable getTablaMateriales() { return tablaMateriales; }
    public DefaultTableModel getModeloMateriales() { return modeloMateriales; }
    public JTextField getTxtMatId() { return txtMatId; }
    public JTextField getTxtMatNombre() { return txtMatNombre; }
    public JTextField getTxtMatTipo() { return txtMatTipo; }
    public JTextField getTxtMatIdDibujo() { return txtMatIdDibujo; }
    public JButton getBtnMatAgregar() { return btnMatAgregar; }
    public JButton getBtnMatActualizar() { return btnMatActualizar; }
    public JButton getBtnMatEliminar() { return btnMatEliminar; }
    public JButton getBtnMatBuscar() { return btnMatBuscar; }
    public JButton getBtnMatLimpiar() { return btnMatLimpiar; }
}