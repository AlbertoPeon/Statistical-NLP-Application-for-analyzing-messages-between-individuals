package application.operations;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import application.classifier.FiltroMensajes;
import application.main.Main;
import application.model.Etiqueta;
import application.model.Mensaje;

/**
 * Realiza la operación de etiquetar a aquellos mensajes que han sido obtenidos
 * al buscar mensajes similares
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EtiquetarMensajesSimilaresOperacion extends
		MensajesSimilaresOperacion {
	private List<Etiqueta> etiquetas;

	public EtiquetarMensajesSimilaresOperacion(Main m, Mensaje mensaje,
			List<Etiqueta> etiquetas, FiltroMensajes filtro) {
		super(m, mensaje, filtro);
		this.etiquetas = etiquetas;

	}

	public EtiquetarMensajesSimilaresOperacion(Main m, Mensaje mensaje,
			Etiqueta etiqueta, FiltroMensajes filtro) {
		super(m, mensaje, filtro);
		this.etiquetas = new LinkedList<Etiqueta>();
		this.etiquetas.add(etiqueta);

	}

	@Override
	protected void done() {
		try {
			main.etiquetarMensajes(get(), etiquetas);
			main.getInterfaz().setListaBusqueda(get());
			main.getInterfaz().mostrarResultado(get());
			main.getInterfaz().finalizarCarga();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
