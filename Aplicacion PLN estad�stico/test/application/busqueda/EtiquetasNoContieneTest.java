package application.busqueda;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import application.busqueda.CriterioBusqueda;
import application.busqueda.EtiquetasNoContiene;
import application.model.Etiqueta;
import application.model.Mensaje;
import application.model.Individuo;

/**
 * Pruebas unitarias de la clase {@link EtiquetasNoContiene}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EtiquetasNoContieneTest {
	private CriterioBusqueda cb;
	private List<Mensaje> mensajes;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cb = new EtiquetasNoContiene("1");
		mensajes = new LinkedList<Mensaje>();
		Mensaje m1 = new Mensaje(1, true, "prueba1", new Individuo("401"),
				new Individuo("9"), null);
		Mensaje m2 = new Mensaje(2, true, "prueba2", new Individuo("4101"),
				new Individuo("9"), null);
		m1.etiquetar(new Etiqueta("et1"));
		m1.etiquetar(new Etiqueta("et2"));
		m2.etiquetar(new Etiqueta("et2"));
		m2.etiquetar(new Etiqueta("et3"));
		mensajes.add(m1);
		mensajes.add(m2);
	}

	/**
	 * Test method for
	 * {@link EtiquetasNoContiene#seleccionarMensajes(java.util.List)}.
	 */
	@Test
	public void testCumpleCriterio() {
		List<Mensaje> resultado = cb.seleccionarMensajes(mensajes);
		assertEquals(resultado.size(), 1);
		assertEquals(resultado.get(0).getTexto(), "prueba2");
	}

}
