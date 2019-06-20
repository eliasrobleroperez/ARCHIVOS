import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Persona {

	private String origen;
	private String nombre;
	private String apellido;
	
	private int edad;
	
	public Persona(String nombre, String apellido, int edad, String origen) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.origen = origen;
	}
	
	public static String leerArchivo(String dato) throws FileNotFoundException, IOException {


        String contenedor;
        FileReader archivo = new FileReader(dato);
        BufferedReader b = new BufferedReader(archivo);

        contenedor = b.readLine();
        b.close(); 
        return contenedor;

    
    }

	public String resultado() {
		return nombre+", " + apellido + ", " + edad + "" + origen;
	}

	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	public String getNacionalidad() {
		return origen;
	}


	public void setNacionalidad(String origen) {
		this.origen = origen;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	


}
