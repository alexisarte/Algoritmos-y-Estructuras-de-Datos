package tp03.ejercicio2;

public class ArbolBinarioTest {

	public static void main(String[] args) {
		CrearArbolBinario crear = new CrearArbolBinario(); 
		ArbolBinario<Integer> arbol = crear.crearArbolInteger();
		
		arbol.recorridoPorNiveles();
		System.out.println();
		
		System.out.println("Arbol Espejo: ");
		arbol.espejo().recorridoPorNiveles();
		System.out.println();
		
		System.out.println("Cantidad de hojas: " + arbol.contarHojas());
	}

}
