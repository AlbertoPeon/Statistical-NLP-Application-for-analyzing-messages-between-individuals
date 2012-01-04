package application.model;

import java.util.LinkedList;
import java.util.List;

import application.util.TimeStamp;

/**
 * Un mensaje está formado por su visibilidad, dos usuarios (uno el que envía el
 * mensaje y otro el que lo recibe), el texto del mensaje y la hora a la que fue
 * mandado. Además, un mensaje puede contener de una a muchas etiquetas. El id
 * los identifica de forma única
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Mensaje {
	private int id;
	private boolean visible;
	private String texto;
	private Individuo emisor;
	private Individuo receptor;
	private TimeStamp timestamp;
	private List<Etiqueta> etiquetas;
	private Simhash simhash;

	public Mensaje(int id, boolean visible, String texto, Individuo emisor,
			Individuo receptor, TimeStamp timestamp, List<Etiqueta> etiquetas,
			List<Grupo> gruposEmisor, List<Grupo> gruposReceptor) {
		this.id = id;
		this.visible = visible;
		this.texto = texto;
		this.emisor = emisor;
		this.receptor = receptor;
		this.timestamp = timestamp;
		this.etiquetas = etiquetas;
		this.simhash = null;
	}

	public Mensaje(int id, boolean visible, String texto, Individuo receptor,
			TimeStamp timestamp) {
		super();
		this.id = id;
		this.visible = visible;
		this.texto = texto;
		this.emisor = null;
		this.receptor = receptor;
		this.timestamp = timestamp;
		this.etiquetas = new LinkedList<Etiqueta>();
		this.simhash = null;
	}

	public Mensaje(int id, boolean visible, String texto, Individuo emisor,
			Individuo receptor, TimeStamp timestamp) {
		super();
		this.id = id;
		this.visible = visible;
		this.texto = texto;
		this.emisor = emisor;
		this.receptor = receptor;
		this.timestamp = timestamp;
		this.etiquetas = new LinkedList<Etiqueta>();
		this.simhash = null;
	}

	public Mensaje(int id, boolean visible, String texto, Individuo emisor,
			Individuo receptor, TimeStamp timestamp, List<Etiqueta> etiquetas,
			List<Grupo> gruposEmisor, List<Grupo> gruposReceptor,
			Simhash simhash) {
		this.id = id;
		this.visible = visible;
		this.texto = texto;
		this.emisor = emisor;
		this.receptor = receptor;
		this.timestamp = timestamp;
		this.etiquetas = etiquetas;
		this.simhash = simhash;
	}

	public Individuo getEmisor() {
		return emisor;
	}

	public Individuo getReceptor() {
		return receptor;
	}

	public TimeStamp getTimestamp() {
		return timestamp;
	}

	public String getTexto() {
		return texto;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public int getId() {
		return id;
	}

	public Simhash getSimhash() {
		return simhash;
	}

	public void setSimhash(Simhash simhash) {
		this.simhash = simhash;
	}

	@Override
	public String toString() {
		String s = "Emisor: " + this.emisor + "\n" + "Receptor: "
				+ this.receptor + "\n" + "Timestamp: " + this.timestamp + "\n"
				+ "Texto: " + this.texto + "\n";
		return s;
	}

	/**
	 * Transforma el Mensaje en array de Objects
	 * 
	 * @param mostrarGrupos
	 *            si es true, el array contiene información sobre los grupos de
	 *            los usuarios.
	 * @return el array de Object ya creado
	 */
	public Object[] getRow(boolean mostrarGrupos) {
		Object[] msg;
		if (mostrarGrupos) {
			msg = new Object[8];
		} else {
			msg = new Object[6];
		}
		msg[0] = this.visible;
		msg[1] = this.emisor;
		if (mostrarGrupos) {
			if (this.emisor == null) {
				msg[2] = "";
			} else {
				msg[2] = listToString(this.emisor.getGrupos());
			}
			msg[3] = this.receptor;
			if (this.receptor == null) {
				msg[4] = "";
			} else {
				msg[4] = listToString(this.receptor.getGrupos());
			}
			msg[5] = this.timestamp;
			msg[6] = this.texto;
			msg[7] = listToString(this.etiquetas);
		} else {
			msg[2] = this.receptor;
			msg[3] = this.timestamp;
			msg[4] = this.texto;
			msg[5] = listToString(this.etiquetas);
		}
		return msg;
	}

	private String listToString(List<?> list) {
		String s = "";
		for (int i = 0; i < list.size(); i++) {
			s += list.get(i).toString();
			if (i + 1 != list.size()) {
				s += ", ";
			}
		}
		return s;
	}

	/**
	 * Añadea al mensaje la etiqueta
	 * 
	 * @param etiqueta
	 */
	public void etiquetar(Etiqueta etiqueta) {
		if (!this.etiquetas.contains(etiqueta))
			this.etiquetas.add(etiqueta);
	}

	/**
	 * Se comparan las etiquetas del mensaje actual con las del mensaje que se
	 * pasa como parámetro
	 * 
	 * @param mensaje
	 *            mensaje a comparar
	 * @return true si todas las etiquetas del mensaje actual se encuentran en
	 *         el mensaje que se pasa como parámetro, false en caso contrario
	 */
	public boolean tieneMismasTags(Mensaje mensaje) {
		if (mensaje.getEtiquetas().isEmpty() || this.etiquetas.isEmpty())
			return false;
		for (Etiqueta e : this.getEtiquetas()) {
			if (!mensaje.getEtiquetas().contains(e))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Mensaje other = (Mensaje) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
