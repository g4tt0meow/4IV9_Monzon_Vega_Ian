
package examen;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOEstudiante {

    ArrayList<Estudiante> lista;

    public DAOEstudiante(){
        lista = GuardarArchivos.cargarEstudiantes();
    }

    public void agregarEstudiante(){

        try{

            String nombre = JOptionPane.showInputDialog("Ingresa nombre");

            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa edad"));

            char genero = JOptionPane.showInputDialog("Ingresa genero").charAt(0);

            int boleta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa boleta"));

            Estudiante est = new Estudiante(nombre, edad, genero, boleta);

            lista.add(est);

            GuardarArchivos.guardarEstudiantes(lista);

            JOptionPane.showMessageDialog(null, "Estudiante agregado");

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
    }

    public void mostrarEstudiantes(){

        if(lista.size() == 0){

            JOptionPane.showMessageDialog(null, "No hay estudiantes");

            return;
        }

        String datos = "";

        for(int i = 0; i < lista.size(); i++){

            datos += "Nombre: " + lista.get(i).getNombre()
                    + "\nEdad: " + lista.get(i).getEdad()
                    + "\nGenero: " + lista.get(i).getGenero()
                    + "\nBoleta: " + lista.get(i).getBoleta()
                    + "\n\n";
        }

        JOptionPane.showMessageDialog(null, datos);
    }

    public void editarEstudiante(){

        try{

            int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa boleta"));

            for(int i = 0; i < lista.size(); i++){

                if(lista.get(i).getBoleta() == buscar){

                    String nombre = JOptionPane.showInputDialog("Nuevo nombre");

                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad"));

                    char genero = JOptionPane.showInputDialog("Nuevo genero").charAt(0);

                    int boleta = Integer.parseInt(JOptionPane.showInputDialog("Nueva boleta"));

                    lista.get(i).setNombre(nombre);
                    lista.get(i).setEdad(edad);
                    lista.get(i).setGenero(genero);
                    lista.get(i).setBoleta(boleta);

                    GuardarArchivos.guardarEstudiantes(lista);

                    JOptionPane.showMessageDialog(null, "Estudiante actualizado");

                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
    }

    public void eliminarEstudiante(){

        try{

            int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa boleta"));

            for(int i = 0; i < lista.size(); i++){

                if(lista.get(i).getBoleta() == buscar){

                    lista.remove(i);

                    GuardarArchivos.guardarEstudiantes(lista);

                    JOptionPane.showMessageDialog(null, "Estudiante eliminado");

                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
    }

    public void menu(){

        int opcion;

        do{

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "CRUD ESTUDIANTES\n\n"
                    + "1.- Agregar estudiante\n"
                    + "2.- Mostrar estudiantes\n"
                    + "3.- Editar estudiante\n"
                    + "4.- Eliminar estudiante\n"
                    + "5.- Salir"));

            switch(opcion){

                case 1:
                    agregarEstudiante();
                    break;

                case 2:
                    mostrarEstudiantes();
                    break;

                case 3:
                    editarEstudiante();
                    break;

                case 4:
                    eliminarEstudiante();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        }while(opcion != 5);
    }
}