package tp02.ejercicio1;

public class Ejercicio1_6 {

	public static void main(String[] args) {
		Ejercicio1_6 f = new Ejercicio1_6();
		ListaDeEnterosEnlazada lista = f.calcularSucesion(6);
		// código que recorre e imprime los valores de lis
		lista.comenzar();

		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}

	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada lista;
		if (n == 1) {
			lista = new ListaDeEnterosEnlazada();
		} else if (n % 2 == 0) {
			lista = calcularSucesion(n / 2);
		} else {
			lista = calcularSucesion((3 * n) + 1);
		}
		lista.agregarInicio(n);
		return lista;
	}

}
