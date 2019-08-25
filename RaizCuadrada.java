package raizcuadrada;

import java.util.Scanner;

/**
 *@author Royk
 * Calcular la raiz cuadrada de un numero real positivo.
 */
public class RaizCuadrada {


    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        float x = leerRealPositivo();   //Subprograma que lee un real positivo evitando errores.
        float r = raizCuadrada(x);      //Subprograma que calcula la raiz cuadrada
        System.out.println("La raiz cuadrada de "+ x +" es : "+r);
    }
    
    private static float leerRealPositivo(){
        Scanner leer = new Scanner(System.in);
        float x=-1;
        while(true){
            System.out.print("Ingrese un numero real positivo: ");
            try{
                x = leer.nextFloat();
            }catch(java.util.InputMismatchException e){
                    leer.next();
                    System.out.print("Debe ser un numero real y");
            }
            if(x>=0)
                break;
            else
                System.out.println("Debe ser Positivo.");
        }
        return x;
    }
    
    private static float raizCuadrada(float x){
    //Subprograma que busca calcular la raizCuadrada de X.
        float i;                //Se define i fuera del Para asi se puede usar fuera de el.
        for(i=0;i*i<=x;i++){    /*Ciclo Para que intenta encontrar la raiz entera del numero.
                                i aumenta su valor en 1 hasta que su cuadrado es mayor que x*/
            if(i*i==x)          //Si el cuadrado de i es igual a x encontramos la raiz cuadrada de x.
                return i;       //Si el numero x tiene raiz cuadrada entera el subprograma termina aqui.
        }
        return raizIrracional(x ,i-1, 10); //Si es irracional se invoca otro subprograma que lo maneje.
    }
    
    private static float raizIrracional(float x, float d, float n){ 
    /*Subprograma que busca encontra una aproximacion de la raiz de un numero cuando esta es irracional.
    Los argumentos son x, el numero al que buscamos raiz,
    d sirve para almacenar el valor de i del ciclo anterior y no tener que empezar con i=0
    n almacena potencias de 10 y sirve para que i se mueva en valores decimales*/
        float i;
        for(i=d; i*i<=x; i=i+1/n){  /* Partiendo de el i que se ubtuvo en el ciclo anterior
            se aumenta en 1/n en cada ciclo, es decir que en el primero aumenta de a 0.1
            y luego de a 0.01 y asi sucesivamente.*/
            if(i*i-x<=0.0001&&i*i-x>=-0.0001) 
                /*Si la diferencia entre el cuadrado de i y x es suficientemente pequeña 
                se aproxima y se dice que son iguales.*/ 
                return i;
        }
        return raizIrracional(x, i-1/n, 10*n); 
        // Se usa la recursividad para llamar el subprograma para otro ciclo el valor de n en una potencia de 10.
    }
}
