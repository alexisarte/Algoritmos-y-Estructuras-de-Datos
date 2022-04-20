package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] ars) {
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese un numero: ");
		int n = s.nextInt();
		while (n != 0) {
			int enteros[] = primerosMultiplos(n);
			for (int i = 0; i < enteros.length; i++) {
				System.out.println(enteros[i]);
			}
			System.out.println();
			System.out.print("Ingrese un numero: ");
			n = s.nextInt();
		}
		s.close();
	}

	
	public static int[] primerosMultiplos(int n) {
		int enteros[] = new int[n];
		int k = 1;
		
		for (int i = 0; i < n; i++) {
			enteros[i] = n * k;
			++k;
		}

		return enteros;
	}

}
