package Vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {
	
	
	public Ventana (String title) {
		
		
		super(title);
		setVisible(true);
		setSize(500, 500);
		//MiVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		JButton boton = new JButton();
		boton.setText("A");
		//Colocamos la posición y el tamaño
		boton.setBounds(115,300,130,50);
		//Esto se útiliza para agregar el botón al JFrame
		add(boton);
		
		JButton botonB = new JButton();
		botonB.setText("B");
		//Colocamos la posición y el tamaño
		botonB.setBounds(280, 300, 130, 50);
		//Esto se útiliza para agregar el botón al JFrame
		add(botonB);
		
		JLabel labelA = new JLabel();
		labelA.setText("1000");
		labelA.setBounds(115, 200, 130, 50);
		add(labelA);
		
	}
	
	
}
