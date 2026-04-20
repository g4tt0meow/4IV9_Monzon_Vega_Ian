import java.util.Scanner;

public class Calculadora {

    Scanner sc = new Scanner(System.in);

    double lado;
    double altura;
    double ancho;
    double radio;
    double diametro = radio/2;
    double baseMayor;
    double baseMenor;
    char respuesta;

    public void menu(){

    System.out.println("Calculadora geometrica");
    System.out.println("Bienvenido a la calculadora de areas de figuras geometricas");
    System.out.println("1.- Cuadrado");
    System.out.println("2.- Rectangulo");
    System.out.println("3.- Triangulo");
    System.out.println("4.- Circulo");
    System.out.println("5.- Trapecio");
    System.out.println("Elige una opcion: ");

    int opcion;

    opcion = sc.nextInt();

    switch (opcion) {
        case 1:
            Cuadrado();
            break;
    
        default:
            break;
    }

    }

    public void Cuadrado(){
        do { 
            System.out.println("Ingresa el valor de los lados de tu cuadrado: ");
        lado = sc.nextDouble();
        System.out.println("Area: " + lado*lado);
        System.out.println("Perimetro: " + 4*lado);

        System.out.println("Quiere repetir? (s/n)");
        respuesta = sc.next().charAt(0);
        } while ( respuesta == 's' || respuesta == 'S');
        


    }
}
