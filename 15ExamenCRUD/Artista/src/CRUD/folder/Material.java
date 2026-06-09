package CRUD.folder;

public class Material {

    private int idMaterial;
    private String nombreMaterial;
    private String tipo;
    private int idDibujo;

    public Material() {
        this.idMaterial = 0;
        this.nombreMaterial = "";
        this.tipo = "";
        this.idDibujo = 0;
    }

    public Material(int idMaterial, String nombreMaterial, String tipo, int idDibujo) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.tipo = tipo;
        this.idDibujo = idDibujo;
    }

    public int getIdMaterial() { return idMaterial; }
    public void setIdMaterial(int idMaterial) { this.idMaterial = idMaterial; }

    public String getNombreMaterial() { return nombreMaterial; }
    public void setNombreMaterial(String nombreMaterial) { this.nombreMaterial = nombreMaterial; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getIdDibujo() { return idDibujo; }
    public void setIdDibujo(int idDibujo) { this.idDibujo = idDibujo; }

    @Override
    public String toString() {
        return idMaterial + " - " + nombreMaterial;
    }
}