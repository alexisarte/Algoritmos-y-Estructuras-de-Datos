package ejercicio3;

public class Test {

	public static void main(String[] args) {
		Estudiante estudiantes[] = new Estudiante[2];

		Estudiante estudiante1 = new Estudiante();
		estudiante1.setNombre("Juan");
		estudiante1.setApellido("Perez");
		estudiante1.setComision("2B");
		estudiante1.setEmail("juan.perez@gmail.com");
		estudiante1.setDireccion("La tierra prometida");
		estudiantes[0] = estudiante1;

		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("Maria");
		estudiante2.setApellido("Atahualpa");
		estudiante2.setComision("3A");
		estudiante2.setEmail("maria.atahualpa@gmail.com");
		estudiante2.setDireccion("Nunca jamas");
		estudiantes[1] = estudiante2;

		for (int i = 0; i < estudiantes.length; i++) {
			System.out.println(estudiantes[i].tusDatos());

		}

		
		Profesor profesores[] = new Profesor[3];

		Profesor profesor1 = new Profesor();
		profesor1.setNombre("Juanito");
		profesor1.setApellido("Perez");
		profesor1.setEmail("juanito.perez@gmail.com");
		profesor1.setCatedra("Matematica");
		profesor1.setFacultad("Facultad de Informatica");
		profesores[0] = profesor1;

		Profesor profesor2 = new Profesor();
		profesor2.setNombre("Juani");
		profesor2.setApellido("Perez");
		profesor2.setEmail("juani.perez@gmail.com");
		profesor2.setCatedra("Matematica");
		profesor2.setFacultad("Facultad de Informatica");
		profesores[1] = profesor2;
		
		Profesor profesor3 = new Profesor();
		profesor3.setNombre("Juancho");
		profesor3.setApellido("Perez");
		profesor3.setEmail("juancho.perez@gmail.com");
		profesor3.setCatedra("Matematica");
		profesor3.setFacultad("Facultad de Informatica");
		profesores[2] = profesor3;
		
		for (int i = 0; i < profesores.length; i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}

}
