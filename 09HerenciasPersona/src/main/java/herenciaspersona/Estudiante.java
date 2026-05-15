
package herenciaspersona;

public class Estudiante extends Persona { 
        
    private int numBoleta;
    private String chillon;
    
    public Estudiante(int numboleta, String nom, int edad, char gen){
    }

    public Estudiante(int numBoleta, String chillon, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.numBoleta = numBoleta;
        this.chillon = chillon;
    }

    public int getNumBoleta() {
        return numBoleta;
    }

    public void setNumBoleta(int numBoleta) {
        this.numBoleta = numBoleta;
    }

    public String getChillon() {
        return chillon;
    }

    public void setChillon(String chillon) {
        this.chillon = chillon;
    }
    
    
    
    
    
}