package application.operations;

import java.util.concurrent.ExecutionException;
import application.busqueda.CriterioBusqueda;
import application.main.Main;

public class MostrarCriterioBusquedaOperacion extends CriterioBusquedaOperacion {

	public MostrarCriterioBusquedaOperacion(Main main, CriterioBusqueda cb) {
		super(main, cb);
	}

	@Override
	protected void done() {
		try {
			this.main.getInterfaz().setListaBusqueda(get());
			main.getInterfaz().mostrarResultado(get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
