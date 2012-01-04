package application.operations;

import java.util.List;

import application.main.Main;
import application.model.Mensaje;

/**
 * Esta clase realiza la operación de cargar los datos desde un archivo de texto
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class CargarOperacion extends Operacion {

	public CargarOperacion(Main main) {
		super(main);
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		main.cargarMensajes();
		return null;
	}

	@Override
	protected void done() {
		new CargarBDOperacion(main).execute();
	}

}
