import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font; 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Palabra extends JFrame implements ActionListener{
	
	private JLabel mensaje;
	private JLabel mensaje2;
	private JTextField caja;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	private JTextField caja5;


	private JButton boton;

	public Palabra()
	{
		super();
		configurarVentana();
		crearComponentes();
		this.getContentPane().setBackground(Color.BLACK);
		
	}
	private void configurarVentana(){
		this.setTitle("PALABRAS");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void crearComponentes() {
		mensaje = new JLabel();
		mensaje.setText("Palabra:");
		mensaje.setBounds(40, 30, 100, 30);
		this.add(mensaje);
		mensaje.setForeground(Color.WHITE);
		
		caja = new JTextField();
		caja.setBounds(120, 30, 200, 30);
		this.add(caja);
		
		boton = new JButton();
		boton.setText("VERIFICAR");
		boton.setBounds(170, 100, 100, 30);
		boton.addActionListener(this);
		boton.setForeground(Color.BLACK);
		this.add(boton);
		
		mensaje2 = new JLabel();
		mensaje2.setText("Palindromo: ");
		mensaje2.setBounds(40, 150, 100, 30);
		this.add(mensaje2);
		mensaje2.setForeground(Color.WHITE);

		
		caja2 = new JTextField();
		caja2.setBounds(120, 150, 200, 30);
		this.add(caja2);
		
		mensaje2 = new JLabel();
		mensaje2.setText("Longitud: ");
		mensaje2.setBounds(40, 200, 100, 30);
		this.add(mensaje2);
		mensaje2.setForeground(Color.WHITE);
				
		caja3 = new JTextField();
		caja3.setBounds(120, 200, 200, 30);
		this.add(caja3);
		
		mensaje2 = new JLabel();
		mensaje2.setText("Inversa: ");
		mensaje2.setBounds(40, 250, 100, 30);
		this.add(mensaje2);
		mensaje2.setForeground(Color.WHITE);

		
		caja4 = new JTextField();
		caja4.setBounds(120, 250, 200, 30);
		this.add(caja4);
		
		mensaje2 = new JLabel();
		mensaje2.setText("Repetidos: ");
		mensaje2.setBounds(40, 300, 100, 30);
		this.add(mensaje2);
		mensaje2.setForeground(Color.WHITE);
		
		caja5 = new JTextField();
		caja5.setBounds(120, 300, 200, 30);
		this.add(caja5);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String numero1 = caja.getText().toUpperCase();
		String cadena ="";
		String espacios = "";
		int mayor = 0;
		int i = 0;
		char letraRepetida=' ';
			
		for(i=numero1.length()-1;i>=0;i--) {
			if(numero1.charAt(i)==' ') {
				
			}
			else {
				espacios = espacios + numero1.charAt(i);
			}
		}
		for(i=espacios.length()-1;i>-1;i--) {
			cadena = cadena + espacios.charAt(i);
		}
		if(espacios.compareTo(cadena)==0) {
			if(espacios.isEmpty())
				caja2.setText(" ");
			else
				caja2.setText("SI");
				
				
				
			
		}
		else {
			caja2.setText("NO");
		}
		caja4.setText(espacios);
				
		for(i=0; i<espacios.length();i++) {
			int contador = 0;
			
			for(int x=0;x<espacios.length();x++) {
				if(espacios.charAt(x) == espacios.charAt(i)) {
					contador++;
				}
			}
			if(contador>mayor) {
				mayor = contador;
				letraRepetida = espacios.charAt(i);
			}
			
		}
		if(mayor==1) {
			caja5.setText("NINGUNA");
		}
		else{
		String a = String.valueOf(letraRepetida);
		caja5.setText(a);
		}
		if(espacios.isEmpty())
			caja3.setText(" ");
		else
			caja3.setText(String.valueOf(espacios.length()));
	
	}
	public static void main(String[] args) {
		Palabra ventana = new Palabra();
		ventana.setVisible(true);
	}


}
