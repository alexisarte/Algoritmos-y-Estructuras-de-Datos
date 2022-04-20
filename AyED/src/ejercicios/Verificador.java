package ejercicios;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class Verificador {

	public boolean estaOrdenada(ListaEnlazadaGenerica<Integer> lista) {
		lista.comenzar();
		return estaOrdenada(lista, -1);
	}

	private boolean estaOrdenada(ListaEnlazadaGenerica<Integer> lista, int anterior) {
		if (!lista.fin()) {
			int actual = lista.proximo();
			if (anterior < actual) {
				return estaOrdenada(lista, actual);
			}
		} else {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		lista.agregarFinal(1);
		lista.agregarFinal(3);
		lista.agregarFinal(5);
		lista.agregarFinal(7);
		
		System.out.println(lista);
		Verificador verificador = new Verificador();
		System.out.println("Esta ordenada? " + verificador.estaOrdenada(lista));
	}

}
