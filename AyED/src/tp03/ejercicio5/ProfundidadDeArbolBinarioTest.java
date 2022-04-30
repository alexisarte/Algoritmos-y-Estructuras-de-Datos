package tp03.ejercicio5;

import tp03.ejercicio2.ArbolBinario;
import tp03.ejercicio2.CrearArbolBinario;

public class ProfundidadDeArbolBinarioTest {

	public static void main(String[] args) {

		CrearArbolBinario crear = new CrearArbolBinario();
		ArbolBinario<Integer> arbol = crear.crearArbolInteger();

		ProfundidadDeArbolBinario profundidad = new ProfundidadDeArbolBinario(arbol);
		int nivel = 2;
		System.out.println("Suma de los elementos en el nivel de profundidad " + nivel + ": "
				+ profundidad.sumaElementosProfundidad(nivel));

	}

}
