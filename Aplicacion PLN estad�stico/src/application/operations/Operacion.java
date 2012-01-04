package application.operations;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import application.main.Main;
import application.model.Mensaje;

/**
 * Clase que extiende la clase SwingWorker de Java SE6 que sirve para realizar
 * operaciones que necesitan bastante tiempo para ejecutarse y mientras se
 * realizan se necesitan actualizar componentes Swing en la interfaz gráfica. De
 * esta forma, se intenta que todos los elementos de la interfaz se accedan
 * desde el Event Dispatch Thread y las operaciones largas en otro hilo nuevo.
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class Operacion extends SwingWorker<List<Mensaje>, Integer> {
	protected Main main;

	public Operacion(Main m) {
		this.main = m;
		main.getInterfaz().setProgresoIndeterminado(true);
	}

	/**
	 * El método process recibe trozos de información del EDT que permiten saber
	 * en qué momento se encuentra la operación
	 * 
	 * @param list
	 *            lista con los resultados alcanzados hasta el momento por la
	 *            operación
	 */
	@Override
	protected void process(List<Integer> list) {
		main.getInterfaz().actualizarValorProgreso(list.get(list.size() - 1));
	}

	/**
	 * Permite preparar el medidor de progreso para la tarea que se va a
	 * realizar
	 * 
	 * @param sizeProgreso
	 *            tamaño total del progreso
	 */
	protected void seleccionarMaxTarea(final int sizeProgreso) {
		try {
			if (!SwingUtilities.isEventDispatchThread()) {
				SwingUtilities.invokeAndWait(new Runnable() {
					@Override
					public void run() {
						main.getInterfaz().seleccionarMaxTareaProgreso(
								sizeProgreso);

					}
				});
			} else {
				main.getInterfaz().seleccionarMaxTareaProgreso(sizeProgreso);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Calcula una operación que puede llevar bastante tiempo, para ello se
	 * realiza en un hilo a parte
	 * 
	 * @return el resultado calculado, en nuestro caso, una lista de mensajes
	 */
	@Override
	abstract protected List<Mensaje> doInBackground() throws Exception;

	/**
	 * Una vez se termina la ejecución del método doInBackground(), se ejecuta
	 * el método done(). Este método se ejecuta desde el EDT
	 */
	@Override
	abstract protected void done();

}