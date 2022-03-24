package tp02.ejercicio1;

public class Ejercicio1_6 {

	public static void main(String[] args) {
		Ejercicio1_6 f = new Ejercicio1_6();
		ListaDeEnterosEnlazada l = f.calcularSucesion(4);
		// código que recorre e imprime los valores de l
		l.comenzar();
		
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
	}
	
	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada l;
		if (n == 1) {
			l = new ListaDeEnterosEnlazada();
			l.agregarInicio(n);
		} else if (n % 2 == 0) {
			l = calcularSucesion(n / 2);
			l.agregarInicio(n);
		} else {
			l = calcularSucesion((3 * n) + 1);
			l.agregarInicio(n);
		}
		return l;
	}
	
}
