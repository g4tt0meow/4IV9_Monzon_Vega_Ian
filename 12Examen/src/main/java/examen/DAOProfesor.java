
package examen;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOProfesor {

    ArrayList<Profesor> lista;

    public DAOProfesor(){
        lista = GuardarArchivos.cargarProfesores();
    }

    public void agregarProfesor(){

        try{

            String nombre = JOptionPane.showInputDialog("Ingresa nombre");

            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa edad"));

            char genero = JOptionPane.showInputDialog("Ingresa genero").charAt(0);

            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa ID"));

            String materia = JOptionPane.showInputDialog("Ingresa materia");

            Profesor prof = new Profesor(nombre, edad, genero, id, materia);

            lista.add(prof);

            GuardarArchivos.guardarProfesores(lista);

            JOptionPane.showMessageDialog(null, "Profesor agregado");

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
    }

    public void mostrarProfesores(){

        if(lista.size() == 0){

            JOptionPane.showMessageDialog(null, "No hay profesores");

            return;
        }

        String datos = "";

        for(int i = 0; i < lista.size(); i++){

            datos += "Nombre: " + lista.get(i).getNombre()
                    + "\nEdad: " + lista.get(i).getEdad()
                    + "\nGenero: " + lista.get(i).getGenero()
                    + "\nID: " + lista.get(i).getID()
                    + "\nMateria: " + lista.get(i).getMateria()
                    + "\n\n";
        }

        JOptionPane.showMessageDialog(null, datos);
    }

    public void editarProfesor(){

        try{

            int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa ID"));

            for(int i = 0; i < lista.size(); i++){

                if(lista.get(i).getID() == buscar){

                    String nombre = JOptionPane.showInputDialog("Nuevo nombre");

                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad"));

                    char genero = JOptionPane.showInputDialog("Nuevo genero").charAt(0);

                    int id = Integer.parseInt(JOptionPane.showInputDialog("Nuevo ID"));

                    String materia = JOptionPane.showInputDialog("Nueva materia");

                    lista.get(i).setNombre(nombre);
                    lista.get(i).setEdad(edad);
                    lista.get(i).setGenero(genero);
                    lista.get(i).setID(id);
                    lista.get(i).setMateria(materia);

                    GuardarArchivos.guardarProfesores(lista);

                    JOptionPane.showMessageDialog(null, "Profesor actualizado");

                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Profesor no encontrado");

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
    }

    public void eliminarProfesor(){

        try{

            int buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa ID"));

            for(int i = 0; i < lista.size(); i++){

                if(lista.get(i).getID() == buscar){

                    lista.remove(i);

                    GuardarArchivos.guardarProfesores(lista);

                    JOptionPane.showMessageDialog(null, "Profesor eliminado");

                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Profesor no encontrado");

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
    }

    public void menu(){

        int opcion;

        do{

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "CRUD PROFESORES\n\n"
                    + "1.- Agregar profesor\n"
                    + "2.- Mostrar profesores\n"
                    + "3.- Editar profesor\n"
                    + "4.- Eliminar profesor\n"
                    + "5.- Salir"));

            switch(opcion){

                case 1:
                    agregarProfesor();
                    break;

                case 2:
                    mostrarProfesores();
                    break;

                case 3:
                    editarProfesor();
                    break;

                case 4:
                    eliminarProfesor();
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