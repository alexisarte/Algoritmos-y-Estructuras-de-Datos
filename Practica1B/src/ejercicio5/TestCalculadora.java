package ejercicio5;

public class TestCalculadora {

	public static void main(String[] args) {
		int numeros[] = { 3, 8, 9, 2, 5, 1 };
//		Datos data = new Datos();

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Elemento " + i + ": " + numeros[i]);
		}
		System.out.println();
		
		/*
		 * a. Devuelva lo pedido por el mecanismo de retorno de un método en Java
		 * ("return").
		 */
//		data = Calculadora.calcularReturn(enteros);
		
		/*
		 * b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no
		 * puede ser de tipo arreglo).
		 */
//		Calculadora.calcularParametro(enteros, data);
		
//		System.out.println("Valor minimo: " + data.getMin());
//		System.out.println("Valor maximo: " + data.getMax());
//		System.out.println("Promedio: " + data.getPromedio());
		
		/* c. Devuelva lo pedido sin usar parámetros ni la sentencia "return". */
		Calculadora.calcular(numeros);
		System.out.println("Valor minimo: " + Calculadora.getMinimo());
		System.out.println("Valor maximo: " + Calculadora.getMaximo());
		System.out.println("Promedio: " + Calculadora.getPromedio());
	}

}
