public class Nodo{
    private int dato;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(int dato){
        this.dato = dato;
    }

    public Nodo(){}
    public Nodo getDerecho(){
        return derecho;
    }
    public Nodo getIzquierdo(){
        return izquierdo;
    }
    public int getDato(){
        return dato;
    }
    public void setDato(int dato){
        this.dato = dato;
    }
    public void setDerecho(Nodo nodo){
        derecho = nodo;
    }
    public void setIzquierdo(Nodo nodo){
        izquierdo = nodo;
    }
    
}