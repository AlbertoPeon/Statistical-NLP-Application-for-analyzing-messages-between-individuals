package application.model;

/**
 * Clase que implementa las etiquetas que se pueden añadir a los mensajes. Su
 * único atributo es el nombre que además sirve para identificarlos de forma
 * única (no puede haber dos etiquetas con el mismo nombre)
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Etiqueta {
	private String nombre;

	public Etiqueta(String nombre) {
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
		Etiqueta other = (Etiqueta) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
