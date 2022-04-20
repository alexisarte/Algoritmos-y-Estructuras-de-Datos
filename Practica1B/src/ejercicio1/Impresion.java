package ejercicio1;

public class Impresion {
	
	public static void main(String[] args) {
		// impresionIterativaFor(1, 10);
		// impresionIterativaWhile(1, 10);
		impresionRecursiva(1, 5);
	}
	
	private static void impresionIterativaFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	private static void impresionIterativaWhile(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	private static void impresionRecursiva(int a, int b) {
		System.out.println(a);
		if (a < b) {
			impresionRecursiva(++a, b);
		}
	}
	
}
