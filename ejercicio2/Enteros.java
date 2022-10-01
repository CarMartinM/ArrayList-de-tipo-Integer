/*
 * Ejercicio 2. Desarrolla un programa que lea una serie de valores numéricos enteros
 * desde el teclado y los guarde en un ArrayList de tipo Integer. La lectura de números
 * terminará cuando se introduzca el valor -1. Este valor no se almacenará en el ArrayList.
 * A continuación el programa mostrará por pantalla el número de valores que se han leído,
 * su suma y su media. Por último se mostrarán todos los valores leídos, indicando cuántos
 * de ellos son mayores que la media
 */

package dam2.inicial.ejercicio2;
import java.util.ArrayList;
import java.util.Scanner;

public class Enteros 
{
	public static int sumaEnteros( ArrayList<Integer>listaEnterosParametro)
	{
		int sumatorioEnteros = 0;
		
		for (int i =0; i<listaEnterosParametro.size(); i++)
		{
			sumatorioEnteros += listaEnterosParametro.get(i);
		}
		return sumatorioEnteros;
	}
	
	public static void mostrarValores ( double mediaParametro ,ArrayList<Integer>listaEnterosParametro)
	{
		System.out.println("-------- LISTA DE ENTEROS --------");
		for (int i =0; i<listaEnterosParametro.size() ;i++)
		{
			if (listaEnterosParametro.get(i)> mediaParametro)
			{
				System.out.printf( listaEnterosParametro.get(i) + " es mayor que la media. Media = %.2f\n" , mediaParametro);
			}
			else
			{
				System.out.println( listaEnterosParametro.get(i));
			}
		}		
	}
	
	public static void main(String[] args)
	{
		Scanner scan =new Scanner (System.in);
		
		int entero = 0;
		double contadorDeEnteros = 0;
		
		// Creamos un ArrayList de números enteros, donde se irán almacenando.
		ArrayList<Integer> listaEnteros = new ArrayList<Integer>();
		
		do 
		{
			// Pedimos que se introduzca una serie de valores enteros por teclado.
			System.out.println("Por favor introduzca un número entero positivo o la cifra (-1) para terminar");
			
			// Los recogemos del teclado.
			entero = scan.nextInt();
			
			// Los vamos almacenando en un ArrayList de tipo Integer.
			if ((entero != -1) && (entero >= 0))
			{
				listaEnteros.add( entero);
				contadorDeEnteros++;	
			}
			else if (entero<-1)
			{
				System.out.println("Cifra no válida");
			}
	
			else  // Si se introduce -1, se acaba de completar la lista de enteros.
			{
				System.out.println("Lista de enteros completada");
			}		
		}
		while (entero != -1);
		
		if (listaEnteros.size() == 0)
		{
			System.out.println("La lista se encuentra vacía");
			System.exit(0);
		}
		
		// Con el contador evaluamos las veces que se ha introducido un entero a la lista.
		System.out.println("Se han introducido " + (int)contadorDeEnteros + " números enteros en la lista.");
		
		//Almacenamos en la variable sumatorio la cifra recibida del método sumaEnteros y lo imprimimos por pantalla.
		int sumatorio = sumaEnteros (listaEnteros);
		
		System.out.println("El valor de la suma total de los números almacenados en la lista es " + sumatorio);
		
		// Almacenamos en la variable media el sumatorio del total de los valores divididos entre el número total de estos.
		double media = sumatorio / contadorDeEnteros;
		System.out.printf("La media de los valores almacenados en la lista es %.2f \n", media);
		
		//Llamamos al método mostrarValores para imprimir el resultado.
		mostrarValores(media,listaEnteros);
		
		
	}

}
