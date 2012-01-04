package application.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Individuo identifica tanto a los emisores como a los receptores de los
 * mensajes. Su único atributo es el nombre que permite identificarlos
 * únicamente. Además contiene una lista con los Grupos a los que pertenece
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Individuo {
	private String nombre;
	private List<Grupo> grupos;

	public Individuo(String nombre) {
		this.nombre = nombre;
		grupos = new LinkedList<Grupo>();
	}

	public Individuo(String nombre, List<Grupo> grupos, List<Etiqueta> etiquetas) {
		this.nombre = nombre;
		this.grupos = grupos;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individuo other = (Individuo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	/**
	 * Añade el grupo a la lista de grupos del usuario
	 * 
	 * @param grupo
	 *            grupo a añadir
	 */
	public void addGrupo(Grupo grupo) {
		if (this.grupos == null)
			this.grupos = new LinkedList<Grupo>();

		if (!this.grupos.contains(grupo))
			this.grupos.add(grupo);
	}

	/**
	 * Añade los grupos de la lista de grupos a la lista de grupos del usuario
	 * 
	 * @param grupos
	 *            grupos a añadir
	 */
	public void addGrupos(List<Grupo> grupos) {
		for (Grupo grupo : grupos) {
			addGrupo(grupo);
		}
	}

	/**
	 * Se comparan los grupos del usuario actual con los del usuario que se pasa
	 * como parámetro
	 * 
	 * @param individuo
	 *            usuario a comparar
	 * @return true si los grupos del mensaje actual están en la lista de gupros
	 *         del usuario
	 */
	public boolean tieneMismosGrupos(Individuo individuo) {
		return tieneMismosGrupos(individuo.getGrupos());
	}

	/**
	 * Se comparan los grupos del usuario actual con la lista de grupos que se
	 * pasa como parámetro
	 * 
	 * @param grupos
	 *            lista de grupos a comparar
	 * @return true si los grupos del mensaje actual están en la lista de gupros
	 *         del usuario
	 */
	public boolean tieneMismosGrupos(List<Grupo> grupos) {
		if (grupos.isEmpty() || this.grupos.isEmpty())
			return false;
		for (Grupo grupo : this.grupos) {
			if (!grupos.contains(grupo))
				return false;
		}
		return true;
	}

}
