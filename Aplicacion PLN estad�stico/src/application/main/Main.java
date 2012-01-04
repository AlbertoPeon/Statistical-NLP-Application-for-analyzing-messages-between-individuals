package application.main;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingUtilities;

import application.classifier.Clasificador;
import application.io.*;
import application.model.Etiqueta;
import application.model.Grupo;
import application.model.Mensaje;
import application.model.Patron;
import application.model.Individuo;
import application.util.TimeStamp;
import application.view.VentanaPrincipal;

/**
 * Clase que implementa las operaciones básicas que se ejecutan sobre el modelo.
 * Sirve de puente entre la interfaz de individuos y el modelo
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Main {
	private VentanaPrincipal interfaz;
	private LectorMensajes lector;
	private String path;
	/**
	 * Lista con todos los mensajes que hay cargados
	 */
	private List<Mensaje> todos;
	/**
	 * Lista con los mensajes que hay como resultado de la última búsqueda
	 * realizada
	 */
	private List<Mensaje> listaBusqueda;
	private Hashtable<String, Individuo> individuos;
	private List<Etiqueta> etiquetas;
	private List<Grupo> grupos;
	private List<Patron> patrones;
	private Clasificador clasificador;
	private static final String DEFAULT_PATH = "messages_all.txt";

	public Main(boolean comienzo) {
		if (comienzo) {
			path = DEFAULT_PATH;
			lector = new LectorMensajesBD911();
			crearNuevaInterfaz();
		}
	}

	/**
	 * Carga los mensajes desde el archivo de texto. La ruta la indica el
	 * atributo path
	 */
	public void cargarMensajes() {
		lector.cargarMensajesTexto(path);
	}

	/**
	 * Crea la interfaz de usuario
	 */
	public void crearNuevaInterfaz() {
		interfaz = new VentanaPrincipal(this);
		interfaz.setLocationRelativeTo(null);
		interfaz.setVisible(true);
		if (todos == null || todos.size() == 0)
			interfaz.cargarDatosInicio();
	}

	/**
	 * Cierra la interfaz de usuario actual
	 */
	private void terminarInterfaz() {
		if (!SwingUtilities.isEventDispatchThread()) {
			try {
				SwingUtilities.invokeAndWait(new Runnable() {

					@Override
					public void run() {
						interfaz.dispose();
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			interfaz.dispose();
		}
	}

	/**
	 * Reinicia la interfaz de usuario
	 */
	public void reiniciarInterfaz() {
		terminarInterfaz();
		crearNuevaInterfaz();
		getInterfaz().setListaBusqueda(listaBusqueda);
		getInterfaz().mostrarResultado();
	}

	/**
	 * Obtiene los mensajes cuyos índices están comprendidos entre min y
	 * min+numMensajses
	 * 
	 * @param min
	 *            número a partir del cual se cargan los mensajes
	 * @param numMensajes
	 *            nímero de mensajes a cargar
	 * @return Lista que contiene dichos mensajes
	 */
	public List<Mensaje> obtenerMensajes(int min, int numMensajes) {
		List<Mensaje> parcial = new LinkedList<Mensaje>();
		for (int i = min; i < min + numMensajes; i++) {
			parcial.add(this.todos.get(i));
		}
		return parcial;
	}

	/**
	 * A partir de la lista de búsqueda actual filtra los mensajes y devuelve
	 * aquellos que contienen la etiqueta que se pasa como parámetro
	 * 
	 * @param etiqueta
	 *            etiqueta que han de contener los mensajes
	 * @return lista con aquellos mensajes que contienen dicha etiqueta
	 */
	public List<Mensaje> obtenerMensajePorEtiqueta(Etiqueta etiqueta) {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		for (Mensaje m : this.listaBusqueda) {
			if (m.getEtiquetas().contains(etiqueta)) {
				resultado.add(m);
			}
		}
		return resultado;
	}

	/**
	 * A partir de la lista de búsqueda actual filtra los mensajes y devuelve
	 * aquellos cuyo Emisor pertenece al grupo que se pasa como parámetro
	 * 
	 * @param grupo
	 *            que ha de contener el Receptor de los mensajes
	 * @return lista con aquellos mensajes cuyo Receptor pertenece a dicha grupo
	 */
	public List<Mensaje> obtenerMensajePorGrupoEmisor(Grupo grupo) {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		for (Mensaje m : this.listaBusqueda) {
			if (m.getEmisor() != null
					&& m.getEmisor().getGrupos().contains(grupo)) {
				resultado.add(m);
			}
		}
		return resultado;
	}

	/**
	 * A partir de la lista de búsqueda actual filtra los mensajes y devuelve
	 * aquellos cuyo Receptor pertenece al grupo que se pasa como parámetro
	 * 
	 * @param grupo
	 *            que ha de contener el Receptor de los mensajes
	 * @return lista con aquellos mensajes cuyo Receptor pertenece a dicha grupo
	 */
	public List<Mensaje> obtenerMensajePorGrupoReceptor(Grupo grupo) {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		for (Mensaje m : this.listaBusqueda) {
			if (m.getReceptor() != null
					&& m.getReceptor().getGrupos().contains(grupo)) {
				resultado.add(m);
			}
		}
		return resultado;
	}

	/**
	 * Añade la etiqueta al mensaje
	 * 
	 * @param mensaje
	 *            mensaje a etiquetar
	 * @param etiqueta
	 *            etiqueta que se va a añadir al mensaje
	 */
	public void etiquetarMensaje(Mensaje mensaje, Etiqueta etiqueta) {
		addEtiquetaSuelta(etiqueta);
		mensaje.etiquetar(etiqueta);
	}

	/**
	 * Cambia la lista de etiqueta del mensaje por la que se pasa como parámetro
	 * 
	 * @param mensaje
	 *            mensaje cuya lista de etiquetas se va a cambiar
	 * @param etiquetas
	 *            nuevas etiquetas para el mensaje
	 */
	public void cambiarEtiquetasMensaje(Mensaje mensaje,
			List<Etiqueta> etiquetas) {
		mensaje.setEtiquetas(etiquetas);
	}

	/**
	 * A todos los mensajes de la lista mensajes se le añaden las etiquetas de
	 * la lista de etiquetas
	 * 
	 * @param mensajes
	 *            mensajes a etiquetar
	 * @param etiquetas
	 *            etiquetas que se van a añadir a los mensajes
	 */
	public void etiquetarMensajes(List<Mensaje> mensajes,
			List<Etiqueta> etiquetas) {
		for (Mensaje mensaje : mensajes) {
			for (Etiqueta etiqueta : etiquetas) {
				etiquetarMensaje(mensaje, etiqueta);
			}
		}
	}

	/**
	 * A todos los mensajes de la lista mensajes se le añaden la etiqueta que se
	 * pasa como parámetro
	 * 
	 * @param mensajes
	 *            mensajes a etiquetar
	 * @param etiqueta
	 *            etiqueta que se va a añadir a cada mensaje
	 */
	public void etiquetarMensajes(List<Mensaje> mensajes, Etiqueta etiqueta) {
		addEtiquetaSuelta(etiqueta);
		List<Etiqueta> etiquetas = new LinkedList<Etiqueta>();
		etiquetas.add(etiqueta);
		etiquetarMensajes(mensajes, etiquetas);
	}

	/**
	 * Añade la etiqueta que se pasa como parámetro a la lista de etiquetas ya
	 * existente
	 * 
	 * @param etiqueta
	 *            etiqueta a añadir
	 */
	public void addEtiquetaSuelta(Etiqueta etiqueta) {
		if (etiquetas == null)
			etiquetas = new LinkedList<Etiqueta>();
		if (!etiquetas.contains(etiqueta)) {
			etiquetas.add(etiqueta);
		}
	}

	/**
	 * Añade el grupo que se pasa como parámetro a la lista de grupos ya
	 * existente
	 * 
	 * @param grupo
	 *            grupo a añadir
	 */
	public void addGrupoSuelto(Grupo grupo) {
		if (grupos == null)
			grupos = new LinkedList<Grupo>();
		if (!grupos.contains(grupo)) {
			grupos.add(grupo);
		}

	}

	/**
	 * Al usuario que se pasa como parámetro se le modifican los grupos a los
	 * que pertenece por la nueva lista de grupos
	 * 
	 * @param individuo
	 *            usuario cuyos grupos van a cambiar
	 * @param grupos
	 *            nuevos grupos
	 */
	public void addGruposMismoIndividuo(Individuo individuo, List<Grupo> grupos) {
		for (Grupo grupo : grupos) {
			addGrupoSuelto(grupo);
		}
		individuo.setGrupos(grupos);
	}

	/**
	 * Al usuario que se pasa como parámetro se le añade el grupo indicado
	 * 
	 * @param individuo
	 *            usuario al que se le va a añadir el grupo
	 * @param grupo
	 *            grupo a añadir
	 */
	public void addGrupoMismoIndividuo(Individuo individuo, Grupo grupo) {
		addGrupoSuelto(grupo);
		individuo.addGrupo(grupo);
	}

	/**
	 * Todos los mensajes de listaMensajes se vuelven ocultos
	 * 
	 * @param listaMensajes
	 *            lista con los mensajes
	 */
	public void ocultarMensajes(List<Mensaje> listaMensajes) {
		for (Mensaje m : listaMensajes) {
			m.setVisible(false);
		}
	}

	/**
	 * Calcula los mensajes anteriores al TimeStamp dado
	 * 
	 * @param listMensajes
	 * @param timestamp
	 * @return lista con los mensajes que son anteriores
	 */
	public List<Mensaje> obtenerMensajesAnteriores(List<Mensaje> listMensajes,
			TimeStamp timestamp) {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		for (Mensaje m : listMensajes) {
			if (!m.getTimestamp().posteriorA(timestamp)) {
				resultado.add(m);
			}
		}
		return resultado;
	}

	/**
	 * Calcula los mensajes posteriores al TimeStamp dado
	 * 
	 * @param listaMensajes
	 * @param timestamp
	 * @return los mensajes que son posteriores
	 */
	public List<Mensaje> obtenerMensajesPosteriores(
			List<Mensaje> listaMensajes, TimeStamp timestamp) {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		for (Mensaje m : listaMensajes) {
			if (!m.getTimestamp().anteriorA(timestamp)) {
				resultado.add(m);
			}
		}
		return resultado;
	}

	/**
	 * A cada uno de los receptores de los mensajes que se pasan como
	 * parámetros, se indica que pertenecen a los grupos de la lista de grupo
	 * 
	 * @param list
	 *            lista de mensajes
	 * @param grupos
	 *            grupos a añadir a cada receptor
	 */
	public void addGrupoRecibeMensajes(List<Mensaje> list, List<Grupo> grupos) {
		for (Mensaje mensaje : list) {
			if (mensaje.getReceptor() != null) {
				individuos.get(mensaje.getReceptor().getNombre()).addGrupos(
						grupos);
			}
		}

	}

	/**
	 * A cada uno de los receptores de los mensajes que se pasan como
	 * parámetros, se indica que pertenecen al grupo
	 * 
	 * @param list
	 *            lista de mensajes
	 * @param grupo
	 *            grupo a añadir a cada receptor
	 */
	public void addGrupoRecibeMensajes(List<Mensaje> list, Grupo grupo) {
		for (Mensaje mensaje : list) {
			if (mensaje.getReceptor() != null) {
				individuos.get(mensaje.getReceptor().getNombre()).addGrupo(
						grupo);
			}
		}
	}

	/**
	 * Graba el estado actual en disco
	 */
	public void grabarTodo() {
		lector.grabarTodo(this);
	}

	/**
	 * Borra los datos actuales de disco y de la aplicación
	 */
	public void borrarTodo() {
		todos = new LinkedList<Mensaje>();
		listaBusqueda = new LinkedList<Mensaje>();
		individuos = new Hashtable<String, Individuo>();
		etiquetas = new LinkedList<Etiqueta>();
		grupos = new LinkedList<Grupo>();
		patrones = new LinkedList<Patron>();
		clasificador = null;
		lector.borrarTodo();

	}

	public Individuo getIndividuo(String string) throws Exception {
		Individuo u = individuos.get(string);
		if (u == null)
			throw new Exception("Individuo no existe");
		return u;
	}

	public Object[] getCategoriasFiltro() {
		if (this.clasificador == null)
			return new String[0];
		return this.clasificador.getCategorias().toArray();
	}

	public Etiqueta getEtiqueta(int selectedIndex) {
		return etiquetas.get(selectedIndex);
	}

	public Grupo getGrupo(int selectedIndex) {
		return grupos.get(selectedIndex);
	}

	public List<Patron> getPatrones() {
		return patrones;
	}

	public void setPatrones(List<Patron> patrones) {
		this.patrones = patrones;
	}

	public VentanaPrincipal getInterfaz() {
		return interfaz;
	}

	public List<Mensaje> getMensajes() {
		return todos;
	}

	public void setMensajes(List<Mensaje> todos) {
		this.todos = todos;
	}

	public Hashtable<String, Individuo> getIndividuos() {
		return individuos;
	}

	public void setIndividuos(Hashtable<String, Individuo> individuos) {
		this.individuos = individuos;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public LectorMensajes getLector() {
		return lector;
	}

	public List<Mensaje> getListaBusqueda() {
		return listaBusqueda;
	}

	public void setListaBusqueda(List<Mensaje> listaBusqueda) {
		this.listaBusqueda = listaBusqueda;
	}

	public Clasificador getClasificador() {
		return this.clasificador;
	}

	public void setClasificador(Clasificador clasificador) {
		this.clasificador = clasificador;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) {
		new Main(true);
	}

}
