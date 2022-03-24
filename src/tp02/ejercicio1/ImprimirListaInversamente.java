package tp02.ejercicio1;

public class ImprimirListaInversamente {

	public static void main(String[] args) {
		int[] enteros = { 1, 3, 5, 7 };
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();

		for (int i = 0; i < enteros.length; i++) {
			lista.agregarFinal(enteros[i]);
		}

		mostrarListaInversamente(lista, 1);
	}
								   
	public static void mostrarListaInversamente(ListaDeEnteros lista, int pos) {
		if (pos <= lista.tamanio()) {
			mostrarListaInversamente(lista, pos+1);
			System.out.println(lista.elemento(pos));
		}
	}

}
