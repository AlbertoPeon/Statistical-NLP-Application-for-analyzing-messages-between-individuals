package application.operations;

import java.util.LinkedList;
import java.util.List;

import application.main.Main;
import application.model.Mensaje;

/**
 * Borra todos los datos de la aplicación y de la base de datos
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class BorrarBDOperacion extends Operacion {

	public BorrarBDOperacion(Main m) {
		super(m);
		main.getInterfaz().progresoBorrar();
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		main.borrarTodo();
		return null;
	}

	@Override
	protected void done() {
		main.getInterfaz().progresoCargar();
		this.main.getInterfaz().setListaBusqueda(new LinkedList<Mensaje>());
		this.main.getInterfaz().mostrarResultadoVacia();

	}

}
