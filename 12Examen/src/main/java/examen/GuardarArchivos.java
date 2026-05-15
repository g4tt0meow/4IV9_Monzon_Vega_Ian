
package examen;

import java.io.*;
import java.util.ArrayList;

public class GuardarArchivos {

    private static final String DATOS_ESTUDIANTES = "estudiantes.txt";
    private static final String DATOS_PROFESORES = "profesores.txt";

    public static void guardarEstudiantes(ArrayList<Estudiante> lista){

        try(BufferedWriter escribe = new BufferedWriter(new FileWriter(DATOS_ESTUDIANTES))){

            for(Estudiante e : lista){
                escribe.write("nombre=" + e.getNombre());
                escribe.newLine();
                escribe.write("edad=" + e.getEdad());
                escribe.newLine();
                escribe.write("genero=" + e.getGenero());
                escribe.newLine();
                escribe.write("boleta=" + e.getBoleta());
                escribe.newLine();
                escribe.newLine();
            }

            System.out.println("Estudiantes guardados");

        }catch(Exception e){
            System.out.println("Error al guardar estudiantes");
        }
    }

    public static ArrayList<Estudiante> cargarEstudiantes(){

        ArrayList<Estudiante> lista = new ArrayList<>();

        try(BufferedReader leer = new BufferedReader(new FileReader(DATOS_ESTUDIANTES))){

            String linea;
            Estudiante est = null;

            while((linea = leer.readLine()) != null){

                linea = linea.trim();

                if(linea.isEmpty()){

                    if(est != null){
                        lista.add(est);
                        est = null;
                    }

                    continue;
                }

                String[] partes = linea.split("=", 2);

                if(partes.length == 2){

                    String clave = partes[0];
                    String valor = partes[1];

                    if(est == null){
                        est = new Estudiante();
                    }

                    switch(clave){

                        case "nombre":
                            est.setNombre(valor);
                            break;

                        case "edad":
                            est.setEdad(Integer.parseInt(valor));
                            break;

                        case "genero":
                            est.setGenero(valor.charAt(0));
                            break;

                        case "boleta":
                            est.setBoleta(Integer.parseInt(valor));
                            break;
                    }
                }
            }

            if(est != null){
                lista.add(est);
            }

        }catch(Exception e){
            System.out.println("No se pudo cargar estudiantes");
        }

        return lista;
    }

    public static void guardarProfesores(ArrayList<Profesor> lista){

        try(BufferedWriter escribe = new BufferedWriter(new FileWriter(DATOS_PROFESORES))){

            for(Profesor p : lista){
                escribe.write("nombre=" + p.getNombre());
                escribe.newLine();
                escribe.write("edad=" + p.getEdad());
                escribe.newLine();
                escribe.write("genero=" + p.getGenero());
                escribe.newLine();
                escribe.write("id=" + p.getID());
                escribe.newLine();
                escribe.write("materia=" + p.getMateria());
                escribe.newLine();
                escribe.newLine();
            }

            System.out.println("Profesores guardados");

        }catch(Exception e){
            System.out.println("Error al guardar profesores");
        }
    }

    public static ArrayList<Profesor> cargarProfesores(){

        ArrayList<Profesor> lista = new ArrayList<>();

        try(BufferedReader leer = new BufferedReader(new FileReader(DATOS_PROFESORES))){

            String linea;
            Profesor prof = null;

            while((linea = leer.readLine()) != null){

                linea = linea.trim();

                if(linea.isEmpty()){

                    if(prof != null){
                        lista.add(prof);
                        prof = null;
                    }

                    continue;
                }

                String[] partes = linea.split("=", 2);

                if(partes.length == 2){

                    String clave = partes[0];
                    String valor = partes[1];

                    if(prof == null){
                        prof = new Profesor();
                    }

                    switch(clave){

                        case "nombre":
                            prof.setNombre(valor);
                            break;

                        case "edad":
                            prof.setEdad(Integer.parseInt(valor));
                            break;

                        case "genero":
                            prof.setGenero(valor.charAt(0));
                            break;

                        case "id":
                            prof.setID(Integer.parseInt(valor));
                            break;

                        case "materia":
                            prof.setMateria(valor);
                            break;
                    }
                }
            }

            if(prof != null){
                lista.add(prof);
            }

        }catch(Exception e){
            System.out.println("No se pudo cargar profesores");
        }

        return lista;
    }
}