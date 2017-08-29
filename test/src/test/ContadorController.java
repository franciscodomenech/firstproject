package test;

public class ContadorController implements OnClick,Contador.OnUpdate {

	private Contador _ca;
	private Contador _cb;
	
	public ContadorController() {
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
		// TODO Auto-generated method stub
		
	}

}
