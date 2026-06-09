package CRUD.folder;

public class Artista {

    private int idArtista;
    private String nombre;
    private int edad;
    private String experiencia;

    public Artista() {
        this.idArtista = 0;
        this.nombre = "";
        this.edad = 0;
        this.experiencia = "";
    }

    public Artista(int idArtista, String nombre, int edad, String experiencia) {
        this.idArtista = idArtista;
        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
    }

    public int getIdArtista() { return idArtista; }
    public void setIdArtista(int idArtista) { this.idArtista = idArtista; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { if (edad > 0) this.edad = edad; }

    public String getExperiencia() { return experiencia; }
    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }

    @Override
    public String toString() {
        return idArtista + " - " + nombre;
    }
}