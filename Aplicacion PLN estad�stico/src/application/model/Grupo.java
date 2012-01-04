package application.model;

/**
 * Clase que implementa los grupos a los que puede pertenecer un usuario. Su
 * único atributo es el nombre que además sirve para identificarlo únicamente
 * (no puede haber dos grupos con el mismo nombre)
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Grupo {
	private String nombre;

	public Grupo(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
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
		Grupo other = (Grupo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
