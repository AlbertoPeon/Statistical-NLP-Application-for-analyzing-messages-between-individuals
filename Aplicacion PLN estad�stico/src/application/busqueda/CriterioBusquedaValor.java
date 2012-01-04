package application.busqueda;

import java.util.List;

import application.model.*;

/**
 * Clase que hereda de Criterio Búsqueda. Utiliza un atributo Valor que utiliza
 * para comparar con los mensajes. Además, implementa métodos auxiliares para
 * comprobar etiquetas y grupos
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class CriterioBusquedaValor extends CriterioBusqueda {
	protected String valor;

	public CriterioBusquedaValor(String valor) {
		super();
		this.valor = valor;
	}

	/**
	 * 
	 * @param etiquetasMensaje
	 *            Lista de etiquetas a comprobar
	 * @return true si la lista contiene una etiqueta que contiene la palabra
	 *         valor, false en otro caso
	 */
	protected boolean contieneEtiquetas(List<Etiqueta> etiquetasMensaje) {
		for (Etiqueta e : etiquetasMensaje) {
			if (e.toString().contains(this.valor))
				return true;
		}
		return false;
	}

	/**
	 * 
	 * @param grupos
	 *            Lista de grupos a comprobar
	 * @return true si la lista contiene un grupo que contiene la palabra valor,
	 *         false en otro caso
	 */
	protected boolean contieneGrupos(List<Grupo> grupos) {
		for (Grupo g : grupos) {
			if (g.toString().contains(this.valor))
				return true;
		}
		return false;
	}
}
