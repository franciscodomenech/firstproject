package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import test.OnClick;

public class view extends JFrame {

	private JLabel lblContador;           // Etiqueta del contador
	private JLabel lblTag;           // Etiqueta del boton pulsado
    private JSpinner spA;        // Spinner para el A
    private JSpinner spB;        // Spinner para el B
    private JButton btnA;          // boton con una determinada accion
    private JButton btnB;          // boton con una determinada accion
    private OnClick _listener;

    public view(OnClick listener) {
        super();                    // usamos el contructor de la clase padre JFrame
        _listener=listener;
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
        setVisible(true);
    }

    private void configurarVentana() {
    	
        this.setTitle("Hilos");                   // colocamos titulo a la ventana
        this.setSize(300, 200);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        // creamos los componentes
    	lblContador= new JLabel();           
    	lblTag = new JLabel();    
        spA = new JSpinner();       
        spB = new JSpinner();   
        btnA = new JButton(); 
        btnB = new JButton();
        
        // configuramos los componentes
        lblContador.setText("0");    // colocamos un texto a la etiqueta
        lblContador.setBounds(80, 10, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        lblTag.setText("-");    // colocamos un texto a la etiqueta
        lblTag.setBounds(200, 10, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        
        spA.setBounds(70, 50, 60, 25);
        spB.setBounds(170, 50, 60, 25);
        
        btnA.setText("A");   // colocamos un texto al boton
        btnB.setText("B");
        btnA.setBounds(50, 100, 100, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        btnB.setBounds(150, 100, 100, 30);
        
        
        
        setOnlistenerButonA();
        setOnlistenerButonB();
        
        
        // adicionamos los componentes a la ventana
        this.add(this.lblContador);
        this.add(this.lblTag);
        this.add(this.spA);
        this.add(this.spB);
        this.add(this.btnA);
        this.add(this.btnB);
    }

    private void setOnlistenerButonA () {
    	btnA.addActionListener(new ActionListener() { //Detectamos evento

			@Override
			public void actionPerformed(ActionEvent arg0) { //Realizamos accion
				_listener.onAClick();
				
			}
    		
    	});
    }
    
    private void setOnlistenerButonB () {
    	btnB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				_listener.onBClick();
				
			}
    		
    	});
    }
    public void printState(String tag, int actual) {
    	
    	this.lblTag.setText(tag);
    	this.lblContador.setText(""+actual);
    }

}
