package application.operations;

import java.util.List;

import application.main.Main;
import application.model.Mensaje;

/**
 * Graba los datos de la aplicación en la base de datos para poder recuperar el
 * trabajo realizado la próxima vez que se ejecute
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class GrabarBDOperacion extends Operacion {

	public GrabarBDOperacion(Main main) {
		super(main);
		main.getInterfaz().progresoGrabar();
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		main.grabarTodo();
		return null;
	}

	@Override
	protected void done() {
		main.getInterfaz().progresoCargar();
		this.main.getInterfaz().mostrarResultado();
	}

}
