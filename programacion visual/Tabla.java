package Tablaa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame implements ActionListener{
	private JFrame v;
	private JTable jt;
	private DefaultTableModel model;
	private JButton boton,boton2,boton3;
	private JTextField caja,caja2,caja3;
	private JLabel mensaje;
	private int contador=1;
	String Data = null,data2;
	
	public Tabla() {
		v = new JFrame("Table");
		crearComponentes();
		String data[][] = {
				/*{"1","Tacos","$12.00"},
				{"2","Tamales","$10.00"},
				{"3","Tortas","$35.00"},
				{"4","Cochito","$45.00"}*/
		};
		
		String label[] = {"ID","NOMBRE","PRECIO"};
		
		model = new DefaultTableModel(data,label);
		jt = new JTable(model); 
		
		jt.setCellSelectionEnabled(true);
		
		ListSelectionModel select = jt.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			
			int[] row = jt.getSelectedRows();
			int[] columns = jt.getSelectedColumns();
			
			for(int i=0; i< row.length; i++) 
					Data = (String) jt.getValueAt(row[i], 0);
			
			System.out.println("Table element selected is: "+Data);
			caja.setText((String)jt.getValueAt(Integer.valueOf(Data)-1, 1));
			caja2.setText((String)jt.getValueAt(Integer.valueOf(Data)-1, 2));
			caja3.setText(Data);
		}
		
		});
	
		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(50, 100, 310, 140);
		v.add(sp);
		v.setSize(500,400);
		v .setLocationRelativeTo(null);
		v.setLayout(null);
		v.setVisible(true);	
		
	}
	
	public void addRow(String str1, String str2, String str3) {
		model.addRow(new Object[]{str1,str2,str3});
		model.insertRow(4, new Object[] {"1","Tacos","15"});
	}
	
	private void crearComponentes() {
		mensaje = new JLabel();
		mensaje.setText("Nombre ");
		mensaje.setBounds(50, 15, 200, 30);
		v.add(mensaje);
		mensaje = new JLabel();
		mensaje.setText("Precio ");
		mensaje.setBounds(50, 50, 200, 30);
		v.add(mensaje);
		mensaje = new JLabel();
		mensaje.setText("Id ");
		mensaje.setBounds(200, 260, 40, 25);
		v.add(mensaje);
		caja = new JTextField();
		caja.setBounds(110, 15, 150, 25);
		caja.addActionListener(this);
		v.add(caja);
		caja2 = new JTextField();
		caja2.setBounds(110, 50, 150, 25);
		caja.addActionListener(this);
		v.add(caja2);
		caja3 = new JTextField();
		caja3.setBounds(230, 260, 40, 25);
		v.add(caja3);
		boton = new JButton();
		boton.setText("Agregar");
		boton.setBounds(280, 15, 80,25 );
		boton.setBackground(Color.DARK_GRAY);
		boton.setForeground(Color.white);
		boton.setEnabled(true);
		boton.addActionListener(this);
		v.add(boton);
		boton2 = new JButton();
		boton2.setText("Editar");
		boton2.setBounds(280, 50, 80,25 );
		boton2.setBackground(Color.DARK_GRAY);
		boton2.setForeground(Color.white);
		boton2.addActionListener(this);
		boton2.setVisible(false);
		v.add(boton2);
		boton3 = new JButton();
		boton3.setText("Eliminar");
		boton3.setBounds(280, 260, 80,25 );
		boton3.setBackground(Color.DARK_GRAY);
		boton3.setForeground(Color.white);
		boton3.setEnabled(true);
		boton3.addActionListener(this);
		boton3.setVisible(false);
		v.add(boton3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Agregar":
			String cont2 = String.valueOf(contador);
			model.addRow(new Object[] {cont2,caja.getText(),caja2.getText()});  
			contador++;
		break;
		case "Eliminar":
			try {
			if(model.getRowCount()>0 ) { 
				if(caja3.getText()==null) { 
				int eliminar = Integer.parseInt(Data);
				model.removeRow(eliminar-1);
				} 
				else {
					String aux = caja3.getText();
					int eliminar = Integer.parseInt(aux);  
					model.removeRow(eliminar-1);
				}
			}
			else 
				caja3.setText("Error");
			if(model.getRowCount()==0) {
				contador=1 ;
			}				
			}
			catch(Exception exception){
				boton3.setVisible(false); 
				JOptionPane.showMessageDialog(this, " ...error ");
			}
		break;
		case "Editar":
			model.setValueAt(caja.getText(), (Integer.valueOf(caja3.getText())-1), 1);
			model.setValueAt(caja2.getText(), (Integer.valueOf(caja3.getText())-1), 2);
		break;
		default:
		} 
		if(contador>=1) {
			boton2.setVisible(true);
			boton3.setVisible(true);
		}
		if(contador==1) {
			boton2.setVisible(false);
			boton3.setVisible(false);
		}
	}
	 
	public static void main(String[] args) {
		Tabla i = new Tabla();
		//i.addRow("7", "Gordita", "16");
	}
}
