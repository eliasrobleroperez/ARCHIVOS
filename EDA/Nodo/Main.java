import java.util.Scanner;
public class Main{
    static int valor2 =0;
    public static void main(String[] args){
     Scanner teclado = new Scanner(System.in);
    int repetir =0;
    Nodo raiz = new Nodo();
    int dato = 0;
    int respuesta=0;
  
    do{
        System.out.println("\nSeleccione la opcion");
        System.out.println("1.-CREAR ARBOL");
        System.out.println("2.-RECORRIDOS");
        System.out.println("3.-BUSQUEDA");
        System.out.println("4.-ARBOL ORDENADO");
        System.out.println("5.-INSERTAR NUEVO NODO");
        System.out.println("6.-ELIMINAR NODO");
        System.out.println("7.-CANTIDAD DE NODOS");
        System.out.println("8.-CANTIDAD DE HOJAS");
        System.out.println("9.-SALIR");

        System.out.print("RESPUESTA: ");
    
     respuesta=teclado.nextInt();

    switch(respuesta){
        case 1:
            System.out.println("Ingrese el dato");
            dato = teclado.nextInt();
            raiz.setDato(dato);
            crearArbol(raiz);
        break;
        case 2:
            System.out.println("INGRESE EL NUMERO DEL RECORRIDO QUE DESEA REALIZAR: ");
            System.out.println("1.-PREORDEN   2.-INORDEN   3.-POSTORDEN");
            System.out.print("Respuesta: ");
            int resp = teclado.nextInt();
            switch(resp){
                case 1:
                preorden(raiz);
                break;
                case 2:
                inOrden(raiz);
                break;
                case 3:
                postOrden(raiz);
                break;
            }

        break;
        case 3:
            System.out.println("INGRESE EL NODO A BUSCAR: ");
            System.out.println("NODO: ");
            int buscado = teclado.nextInt();
            busqueda(raiz, buscado);
        break;
        case 4: 
            System.out.print("-INGRESE EL VALOR DE LA RAIZ: ");
            raiz.setDato(teclado.nextInt());
            System.out.print("-INGRESAR UN NUEVO NODO ESCRIBA 1, SI NO ESCRIBA UN NUMERO DIFERENTE: ");
            int ingresar = teclado.nextInt();
            while(ingresar==1){
                System.out.print("VALOR DEL NODO: ");
                int valor = teclado.nextInt();
                arbolOrdenado(raiz,valor);
                
                System.out.print("-INGRESAR UN NUEVO NODO ESCRIBA 1, SI NO ESCRIBA UN NUMERO DIFERENTE: ");
                ingresar = teclado.nextInt();
            }

        break;
        case 5:
            System.out.print("INGRESE EL VALOR DEL NUEVO NODO: ");
            int nuevoNodo = teclado.nextInt();
            insertarNuevo(raiz,nuevoNodo);
            System.out.print("-INGRESAR UN NUEVO NODO ESCRIBA 1, SI NO ESCRIBA UN NUMERO DIFERENTE: ");
            int ingresarN = teclado.nextInt();
            while(ingresarN==1){
                System.out.print("INGRESE EL VALOR DEL NUEVO NODO: ");
                int valor = teclado.nextInt();
                insertarNuevo(raiz,nuevoNodo);
                
                System.out.print("-INGRESAR UN NUEVO NODO ESCRIBA 1, SI NO ESCRIBA UN NUMERO DIFERENTE: ");
                ingresarN = teclado.nextInt();
            }

        break;
        case 6:
            System.out.print("INGRESE EL VALOR DEL NODO QUE DESEA ELIMINAR: ");
            dato = teclado.nextInt();
            eliminar(raiz, dato);

        break;
        case 7: 
            System.out.print("LA CANTIDAD DE NODOS ES: "+totalNodos(raiz));
            
        break;
        case 8: 
            System.out.print("LA CANTIDAD DE HOJAS ES: "+totalHojas(raiz));
            
        break;
    }

    }while(respuesta>=1 && respuesta<=8);
    }
    public static void crearArbol(Nodo nodo){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Tiene hijo izquierdo? ");
        System.out.println("1.-SI     2.-NO");
        int resp = teclado.nextInt();
        if(resp==1){
            System.out.println("Ingrese el dato: ");
            int valor = teclado.nextInt();
            Nodo subizq = new Nodo(valor);
            nodo.setIzquierdo(subizq); 
            crearArbol(subizq);
            
        }
        System.out.println("Tiene hijo derecho? ");
        System.out.println("1.-SI     2.-NO");
        int resp2 = teclado.nextInt();
        if(resp2==1){
            System.out.println("Ingrese el dato: ");
            valor2 = teclado.nextInt();
            Nodo subder = new Nodo(valor2);
            nodo.setDerecho(subder);
            crearArbol(subder);

        }

    }
    public static void arbolOrdenado(Nodo raiz, int numero){
        int dato = raiz.getDato();
        int datoNuevo;

        if( dato > numero){
            if(raiz.getIzquierdo() == null) {
                Nodo subizquierdo = new Nodo(numero);
                raiz.setIzquierdo(subizquierdo);
            }else {
                arbolOrdenado(raiz.getIzquierdo(),numero);
            }
            
        }
        datoNuevo = raiz.getDato();
        if(datoNuevo < numero){
            
            if(raiz.getDerecho() == null) {
                Nodo subDerecho = new Nodo(numero);
                raiz.setDerecho(subDerecho);
            }else {
                arbolOrdenado(raiz.getDerecho(),numero);
            }
            
        }


    }

