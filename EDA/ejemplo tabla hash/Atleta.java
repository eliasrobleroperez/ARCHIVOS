import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Atleta {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Instancia a varias personas
				
		Scanner valor = new Scanner(System.in);
		String case1 = "";
        Persona.leerArchivo("D:\\Documentos\\eclipse-workspace\\Atletas\\src\\atleta.txt");
	    case1 = Persona.leerArchivo("D:\\Documentos\\eclipse-workspace\\Atletas\\src\\atleta.txt");

	       String foo = case1;
	       String[] bar = foo.split("(?=\\s)");
	       String[]var = new String[100];
	       int aux1 =0;
	        for (int i = 0; i < bar.length;i++ ){
	        var[aux1++] = bar[i];
	        } 
	        aux1 --;
	        for(int j = aux1; j >=0;j--){
	        }
		
	        Persona p1 = new Persona (var[0], var[1], 33, var[2]);
			Persona p2 = new Persona (var[3], var[4], 25, var[5]);
			Persona p3 = new Persona (var[6], var[7], 18, var[8]); 
			Persona p4 = new Persona(var[9], var[10],19,var[11]);
			Persona p5 = new Persona(var[12],var[13],21,var[14]);
		
		//Creación de las tablas hash
		Hashtable <String,Persona> tabla = new Hashtable<String,Persona>();
		
		
		//Agrega las personas a la tabla tomando su nombre como clave
		tabla.put(p1.getApellido(), p1);
		tabla.put(p2.getApellido(), p2);
		tabla.put(p3.getApellido(), p3);
		tabla.put(p4.getApellido(), p4);
		tabla.put(p5.getApellido(), p5);
		
		//acceso a cada elemento de la tabla por su clave
		System.out.println(tabla.get(" matuz"));
		System.out.println(tabla.get(" alvarado"));
		System.out.println(tabla.get(" roblero"));
		
		
		//error
		System.out.println(tabla.get("Paola"));
		
		System.out.println(" ");
		System.out.println("Ingrese el apellido a buscar; ");
		String apellido = valor.nextLine();
		
		
		String aux = " " + apellido;
		
		if(tabla.get(aux).equals(null)) {
			System.out.println("null");
		}
		else {
			System.out.println(tabla.get(aux).resultado());
		}
		
		System.out.println(" ");
		Enumeration <String> claves = tabla.keys(); // Crea una enumeración para las claves
		while(claves.hasMoreElements()) {    //Se recorre la tabla
			aux=claves.nextElement();
			System.out.println(aux+" = " + tabla.get(aux).resultado());
		}
	}

}
