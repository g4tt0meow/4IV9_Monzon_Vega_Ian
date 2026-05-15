
package examen;

public class Profesor extends Persona {

    private int id;
    private String materia;

    public Profesor(){
    }

    public Profesor(String nombre, int edad, char genero, int id, String materia){

        super(nombre, edad, genero);

        this.id = id;
        this.materia = materia;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}