    public static void insertarNuevo(Nodo raiz, int numero){
        int dato = raiz.getDato();
        int datoNuevo;

        if( dato > numero){
            if(raiz.getIzquierdo() == null) {
                Nodo subizquierdo = new Nodo(numero);
                raiz.setIzquierdo(subizquierdo);
            }else {
                arbolOrdenado(raiz.getIzquierdo(),numero);
            }
            
        }
        datoNuevo = raiz.getDato();
        if(datoNuevo < numero){
            
            if(raiz.getDerecho() == null) {
                Nodo subDerecho = new Nodo(numero);
                raiz.setDerecho(subDerecho);
            }else {
                arbolOrdenado(raiz.getDerecho(),numero);
            }
            
        }


    }

    
    public static void preorden(Nodo raiz){
        if(raiz!=null){
            System.out.println(raiz.getDato());
            preorden(raiz.getIzquierdo());
            preorden(raiz.getDerecho());
        }
    }
    public static void inOrden(Nodo raiz){
        if(raiz!=null){
            inOrden(raiz.getIzquierdo());
            System.out.println(raiz.getDato());
            inOrden(raiz.getDerecho());
        }
    }
    public static void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.getIzquierdo());
            postOrden(raiz.getDerecho());
            System.out.println(raiz.getDato());
        }
    }
    public static void busqueda(Nodo raiz, int buscado){
        if(buscado>raiz.getDato()){
            if(raiz.getDerecho()!=null){
                busqueda(raiz.getDerecho(), buscado);
            }
            else{
                System.out.println("NO ENCONTRADO");
            }
        }
        if(buscado<raiz.getDato()){
            if(raiz.getIzquierdo()!=null){
                busqueda(raiz.getIzquierdo(), buscado);
            }
            else{
                System.out.println("NO ENCONTRADO");
            }
        }
        else{
            System.out.println("ENCONTRADO");
        }
    }
    public static Nodo eliminar(Nodo raizSub, int dato){
        if (raizSub == null)    
            System.out.println("NO SE HA ENCONTRADO EL NODO CON LA CLAVE");
        else if (dato<raizSub.getDato()) {  
            Nodo iz;  
            iz = eliminar(raizSub.getIzquierdo(), dato);
            raizSub.setIzquierdo(iz);	} 
        else if (dato>raizSub.getDato())	{  
            Nodo dr;  dr = eliminar(raizSub.getDerecho(), dato);  
            raizSub.setDerecho(dr);	} 
        else{  
            Nodo q;           
            q = raizSub;          
            if (q.getIzquierdo()== null)   
                raizSub = q.getDerecho();  
            else if (q.getDerecho() == null)   
                raizSub = q.getIzquierdo();  
            else  {            
                q = reemplazar(q);		
            }  
            q = null;	
        } 
        return raizSub;
    }
    
    public static Nodo reemplazar(Nodo act){
        Nodo a, p; 
        p = act; 
        a = act.getIzquierdo();	 
        while (a.getDerecho()!= null)	{  
            p = a; 
            a = a.getDerecho();
        }
        act.setDato(a.getDato()); 
        if (p == act)  
            p.setIzquierdo(a.getIzquierdo()); 
        else  p.setDerecho(a.getIzquierdo()); 
        return a;
    }
    public static int totalNodos(Nodo raiz){
        if(raiz==null){
            return 0;
        }
        else{
            return 1+totalNodos(raiz.getIzquierdo())+totalNodos(raiz.getDerecho());
        }

    }
    public static int totalHojas(Nodo raiz){
        if(raiz!=null){
        if(raiz.getIzquierdo()==null && raiz.getDerecho()==null){
            return 1;
        }
        else if(raiz.getDerecho()!=null){
            return 0+totalHojas(raiz.getDerecho())+totalHojas(raiz.getIzquierdo());
        }
        else if(raiz.getIzquierdo()!=null){
            return 0+totalHojas(raiz.getDerecho())+totalHojas(raiz.getIzquierdo());
        }
        else{
            return 0;
        }
    }
    else{
        return 0;
}
    
        
    
}
}

