/*
    Vamos a realizar 14 programas dentrp de in menu gigante para poner a prubea sus conocimientos de algoritmia
    1.- Desarrolla un progrma para calcular el bono de un descuento por edad
    2.- Conertir numeros decimales a binarios
    3.- Convertir temperaturas entre los 3 principales grados C -> F y K
    4.- Realizar un programa para contar numero de positivos y negativos de una serie de numeros
    5.- Desarrollar una tienda para agregrar productos y precios
    6.- Desarrollar un programa para calclar el area y perimetro de 5 diferentes figuras
    7.- Desarrollar una tabla avr de q se me ocurre
    8.- Desarrollar un programa para calcular un factorial con recursividad
    9.- Vamos a hacer dibujitos wiiii triangulo equilatero o rombo
    10.- Desarrolla una figura hueca
    11.- Realizar algunos patrones
    12.- Realizar un diamante
    13.- Desarrollar una calculadora basica + - * /

*/
import java.util.Scanner;


public class EstructuraDatos {
    public static void main(String[] args) {

        int opcion;
        char letrarepetir;

        do {


        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Por favor eliga un opcion");
    
        System.out.println("1.- ");
        System.out.println("2.- ");
        System.out.println("3.- ");
        System.out.println("4.- ");
        System.out.println("5.- ");
        System.out.println("6.- ");
        System.out.println("7.- ");
        System.out.println("8.- ");
        System.out.println("9.- ");
        System.out.println("10.- ");
        System.out.println("11.- ");
        System.out.println("12.- ");
        System.out.println("13.- ");
        System.out.println("14.- Salir ");

    opcion = entrada.nextInt();

        switch (opcion) {
            case 1 :
                    System.out.println("Bienvenido a batizlandia, lugar de dolor y sufrimiento eterno!");
                    System.out.println("----------| Precios de los boletos |---------");
                    System.out.println("3-7 años: 35$ por persona \n 8-14 años: 40$ por persona \n 15 años en adelante: 50$ persona");
                    System.out.println("\n Menores de 3 entran gratis!");
                    System.out.println("Ingrese su edad: ");
                    int edad;
                    edad = entrada.nextInt();

                    if (edad < 0){
                        System.out.println("Ingrese una edad valida");
                    } else if(edad > 0 && edad < 3 ){
                        System.out.println("Entras gratis!");
                    } else if(edad > 3 && edad < 8)

                break;
            case 2:
                System.out.println("Ingrese un numero positvio entero que dece convertir a binario:");
                int numero;
                String binario;
                binario = "";

                numero = entrada.nextInt();

                if (numero > 0){
                    while(numero > 0){
                        if (numero%2 == 0){
                            binario = "0" + binario;
                        }else {
                            binario = "1" + binario;
                        }
                        numero = (int)numero/2;
                    }
                }else if(numero == 0){
                    binario = "0";
                }else {
                    binario = "No se puede convertir ese numero, solo enterors";
                    }
                    System.out.println("El numero convertido a binario es:" + binario);

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                System.out.println("Bienvenid@ a esta hermosa tiendita");
                System.out.println("Por favor ingrese cuantos elementos va a comprar");
                int cantidadproductos = 0;
                cantidadproductos = entrada.nextInt();
                if (cantidadproductos > 0){
                    for(int i = 1; i <= cantidadproductos; i++){
                        System.out.println("Ingresa el nombre del producto");
                        String nombreproducto;
                        nombreproducto = entrada.next();
                    }
                }

                    break;
                case 6:

                    break;
                case 7:
                    for(int n = 1; n <= 10; n++){
                        System.out.println(
                            "|  " + n + "  |  " + ( " |  " + n*10 + "  |  " + (n*100 + "   | ") + "  |  " + (n*1000 + "  |  "))
                        );
                    }

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Vamos a realizar el dibujo de un cuadradp magico");
                    System.out.println("Ingrese eñ tamaño del cuadrado");

                    int n1 = entrada.nextInt();

                    if(n1 >= 1 && n1 <= 20){
                        for(int i = 1; i <= n1; i++){
                            System.out.print(" 1 ");
                            for(int j = 1; j <= n1; j++){
                                System.out.println(" * ");
                            }
                        }
                    }else{
                        System.out.println("Escriba valores del 1 al 20");
                    }


                    break;
            default:
                throw new AssertionError();
        }

        System.out.println("Deseas repetir el programa? \n Escribe s o S para repetir:");
        letrarepetir = entrada.next().charAt(0);
        }while (letrarepetir == 's' || letrarepetir == 'S');



        }
}