package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblContador;           // Etiqueta del contador
	private JLabel lblTag;           // Etiqueta del boton pulsado
    private JSpinner spA;        // Spinner para el A
    private JSpinner spB;        // Spinner para el B
    private JButton btnA;          // boton con una determinada accion
    private JButton btnB;          // boton con una determinada accion
    
    private OnChange listener;

    public View(OnChange l) {
        super();  // usamos el contructor de la clase padre JFrame
        listener =l;
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
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
        spA = new JSpinner(listener.getSpinnerModel());       
        spB = new JSpinner(listener.getSpinnerModel());   
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
        
        
        //Llamada a eventos
        setListenerButtonA();
        setListenerButtonB();
        
        addListenerMiliA();
        addListenerMiliB();
        
        // adicionamos los componentes a la ventana
        this.add(this.lblContador);
        this.add(this.lblTag);
        this.add(this.spA);
        this.add(this.spB);
        this.add(this.btnA);
        this.add(this.btnB);
    }
    
    private void setListenerButtonA() {
    	btnA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.onAClick();
			}
    		
    	});
    }

    
    private void setListenerButtonB() {
    	btnB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.onBClick();
			}
    		
    	});
    }
    
    private void addListenerMiliA() {
    	this.spA.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				listener.onChangeTimeA(spA.getValue().toString());
			}
    		
    	});
    }
    
    private void addListenerMiliB() {
    	this.spB.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				listener.onChangeTimeB(spB.getValue().toString());
			}
    		
    	});
    }
    
   

    public void printState(String tag, int value) {
    	this.lblContador.setText(value+"");
    	this.lblTag.setText(tag);
    }
    
    
    public interface OnChange {

    	public void onAClick();
    	public void onBClick();
    	public void onChangeTimeA(Object v);
    	public void onChangeTimeB(Object v);
    	public SpinnerNumberModel getSpinnerModel();

    }


}
