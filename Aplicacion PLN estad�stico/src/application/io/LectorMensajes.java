package application.io;

import java.util.Hashtable;
import java.util.List;
import application.main.Main;
import application.model.Etiqueta;
import application.model.Grupo;
import application.model.Mensaje;
import application.model.Patron;
import application.model.Individuo;

/**
 * Interfaz que ha de implementar la clase encargada de grabar y cargar los
 * mensajes de disco
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public interface LectorMensajes {
	/**
	 * Carga los mensajes desde un archivo de texto formateado en una forma
	 * determinada
	 * 
	 * @param path
	 *            ruta del archivo de texto
	 */
	public void cargarMensajesTexto(String path);

	/**
	 * Lee los mensajes de disco
	 * 
	 * @return Lista con todos los mensajes cargados
	 */
	public List<Mensaje> leerMensajes();

	/**
	 * Lee los usuarios de disco
	 * 
	 * @return Tabla hash con todos los usuarios cargados
	 */
	public Hashtable<String, Individuo> leerIndividuos();

	/**
	 * Lee las etiquetas de disco
	 * 
	 * @return Lista con todos los etiquetas cargados
	 */
	public List<Etiqueta> leerEtiquetas();

	/**
	 * Lee los grupos de disco
	 * 
	 * @return Lista con todos los usuarios cargados
	 */
	public List<Grupo> leerGrupos();

	/**
	 * Lee los patrones de disco
	 * 
	 * @return Lista con todos los patrones cargados
	 */
	public List<Patron> leerPatrones();

	/**
	 * Graba el estado actual de la aplicación a disco
	 * 
	 * @param m
	 *            Objeto que contiene las estructuras de datos donde se guarda
	 *            la información
	 */
	public void grabarTodo(Main m);

	/**
	 * Borra todos los datos de disco
	 */
	public void borrarTodo();

}
