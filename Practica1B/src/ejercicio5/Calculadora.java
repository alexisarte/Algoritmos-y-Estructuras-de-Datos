package ejercicio5;

public class Calculadora {
	
	private static int minimo;
	private static int maximo;
	private static int promedio;
	
	public static Datos calcularReturn(int[] enteros) {
		Integer  maximo = Integer.MIN_VALUE;
		Integer  minimo = Integer.MAX_VALUE;
		int total = 0;
		int promedio;
		
		for (int i = 0; i < enteros.length; i++) {
			if (enteros[i] > maximo) maximo = enteros[i];
			if (enteros[i] < minimo) minimo = enteros[i];
			total += enteros[i];
		}	
		promedio = total / enteros.length;
		Datos data = new Datos();
		data.setMaximo(maximo);
		data.setMinimo(minimo);
		data.setPromedio(promedio);
		return data;
	}
	
	
	public static void calcularParametro(int[] enteros, Datos data) {
		Integer  maximo = Integer.MIN_VALUE;
		Integer  minimo = Integer.MAX_VALUE;
		int total = 0;
		int promedio;
		
		for (int i = 0; i < enteros.length; i++) {
			if (enteros[i] > maximo) maximo = enteros[i];
			if (enteros[i] < minimo) minimo = enteros[i];
			total += enteros[i];
		}	
		promedio = total / enteros.length;
		data.setMaximo(maximo);
		data.setMinimo(minimo);
		data.setPromedio(promedio);
	}
	
	
	public static void calcular(int[] enteros) {
		Integer  maximo = Integer.MIN_VALUE;
		Integer  minimo = Integer.MAX_VALUE;
		int total = 0;
		int promedio;
		
		for (int i = 0; i < enteros.length; i++) {
			if (enteros[i] > maximo) maximo = enteros[i];
			if (enteros[i] < minimo) minimo = enteros[i];
			total += enteros[i];
		}		
		promedio = total / enteros.length;
		setMaximo(maximo); 
		setMinimo(minimo);
		setPromedio(promedio);
	}

	
	/** Getters y Setters */
	
	public static int getMinimo() {
		return minimo;
	}

	public static void setMinimo(int minimo) {
		Calculadora.minimo = minimo;
	}

	public static int getMaximo() {
		return maximo;
	}

	public static void setMaximo(int maximo) {
		Calculadora.maximo = maximo;
	}

	public static int getPromedio() {
		return promedio;
	}

	public static void setPromedio(int promedio) {
		Calculadora.promedio = promedio;
	}
	
}
