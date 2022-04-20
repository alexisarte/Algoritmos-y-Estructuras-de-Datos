package tp02.ejercicio2;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {

		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<>();

		Estudiante estudiante1 = new Estudiante();
		estudiante1.setNombre("Juan");estudiante1.setApellido("Perez");
		estudiante1.setComision("2B");estudiante1.setEmail("juan.perez@gmail.com");
		estudiante1.setDireccion("La tierra prometida");
		lista.agregarFinal(estudiante1);

		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("Maria");estudiante2.setApellido("Atahualpa");
		estudiante2.setComision("3A");estudiante2.setEmail("maria.atahualpa@gmail.com");
		estudiante2.setDireccion("Nunca jamas");
		lista.agregarFinal(estudiante2);

		Estudiante estudiante3 = new Estudiante();
		estudiante3.setNombre("Jose");estudiante3.setApellido("Gimenez");
		estudiante3.setComision("3B");estudiante3.setEmail("jose.gimenez@gmail.com");
		estudiante3.setDireccion("La tierra prometida");
		lista.agregarInicio(estudiante3);

		Estudiante estudiante4 = new Estudiante();
		estudiante4.setNombre("Anita");estudiante4.setApellido("Pinedo");
		estudiante4.setComision("1A");estudiante4.setEmail("anita.pinedo@gmail.com");
		estudiante4.setDireccion("Nunca jamas");
		lista.agregarEn(estudiante4, 2);
		
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
		}
	}

}
