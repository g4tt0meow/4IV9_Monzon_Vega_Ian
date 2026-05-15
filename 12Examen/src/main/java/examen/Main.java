
package examen;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        DAOEstudiante de = new DAOEstudiante();
        DAOProfesor dp = new DAOProfesor();

        int opcion;

        do{

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU PRINCIPAL\n\n"
                    + "1.- Estudiantes\n"
                    + "2.- Profesores\n"
                    + "3.- Salir"));

            switch(opcion){

                case 1:
                    de.menu();
                    break;

                case 2:
                    dp.menu();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }

        }while(opcion != 3);
    }
}