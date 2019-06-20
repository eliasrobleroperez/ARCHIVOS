import java.util.Enumeration;
import java.util.Hashtable;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.TreeSet;

public class competidorMain{
    public  static void main(String[] args) throws IOException{
        Scanner teclado = new Scanner(System.in);
    
            System.out.println("-Ingrese el folio que desea buscar: ");
            System.out.print("-Folio: ");
            int dato = teclado.nextInt();
            System.out.println("\nDatos de la tabla: ");
            System.out.println(" ");
            buscarPersona(dato);
    }
    public static void  buscarPersona(int folio) throws FileNotFoundException,IOException{
        int auxiliar;
        Enumeration <Integer> clave = leerArchivo("archivo.txt").keys();
        TreeSet<Integer> tree = new TreeSet<Integer>();
        Hashtable <Integer, Persona> tt = new Hashtable <Integer, Persona>();
        Scanner teclado  = new Scanner(System.in);
        tt = leerArchivo("archivo.txt");

		while (clave.hasMoreElements()) {
			auxiliar = clave.nextElement();
            System.out.println(auxiliar+" = "+tt.get(auxiliar).getFolio());
            tree.add(tt.get(auxiliar).getFolio());
        }
        
        if(tt.get(folio)==null){
            System.out.println(" ");
            System.out.println("-El competidor no se encuentra");  
        }
       else{
           System.out.println(" ");
            System.out.println("-El competidor es "+" NOMBRE: "+tt.get(folio).getNombre()+"  / APELLIDO: "+tt.get(folio).getApellido()+"  / EDAD: "+tt.get(folio).getEdad()+"  / ORIGEN: "+tt.get(folio).getOrigen()+"  / FOLIO: "+tt.get(folio).getFolio());
        }
        System.out.println("\n-Elementos del arbol: ");
		System.out.println(" ");
		
		for(Iterator<Integer> it = tree.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
        System.out.println();

        System.out.println("-Desea eliminar?: ");
        System.out.println("1.-SI / 2.-NO");
        System.out.print("-Respuesta: ");
        int respuesta = teclado.nextInt();
        if(respuesta == 1){
            System.out.println("\n-INGRESE EL FOLIO A ELIMINAR");
            System.out.print("Folio: ");
            int ef = teclado.nextInt();
            tree.remove(ef);
            tt.remove(ef);
        
        System.out.println("\n-Elementos del arbol despues de eliminar: ");

        for(Iterator<Integer> it = tree.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
        System.out.println(" ");

        System.out.println("-Ingrese folio a a buscar: ");
        System.out.print("-Folio: ");
        int buscar = teclado.nextInt();

        while (clave.hasMoreElements()) {
			auxiliar = clave.nextElement();
            System.out.println(auxiliar+" = "+tt.get(folio).getFolio());
        }
        try{

        boolean resp = tree.contains(buscar);
        System.out.println(tree.contains(buscar));

        if(resp == true){
            System.out.println("-El competidor es "+" NOMBRE: "+tt.get(folio).getNombre()+"  / APELLIDO: "+tt.get(folio).getApellido()+"  / EDAD: "+tt.get(folio).getEdad()+"  / ORIGEN: "+tt.get(folio).getOrigen()+"  / FOLIO: "+tt.get(folio).getFolio());
        }
        else{
            System.out.println("El competidor no se encuentra");  
        }
    }catch(Exception e){}   
    }

else{
    System.out.println(" FIN DE LA EJECUCION ");
}}
   
    public static Hashtable <Integer, Persona> leerArchivo(String nombreArchivo) throws FileNotFoundException,IOException{ 
        Hashtable <Integer, Persona> t = new Hashtable <Integer, Persona>();
        String info;
        FileReader archivo = new FileReader(nombreArchivo);
        BufferedReader contenedor = new BufferedReader(archivo);
        while((info = contenedor.readLine())!=null){
            t.put(crearPersona(info).getFolio(), crearPersona(info));
        }
        contenedor.close();
        return t;
    }

    public static Persona crearPersona(String info){
        Persona persona;
        String[] partes;
        partes = info.split(" ");
        int atributoEdad = Integer.parseInt(partes[2]);
        int atributoFolio = Integer.parseInt(partes[4]);
        persona = new Persona(partes[0], partes[1], atributoEdad,partes[3],atributoFolio);
        return persona;
    }
   
}