package controllers;
import javax.swing.SpinnerNumberModel;

import model.Contador;
import views.View;

public class ContadorController implements View.OnChange,Contador.OnUpdate {
 
 	private Contador _ca;
 	private Contador _cb;
 	private View _view;
 	
 	public ContadorController() {
		
 		_view = new View(this);
 		_view.setVisible(true);
 		_ca = new Contador("A",this);
 		_cb = new Contador("B",this);
 	}
 	
 	@Override
 	public synchronized void onAClick() {
 		if(_ca.isExec())
 			_ca.para();
 		else
 			_ca.exec();
 	}

 	@Override
 	public synchronized void onBClick() {
 		if(_cb.isExec())
 			_cb.para();
 		else
 			_cb.exec();
 	}
 
 	@Override
 	public void onupdate(String tag, int actual) {
 		synchronized(_view) {
 			_view.printState(tag, actual);
 		}
 		
 	}

	@Override
	public void onChangeTimeA(Object v) {
		_ca.setSleep(Long.valueOf(v.toString()).longValue());
		
	}

	@Override
	public void onChangeTimeB(Object v) {
		_cb.setSleep(Long.valueOf(v.toString()).longValue());
		
	}

	@Override
	public SpinnerNumberModel getSpinnerModel() {
		return new SpinnerNumberModel( 
        		new Integer(1000), // Dato visualizado al inicio en el spinner 
        		new Integer(0), // Límite inferior 
        		new Integer(10000), // Límite superior 
        		new Integer(100) // incremento-decremento 
        		);
	}
 
 }
