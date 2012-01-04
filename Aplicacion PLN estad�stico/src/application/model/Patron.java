package application.model;

import application.busqueda.*;

/**
 * Un patrón se utiliza para generar búsquedas personalizadas, siendo Campo el
 * campo del mensaje utilizado para la búsqueda, el Tipo es el tipo de búsqueda
 * y valor y valor2 los valores a comparar (para determinados tipos de búsqueda,
 * solo se utiliza valor y no valor2)
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Patron {
	private Campo campo;
	private Tipo tipo;
	private String valor;
	private String valor2;

	public Patron(Campo campo, Tipo tipo, String valor, String valor2) {
		super();
		this.campo = campo;
		this.tipo = tipo;
		this.valor = valor;
		if (valor2.equals("")) {
			this.valor2 = null;
		} else {
			this.valor2 = valor2;
		}
	}

	public Patron(Campo campo, Tipo tipo, String valor) {
		super();
		this.campo = campo;
		this.tipo = tipo;
		this.valor = valor;
		this.valor2 = null;
	}

	public Patron(String string) {
		String[] partes = string.split(" - ");
		this.campo = obtenerCampo(partes[0]);
		String[] nuevasPartes = partes[1].split(" : ");
		this.tipo = obtenerTipo(nuevasPartes[0]);
		String[] valores = nuevasPartes[1].split(" / ");
		this.valor = valores[0];
		this.valor2 = null;
		if (valores.length > 1)
			this.valor2 = valores[1];

	}

	public Patron(String campo, String tipo, String valor, String valor2) {
		this.campo = obtenerCampo(campo);
		this.tipo = obtenerTipo(tipo);
		this.valor = valor;
		if (valor2.equals("")) {
			this.valor2 = null;
		} else {
			this.valor2 = valor2;
		}
	}

	public Campo getCampo() {
		return campo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getValor() {
		return valor;
	}

	public String getValor2() {
		return valor2;
	}

	private Tipo obtenerTipo(String string) {
		if (Tipo.CONTIENE.toString().equals(string))
			return Tipo.CONTIENE;
		if (Tipo.NO_CONTIENE.toString().equals(string))
			return Tipo.NO_CONTIENE;
		if (Tipo.EMPIEZA_POR.toString().equals(string))
			return Tipo.EMPIEZA_POR;
		if (Tipo.TERMINA_POR.toString().equals(string))
			return Tipo.TERMINA_POR;
		if (Tipo.ANTERIOR.toString().equals(string))
			return Tipo.ANTERIOR;
		if (Tipo.POSTERIOR.toString().equals(string))
			return Tipo.POSTERIOR;
		if (Tipo.ENTRE.toString().equals(string))
			return Tipo.ENTRE;

		return null;
	}

	private Campo obtenerCampo(String string) {
		if (Campo.EMISOR.toString().equals(string))
			return Campo.EMISOR;
		if (Campo.DESTINATARIO.toString().equals(string))
			return Campo.DESTINATARIO;
		if (Campo.MENSAJE.toString().equals(string))
			return Campo.MENSAJE;
		if (Campo.GRUPOS.toString().equals(string))
			return Campo.GRUPOS;
		if (Campo.TIMESTAMP.toString().equals(string))
			return Campo.TIMESTAMP;
		if (Campo.ETIQUETAS.toString().equals(string))
			return Campo.ETIQUETAS;

		return null;
	}

	@Override
	public String toString() {
		String s = "";
		s += campo.toString() + " - ";
		s += tipo.toString() + " : ";
		s += valor;
		if (valor2 != null)
			s += " / " + valor2;
		return s;
	}

	/**
	 * A partir de los atributos del patrón, se obtiene el CriterioBusqueda
	 * correspondiente para realizar la búsqueda
	 * 
	 * @return el CriterioBusqueda que corresponde al patrón
	 */
	public CriterioBusqueda getCriterioBusqueda() {
		CriterioBusqueda cb = null;
		switch (campo) {
		case EMISOR:
			cb = emisorBusqueda();
			break;
		case DESTINATARIO:
			cb = destinatarioBusqueda();
			break;
		case GRUPOS:
			cb = grupoBusqueda();
			break;

		case TIMESTAMP:
			cb = timeStampBusqueda();
			break;
		case MENSAJE:
			cb = mensajeBusqueda();
			break;
		case ETIQUETAS:
			cb = etiquetasBusqueda();
			break;
		default:
			return null;
		}
		return cb;
	}

	private CriterioBusqueda etiquetasBusqueda() {
		switch (tipo) {
		case CONTIENE:
			return new EtiquetasContiene(valor);
		case NO_CONTIENE:
			return new EtiquetasNoContiene(valor);
		default:
			return null;
		}
	}

	private CriterioBusqueda mensajeBusqueda() {
		switch (tipo) {
		case CONTIENE:
			return new MensajeContiene(valor);
		case NO_CONTIENE:
			return new MensajeNoContiene(valor);
		case EMPIEZA_POR:
			return new MensajeEmpiezaPor(valor);
		case TERMINA_POR:
			return new MensajeTerminaPor(valor);
		default:
			return null;
		}
	}

	private CriterioBusqueda timeStampBusqueda() {
		switch (tipo) {
		case ANTERIOR:
			return new TimeStampAnterior(valor);
		case POSTERIOR:
			return new TimeStampPosterior(valor);
		case ENTRE:
			return new TimeStampEntre(valor, valor2);
		default:
			return null;
		}
	}

	private CriterioBusqueda destinatarioBusqueda() {
		switch (tipo) {
		case CONTIENE:
			return new DestinatarioContiene(valor);
		case NO_CONTIENE:
			return new DestinatarioNoContiene(valor);
		case EMPIEZA_POR:
			return new DestinatarioEmpiezaPor(valor);
		case TERMINA_POR:
			return new DestinatarioTerminaPor(valor);
		default:
			return null;
		}
	}

	private CriterioBusqueda grupoBusqueda() {
		switch (tipo) {
		case CONTIENE:
			return new GruposContiene(valor);
		case NO_CONTIENE:
			return new GruposNoContiene(valor);
		default:
			return null;
		}
	}

	private CriterioBusqueda emisorBusqueda() {
		switch (tipo) {
		case CONTIENE:
			return new EmisorContiene(valor);
		case NO_CONTIENE:
			return new EmisorNoContiene(valor);
		case EMPIEZA_POR:
			return new EmisorEmpiezaPor(valor);
		case TERMINA_POR:
			return new EmisorTerminaPor(valor);
		default:
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Patron other = (Patron) obj;
		if (campo == null) {
			if (other.campo != null)
				return false;
		} else if (!campo.equals(other.campo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
