package application.busqueda;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import application.busqueda.CriterioBusqueda;
import application.busqueda.EmisorContiene;
import application.model.Mensaje;
import application.model.Individuo;

/**
 * Pruebas unitarias de la clase {@link EmisorContiene}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EmisorContieneTest {
	private CriterioBusqueda cb;
	private List<Mensaje> mensajes;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cb = new EmisorContiene("101");
		mensajes = new LinkedList<Mensaje>();
		Mensaje m1 = new Mensaje(1, true, "prueba1", new Individuo("401"),
				new Individuo("9"), null);
		Mensaje m2 = new Mensaje(2, true, "prueba2", new Individuo("4101"),
				new Individuo("9"), null);
		mensajes.add(m1);
		mensajes.add(m2);
	}

	/**
	 * Test method for
	 * {@link application.busqueda.EmisorContiene#seleccionarMensajes(java.util.List)}.
	 */
	@Test
	public void testCumpleCriterio() {
		List<Mensaje> resultado = cb.seleccionarMensajes(mensajes);
		assertEquals(resultado.size(), 1);
		assertEquals(resultado.get(0).getEmisor(), new Individuo("4101"));
	}

}
