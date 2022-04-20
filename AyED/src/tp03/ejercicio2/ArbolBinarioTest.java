package tp03.ejercicio2;

public class ArbolBinarioTest {

	public static void main(String[] args) {
		
		CrearArbolBinario crear = new CrearArbolBinario(); 
		ArbolBinario<Integer> arbol = crear.crearArbolDeEnteros();
		
		System.out.println("Cantidad de hojas: " + arbol.contarHojas());
		
		arbol.printPreorden();
		
		System.out.println("----------------");
		
		arbol.espejo().printPreorden();
		
		System.out.println("----------------");
		
		arbol.recorridoPorNiveles();
	}

}
