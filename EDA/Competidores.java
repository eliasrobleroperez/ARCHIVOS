
import java.util.Enumeration;
import java.util.Hashtable;

import java.io.*;
import java.util.Scanner;
public class Competidores{
    public  static void main(String[] args) throws IOException{
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese el apellido que desea buscar");
        System.out.print("Apellido: ");
        String apellidoBuscar = entrada.nextLine();
        System.out.println("-------------------------------------");
        buscar(apellidoBuscar);
        
    }

    public static Hashtable <String, Competidor> leerArchivo(String nombreArchivo) throws FileNotFoundException,IOException{ 
        Hashtable <String, Competidor> tabla = new Hashtable <String, Competidor>();
        String texto;
        FileReader archivo = new FileReader(nombreArchivo);//Buscar el archivo
        BufferedReader contenedor = new BufferedReader(archivo);//Almacenar el contenido del archivo
        while((texto = contenedor.readLine())!=null){//Leer linea por linea
            tabla.put(crearCompetidor(texto).getApellido(), crearCompetidor(texto));
        }
        contenedor.close();
        return tabla;
    }

    public static Competidor crearCompetidor(String texto) throws FileNotFoundException, IOException {
        Competidor competidor;
        String[] palabras;
        palabras = texto.split(" ");
        int edad = Integer.parseInt(palabras[2]);
        competidor = new Competidor(palabras[0], palabras[1], edad,palabras[3]);
        return competidor;
    }

    public static void buscar(String apellido)throws FileNotFoundException, IOException {
        Hashtable <String, Competidor> tabla = new Hashtable<String,Competidor>();
        String aux;
        int bandera=0;
		Enumeration <String> claves = leerArchivo("competidores.txt").keys();
		while (claves.hasMoreElements()) {
			aux = claves.nextElement();
            System.out.println(aux+" = "+leerArchivo("competidores.txt").get(aux).getApellido());
        }
        
        if(leerArchivo("competidores.txt").get(apellido)==null){
            System.out.println("============================================");
            System.out.println("El competidor no se encuentra en la tabla");  
        }
       else{
           System.out.println("============================================");
            System.out.println("El competidor es "+leerArchivo("competidores.txt").get(apellido).getNombre()+" "+leerArchivo("competidores.txt").get(apellido).getApellido()+" "+leerArchivo("competidores.txt").get(apellido).getEdad()+" "+leerArchivo("competidores.txt").get(apellido).getOrigen());
        }
    }
}
