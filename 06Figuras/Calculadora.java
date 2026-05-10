
import java.util.Scanner;

public class Calculadora {

    Scanner sc = new Scanner(System.in);

    double lado, alto, ancho, diametro, perimetro;
    double radio = diametro/2;
    double baseMayor, baseMenor;
    char respuesta;

    public void menu() {
        do {

            System.out.println("Calculadora geometrica");
            System.out.println("Bienvenido a la calculadora de areas de figuras geometricas");
            System.out.println("______________________");
            System.out.println("|1.- Cuadrado        |");
            System.out.println("|2.- Rectangulo      |");
            System.out.println("|3.- Triangulo       |");
            System.out.println("|4.- Circulo         |");
            System.out.println("|5.- Trapecio        |");
            System.out.println("|____________________|");
            System.out.println(" Elige una opcion: ");

            int opcion;

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Cuadrado();
                    break;
                case 2:
                    Rectangulo();
                    break;
                case 3:
                    Triangulo();
                    break;
                case 4:
                    Circulo();
                    break;
                default:
                    break;
            }
            System.out.println("Quiere usar otra opcion? (s/n)");
            respuesta = sc.next().charAt(0);
        } while (respuesta == 's'|| respuesta == 'S'  
        );

    }

    

    public void Cuadrado() {
        do {
            System.out.println("Calcular Cuadrado");
            System.out.println("Ingresa el valor de los lados de tu cuadrado: ");
            lado = sc.nextDouble();
            System.out.println("Area: " + lado * lado);
            System.out.println("Perimetro: " + 4 * lado);

            System.out.println("Quiere repetir? (s/n)");
            respuesta = sc.next().charAt(0);
        } while (respuesta == 's' || respuesta == 'S');

    }

    public void Rectangulo() {
        do {
            System.out.println("Calcular Rectangulo");
            System.out.println("Ingresa el alto de tu rectangulo: ");
            alto = sc.nextDouble();
            System.out.println("Ingresa el ancho: ");
            ancho = sc.nextDouble();
            System.out.println("Area: " + alto * ancho);
            System.out.println("Perimetro: " + (2 * alto + 2 * ancho));

            System.out.println("Quiere repetir? (s/n)");
            respuesta = sc.next().charAt(0);
        } while (respuesta == 's' || respuesta == 'S');
    }

    public void Triangulo() {
        do {
            System.out.println("Calcular Triangulo");
            System.out.println("Quieres calcular el area o perimetro?");
            System.out.println("_______________");
            System.out.println("|1.-Area      |");
            System.out.println("|2.-Perimetro |");
            System.out.println("|_____________|");
            
            int opcion;
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la base de su triangulo: ");
                    ancho = sc.nextDouble();
                    System.out.println("Ingrese la altura: ");
                    alto = sc.nextDouble();
                    System.out.println("Area: " + (ancho * alto) / 2);
                    break;
                case 2:
                    System.out.println("Solo para triangulos isosceles*");
                    System.out.println("Ingrese el valor de los lados del triangulos isosceles: ");
                    lado = sc.nextDouble();
                    System.out.println("Perimetro: " + (3 * lado));
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("Quiere repetir? (s/n)");
            respuesta = sc.next().charAt(0);
        } while (respuesta == 's' || respuesta == 'S');

    }

    public void Circulo() {
        do {
            System.out.println("Calcular Circulo");
            System.out.println("Con que quieres calcular tu circulo?");
            System.out.println("_______________");
            System.out.println("|1.- Area     |");
            System.out.println("|2.- Perimetro|");
            System.out.println("|_____________|");
            
            int opcion;
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Con que valor quieres calcular el area?");
                    System.out.println("_______________");
                    System.out.println("|1.-Radio     |");
                    System.out.println("|2.-Diametro  |");
                    System.out.println("|3.-Perimetro |");
                    System.out.println("|_____________|");

                    opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa el radio:");
                            radio = sc.nextInt();
                            double area;
                            area = 3.14 * radio * radio;
                            System.out.println("El area es de: " + area);
                            break;
                        case 2:
                            System.out.println("Ingresa el diametro:");
                            diametro = sc.nextDouble();
                            area = 3.14 * diametro/2 * diametro/2;
                            System.out.println("El area es de: " + area);
                            break;
                        case 3:
                            System.out.println("Ingresa el perimetro de tu circunferencia");
                            perimetro = sc.nextDouble();
                            area = (perimetro * perimetro) / 4 * (3.14);
                            System.out.println("El area es de: " + area);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 2:
                    System.out.println("Con que quieres calcular tu perimetro?");
                    System.out.println("______________");
                    System.out.println("|1.-Radio    |");
                    System.out.println("|2.-Diametro |");
                    System.out.println("|____________|");

                    opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa el radio:");
                            radio = sc.nextDouble();
                            perimetro = 2 * 3.14 * radio;
                            System.out.println("El perimetro es de: " + perimetro);
                            break;
                        case 2:
                            System.out.println("Ingresa el diametro:");
                            diametro = sc.nextDouble();
                            perimetro = 2 * 3.14 * (diametro/2);
                            System.out.println("El perimetro es de: " + perimetro);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                default:
                    throw new AssertionError();
            
        }
        System.out.println("Quiere repetir? (s/n)");
        respuesta = sc.next().charAt(0);
    } while (respuesta == 's' || respuesta == 'S');
}
}
