package application.operations;

import application.main.Main;

/**
 * Una vez grabados los datos en la base de datos, termina la ejecución de la
 * aplicación
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class GrabarBDSalidaOperacion extends GrabarBDOperacion {

	public GrabarBDSalidaOperacion(Main main) {
		super(main);
	}

	@Override
	protected void done() {
		main.getInterfaz().quit();
	}

}
