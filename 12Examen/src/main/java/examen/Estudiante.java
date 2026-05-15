
package examen;

public class Estudiante extends Persona {

    private int boleta;

    public Estudiante(){
    }

    public Estudiante(String nombre, int edad, char genero, int boleta){

        super(nombre, edad, genero);

        this.boleta = boleta;
    }

    public int getBoleta() {
        return boleta;
    }

    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }
}