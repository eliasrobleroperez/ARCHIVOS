import javax.swing.JOptionPane;

public class Captura3 {

 public static void main(String args[]){
  String nombre;
  int edad,respuesta;
  int opcion;
  double estatura;
  int nom =0;
  int nombres[] = {1,2,3,4,5,6};
 
  String auxiliar;
  
  JOptionPane.showMessageDialog(null,"Programa para capturar datos sobre un equipo de FUTBOL");

  do{
  auxiliar = JOptionPane.showInputDialog("Selecciona la opcion que deseas realizar: \n1.-NOMBRE \n2.-EDAD \n3.-ESTATURA \n4.-TELEFONO \n5.-CORREO ");
 
  opcion = Integer.parseInt(auxiliar);
  switch(opcion){
      case 1: 
      nombre=JOptionPane.showInputDialog("Introduce nombre: ");
      try{
        nom = Integer.parseInt(nombre);
        JOptionPane.showMessageDialog(null,"Se han ingresado solo numeros");
      }
      catch(Exception e){
        JOptionPane.showMessageDialog(null, "Tu nombre es: "+nombre);
      }
      break;
      case 2:
      auxiliar=JOptionPane.showInputDialog("Introduce edad: ");
      edad=Integer.parseInt(auxiliar);
      JOptionPane.showMessageDialog(null, "Tu edad es: "+edad);
      break;
      case 3:
      auxiliar=JOptionPane.showInputDialog("Introduce estatura: ");
      estatura=Double.parseDouble(auxiliar);
      JOptionPane.showMessageDialog(null, "Tu estatura es: "+estatura);
      for(int i=0;i<nombres.length;i++){
            JOptionPane.showMessageDialog(null,"Numeros: "+nombres[i]);
      }
      break;

  }
  auxiliar=JOptionPane.showInputDialog("Si desea realizar otra operacion mas escriba 1: ");
  respuesta=Integer.parseInt(auxiliar);

}while(respuesta==1);
  
 }
 
}