import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font; 
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;


public class CalculoSuma extends JFrame implements ActionListener
{
	private JLabel mensaje;
	private JLabel mensaje2;
	private JLabel mensaje3;
	private JLabel mensaje4;
	private JButton boton;
	private JTextField caja;
	private JTextField caja2;
	
	public CalculoSuma()
	{
		super();
		configurarVentana();
		crearComponentes();
	}
	
	private void configurarVentana(){
		this.setTitle("Programa SUMA");
		this.setSize(305,260);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void crearComponentes() {
		mensaje = new JLabel();
		mensaje2 = new JLabel();
		mensaje3 = new JLabel();
		mensaje4 = new JLabel();
		
		Font fuente = new Font("Lucida Sans", 1, 13);
		Font fuente2 = new Font("Arial Black",1, 14);
		
        mensaje.setFont(fuente); 
		mensaje.setText("CALCULAR SUMA DE 2 NUMEROS");
		mensaje.setBounds(40, 1, 260, 50);
		this.add(mensaje);
		mensaje.setForeground(Color.BLUE);
		
		
		mensaje2.setText("Primer numero: ");
		mensaje2.setBounds(50, 60, 100, 30);
		this.add(mensaje2);
		mensaje2.setForeground(Color.BLACK);
		
		caja = new JTextField();
		caja.setBounds(165, 60, 90, 30);
		this.add(caja);
		
        mensaje3.setFont(fuente2); 
		mensaje3.setText("+");
		mensaje3.setBounds(205, 85, 100, 30);
		this.add(mensaje3);
		mensaje3.setForeground(Color.BLACK);
		
		mensaje4.setText("Segundo numero:");
		mensaje4.setBounds(50, 110, 100, 30);
		this.add(mensaje4);
		mensaje4.setForeground(Color.BLACK);
			
		caja2 = new JTextField();
		caja2.setBounds(165, 110, 90, 30);
		this.add(caja2);
		
		boton = new JButton();
		boton.setFont(fuente);
		boton.setText("Calcular");
		boton.setBounds(165, 160, 90, 30);
		boton.addActionListener(this);
		boton.setForeground(Color.BLUE);
		this.add(boton);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String numero1 = caja.getText();
		String numero2 = caja2.getText();

		double cantidad1 = Double.parseDouble(numero1);
		double cantidad2 = Double.parseDouble(numero2);
		double suma = cantidad1 + cantidad2;
		
		JOptionPane.showMessageDialog(this,"El resultado de la suma es: "+suma);
		
			 		
	}
	
	public static void main(String[] args) {
		CalculoSuma ventana = new CalculoSuma();
		ventana.setVisible(true);
	}
}
