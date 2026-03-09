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
    9.- Vamos a hacer dibujitos wiiii
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

        Scanner entrada = new Scanner(System.in);
        
        do { 
            
        
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
                
                break;
            case 2:
                System.out.println("Ingrese un numero positvio entero que dece convertir a binario:");
                int numero;
                String binario;

                numero = entrada.nextInt();

                if (numero > 0){
                    while(numero > 0){
                        if (numero%2 == 0){
                            binario = "0" + binario
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
            default:
                throw new AssertionError();
        }

        System.out.println("Deseas repetir el programa? \n Escribe s o S para repetir:");
        letrarepetir = entrada.next().charAt(index: 0);
        }while 
        (letrarepetir == "s" || letrarepetir == "S");



        }
}