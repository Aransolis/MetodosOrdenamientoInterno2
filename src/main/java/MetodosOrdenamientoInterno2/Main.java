/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosOrdenamientoInterno2;

/**
 *
 * @author Aran Solis
 */
public class Main {

    public static void main(String[] args) {
        int[] b = {5, 8, 1, 3, 6, 7, 4, 2};
        System.out.println("Arreglo antes de Shell");
        imprimir(b);
        System.out.println("Arreglo despues de Shell");
        shell(b);

//        System.out.println("Arreglo antes de Seleccion");
//        imprimir(b);
//        System.out.println("Arreglo despues de Seleccion");
//        seleccion(b);
//         imprimir(b);
//        System.out.println("Arreglo antes de insercion");
//        imprimir(b);
//        System.out.println("Arreglo despues de insercion");
//        insercion(b);
//        imprimir(b);
    }

    public static void insercion(int A[]) {
        int p, j;       //DECLARAMOS VARIABLES
        int aux;
        for (p = 1; p < A.length; p++) { // DESDE EL SEGUNDO ELEMENTO HASTA EL FINAL
            aux = A[p];           // GUARDAMOS EL NUMERO Y
            j = p - 1;            // EMPEZAMOS A COMPROBAR CON EL ANTERIOR
            while ((j >= 0) && (aux < A[j])) { // MIENTRAS QUEDEN POSICIONES A REVISAR Y EL                                 
                // VALOR DE AUX SEA MENOR A LOS
                A[j + 1] = A[j];   // DE LA IZQUIERDA, SE DESPLAZA A
                j--;               // LA DERECHA
            }
            A[j + 1] = aux;       // COLOCAMOS AUX EN SU SITIO
        }
    }

    public static void seleccion(int A[]) {
        int i, j, menor, pos, tmp; //DECLARAMOS VARIABLES
        for (i = 0; i < A.length - 1; i++) {   //DECLARAMOS FOR QUE RECORRERA ARREGLO
            menor = A[i];       //LA VARIABLE MENOR LE ASIGNAMOS EL VALOR DE LA ACTUAL POSICION                                   
            pos = i;            //LE ASIGNAMOS LA POSCION A LA VARIABLE POS
            for (j = i + 1; j < A.length; j++) { //DECLARAMOS OTRO FOR, QUE INICIA UNA POSICION DESPUES AL FOR ANTERIOR
                if (A[j] < menor) {   //BUSCAMOS EL MENOR
                    menor = A[j];    //SI EXISTE UNO MENOR EN EL ARREGLO, SE LA ASIGNAMOS A LA VARIABLE MENOR 
                    pos = j;         //LA POSICION SE LA ASIGNAMOS
                }
            }
            if (pos != i) {          //SI LA POSICION CAMBIO A LA ORIGINAL, HUBO UNO MENOR                      
                tmp = A[i];         //AQUI HACEMOS EL INTERCAMBIO DE POSICION DE ESOS NUMEROS
                A[i] = A[pos];
                A[pos] = tmp;
            }
        }
    }

    public static void shell(int[] arreglo) {
        int salto, i, j, k, auxiliar; //DECLARAMOS VARIABLES
        salto = arreglo.length / 2; // OBTENEMOS SALTO
        while (salto > 0) {             //SIEMPRE QUE SALTO SEA MAYOR A 0, SI NO TERMINA EL PROGRAMA
            for (i = salto; i < arreglo.length; i++) {  //INICIAMOS ARREGLO EN POSICION DE SALTO, HASTA ULTIMO VALOR 
                j = i - salto;           //OBTENEMOS LA PRIMERA POSICION DE SUBARREGLO, ASIGAMOS VALOR A LA VARIABLE J 
                while (j >= 0) {         //SIEMPRE QUE LA PRIMERA POSICION SEA MAYOR O IGUAL A 0
                    k = j + salto;    //OBTENEMOS SEGUNDA POSICION DE SUBARREGLO Y ASIGNAMOS A LA VARIABLE K

                    if (arreglo[j] <= arreglo[k]) { //SI LA PRIMERA POSICION ES MENOR A LA SEGUNDA, SE MANTIENE Y SALIMOS
                        j = -1;                   //CON ESTA LINEA LOGRAMOS SALIR DEL WHILE
                    } else {
                        auxiliar = arreglo[j];        //REALIZAMOS EL INTERCAMBIO DE POSICIONES
                        arreglo[j] = arreglo[k];
                        arreglo[k] = auxiliar;
                        j -= salto;//j=j-salto

                    }
                }
            }
            salto = salto / 2;        //OBTENEMOS NUEVO SALTO PARA NUEVA INTERACCION

        }
        imprimir(arreglo);
    }

    public static void imprimir(int[] a) {
        for (int i = 0; i < a.length; i++) { //IMPRIMO 
            System.out.print("[" + a[i] + "]");
        }
        System.out.println("\n");
    }
}
