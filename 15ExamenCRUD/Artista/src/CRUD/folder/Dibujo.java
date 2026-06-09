package CRUD.folder;

public class Dibujo {

    private int idDibujo;
    private String titulo;
    private String tecnica;
    private String fechaCreacion; // Se maneja como String (formato yyyy-MM-dd)
    private int idArtista;

    public Dibujo() {
        this.idDibujo = 0;
        this.titulo = "";
        this.tecnica = "";
        this.fechaCreacion = "";
        this.idArtista = 0;
    }

    public Dibujo(int idDibujo, String titulo, String tecnica, String fechaCreacion, int idArtista) {
        this.idDibujo = idDibujo;
        this.titulo = titulo;
        this.tecnica = tecnica;
        this.fechaCreacion = fechaCreacion;
        this.idArtista = idArtista;
    }

    public int getIdDibujo() { return idDibujo; }
    public void setIdDibujo(int idDibujo) { this.idDibujo = idDibujo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTecnica() { return tecnica; }
    public void setTecnica(String tecnica) { this.tecnica = tecnica; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public int getIdArtista() { return idArtista; }
    public void setIdArtista(int idArtista) { this.idArtista = idArtista; }

    @Override
    public String toString() {
        return idDibujo + " - " + titulo;
    }
}