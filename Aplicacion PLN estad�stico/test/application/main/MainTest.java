/**
 * 
 */
package application.main;

import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import application.main.Main;
import application.model.Etiqueta;
import application.model.Grupo;
import application.model.Mensaje;
import application.model.Individuo;

/**
 * 
 * Pruebas unitarias sobre la clase Main
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MainTest {
	private Mensaje mensaje1;
	private Mensaje mensaje2;
	private List<Mensaje> mensajes;
	private Etiqueta etiqueta1;
	private Etiqueta etiqueta2;
	private List<Etiqueta> etiquetas;
	private Grupo grupo1;
	private Grupo grupo2;
	private List<Grupo> grupos;
	private Individuo individuo1;
	private Individuo individuo2;
	private Main main;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		main = new Main(false);
		individuo1 = new Individuo("9");
		individuo2 = new Individuo("91");
		mensaje1 = new Mensaje(1, true, "prueba1", new Individuo("401"),
				individuo1, null);
		mensaje2 = new Mensaje(2, true, "prueba2", new Individuo("4101"),
				individuo2, null);
		etiqueta1 = new Etiqueta("etiqueta1");
		etiqueta2 = new Etiqueta("etiqueta2");
		grupo1 = new Grupo("grupo1");
		grupo2 = new Grupo("grupo2");
		etiquetas = new LinkedList<Etiqueta>();
		mensajes = new LinkedList<Mensaje>();
		grupos = new LinkedList<Grupo>();
	}

	/**
	 * Test method for
	 * {@link application.main.Main#etiquetarMensaje(application.model.Mensaje, application.model.Etiqueta)}
	 * .
	 */
	@Test
	public final void testEtiquetarMensaje() {
		main.etiquetarMensaje(mensaje1, etiqueta1);
		assertEquals(mensaje1.getEtiquetas().size(), 1);
		assertEquals(mensaje1.getEtiquetas().get(0), etiqueta1);
		assertEquals(main.getEtiquetas().size(), 1);
		assertEquals(main.getEtiqueta(0), etiqueta1);
	}

	/**
	 * Test method for
	 * {@link application.main.Main#etiquetarMensajes(java.util.List, java.util.List)}
	 * .
	 */
	@Test
	public final void testEtiquetarMensajesListOfMensajeListOfEtiqueta() {
		mensajes.add(mensaje1);
		mensajes.add(mensaje2);
		etiquetas.add(etiqueta1);
		etiquetas.add(etiqueta2);
		main.etiquetarMensajes(mensajes, etiquetas);
		assertEquals(mensajes.get(0).getEtiquetas().size(), 2);
		assertEquals(mensajes.get(0).getEtiquetas().get(0), etiqueta1);
		assertEquals(mensajes.get(0).getEtiquetas().get(1), etiqueta2);
		assertEquals(mensajes.get(1).getEtiquetas().size(), 2);
		assertEquals(mensajes.get(1).getEtiquetas().get(0), etiqueta1);
		assertEquals(mensajes.get(1).getEtiquetas().get(1), etiqueta2);
		assertEquals(main.getEtiquetas().size(), 2);
		assertEquals(main.getEtiqueta(0), etiqueta1);
		assertEquals(main.getEtiqueta(1), etiqueta2);
	}

	/**
	 * Test method for
	 * {@link application.main.Main#etiquetarMensajes(java.util.List, application.model.Etiqueta)}
	 * .
	 */
	@Test
	public final void testEtiquetarMensajesListOfMensajeEtiqueta() {
		mensajes.add(mensaje1);
		mensajes.add(mensaje2);
		main.etiquetarMensajes(mensajes, etiqueta1);
		assertEquals(mensajes.get(0).getEtiquetas().size(), 1);
		assertEquals(mensajes.get(0).getEtiquetas().get(0), etiqueta1);
		assertEquals(mensajes.get(1).getEtiquetas().size(), 1);
		assertEquals(mensajes.get(1).getEtiquetas().get(0), etiqueta1);
		assertEquals(main.getEtiquetas().size(), 1);
		assertEquals(main.getEtiqueta(0), etiqueta1);
	}

	/**
	 * Test method for
	 * {@link application.main.Main#addEtiquetaSuelta(application.model.Etiqueta)}
	 * .
	 */
	@Test
	public final void testAddEtiquetaSuelta() {
		main.addEtiquetaSuelta(etiqueta1);
		assertEquals(main.getEtiquetas().size(), 1);
		assertEquals(main.getEtiquetas().get(0), etiqueta1);
		assertEquals(main.getEtiquetas().get(0), main.getEtiqueta(0));
		main.addEtiquetaSuelta(etiqueta2);
		assertEquals(main.getEtiquetas().size(), 2);
		assertEquals(main.getEtiquetas().get(1), etiqueta2);
		assertEquals(main.getEtiquetas().get(1), main.getEtiqueta(1));
	}

	/**
	 * Test method for
	 * {@link application.main.Main#addGrupoSuelto(application.model.Grupo)}.
	 */
	@Test
	public final void testAddGrupoSuelto() {
		main.addGrupoSuelto(grupo1);
		assertEquals(main.getGrupos().size(), 1);
		assertEquals(main.getGrupos().get(0), grupo1);
		assertEquals(main.getGrupos().get(0), main.getGrupo(0));
		main.addGrupoSuelto(grupo2);
		assertEquals(main.getGrupos().size(), 2);
		assertEquals(main.getGrupos().get(1), grupo2);
		assertEquals(main.getGrupos().get(1), main.getGrupo(1));
	}

	/**
	 * Test method for
	 * {@link application.main.Main#addGruposMismoIndividuo(application.model.Individuo, java.util.List)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testAddGruposMismoIndividuo() throws Exception {
		Hashtable<String, Individuo> individuos = new Hashtable<String, Individuo>();
		individuos.put(individuo1.getNombre(), individuo1);
		individuos.put(individuo2.getNombre(), individuo2);
		main.setIndividuos(individuos);
		grupos.add(grupo1);
		grupos.add(grupo2);
		main.addGruposMismoIndividuo(individuo1, grupos);
		main.addGruposMismoIndividuo(individuo2, grupos);
		assertEquals(main.getIndividuos().size(), 2);
		assertEquals(main.getIndividuos().get(individuo1.getNombre()),
				individuo1);
		assertEquals(main.getIndividuos().get(individuo1.getNombre()),
				main.getIndividuo(individuo1.getNombre()));
		assertEquals(main.getIndividuo(individuo1.getNombre()).getGrupos(),
				grupos);
		assertEquals(main.getIndividuos().get(individuo2.getNombre()),
				individuo2);
		assertEquals(main.getIndividuos().get(individuo2.getNombre()),
				main.getIndividuo(individuo2.getNombre()));
		assertEquals(main.getIndividuo(individuo2.getNombre()).getGrupos(),
				grupos);
	}

	/**
	 * Test method for
	 * {@link application.main.Main#addGrupoMismoIndividuo(application.model.Individuo, application.model.Grupo)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testAddGrupoMismoIndividuo() throws Exception {
		Hashtable<String, Individuo> table = new Hashtable<String, Individuo>();
		table.put(individuo1.getNombre(), individuo1);
		main.setIndividuos(table);
		main.addGrupoMismoIndividuo(individuo1, grupo1);
		main.addGrupoMismoIndividuo(individuo1, grupo2);
		assertEquals(main.getGrupos().size(), 2);
		grupos.add(grupo1);
		grupos.add(grupo2);
		assertEquals(main.getIndividuo(individuo1.getNombre()).getGrupos(),
				grupos);

	}

	/**
	 * Test method for
	 * {@link application.main.Main#ocultarMensajes(java.util.List)}.
	 */
	@Test
	public final void testOcultarMensajes() {
		mensajes.add(mensaje1);
		mensajes.add(mensaje2);
		assertEquals(mensaje1.isVisible(), true);
		assertEquals(mensaje2.isVisible(), true);
		main.ocultarMensajes(mensajes);
		assertEquals(mensaje1.isVisible(), false);
		assertEquals(mensaje2.isVisible(), false);
	}

	/**
	 * Test method for
	 * {@link application.main.Main#addGrupoRecibeMensajes(java.util.List, java.util.List)}
	 * .
	 */
	@Test
	public final void testAddGrupoRecibeMensajesListOfMensajeListOfGrupo() {
		mensajes.add(mensaje1);
		mensajes.add(mensaje2);
		grupos.add(grupo1);
		grupos.add(grupo2);
		Hashtable<String, Individuo> individuos = new Hashtable<String, Individuo>();
		individuos.put(individuo1.getNombre(), individuo1);
		individuos.put(individuo2.getNombre(), individuo2);
		main.setIndividuos(individuos);
		assertEquals(individuos.size(), 2);
		main.addGrupoRecibeMensajes(mensajes, grupos);
		assertEquals(mensaje1.getReceptor().getGrupos(), grupos);
		assertEquals(mensaje2.getReceptor().getGrupos(), grupos);
	}

	/**
	 * Test method for
	 * {@link application.main.Main#addGrupoRecibeMensajes(java.util.List, application.model.Grupo)}
	 * .
	 */
	@Test
	public final void testAddGrupoRecibeMensajesListOfMensajeGrupo() {
		mensajes.add(mensaje1);
		mensajes.add(mensaje2);
		grupos.add(grupo1);
		grupos.add(grupo2);
		Hashtable<String, Individuo> individuos = new Hashtable<String, Individuo>();
		individuos.put(individuo1.getNombre(), individuo1);
		individuos.put(individuo2.getNombre(), individuo2);
		main.setIndividuos(individuos);
		assertEquals(individuos.size(), 2);
		main.addGrupoRecibeMensajes(mensajes, grupo1);
		assertEquals(mensaje1.getReceptor().getGrupos().size(), 1);
		assertEquals(mensaje2.getReceptor().getGrupos().size(), 1);
		assertEquals(mensaje1.getReceptor().getGrupos().get(0), grupo1);
		assertEquals(mensaje2.getReceptor().getGrupos().get(0), grupo1);
		main.addGrupoRecibeMensajes(mensajes, grupo2);
		assertEquals(mensaje1.getReceptor().getGrupos().size(), 2);
		assertEquals(mensaje2.getReceptor().getGrupos().size(), 2);
		assertEquals(mensaje1.getReceptor().getGrupos().get(1), grupo2);
		assertEquals(mensaje2.getReceptor().getGrupos().get(1), grupo2);
	}

}
