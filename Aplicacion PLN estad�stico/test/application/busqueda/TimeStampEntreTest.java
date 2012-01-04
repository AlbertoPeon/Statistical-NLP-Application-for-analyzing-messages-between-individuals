package application.busqueda;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import application.busqueda.CriterioBusqueda;
import application.busqueda.TimeStampEntre;
import application.model.Mensaje;
import application.model.Individuo;
import application.util.TimeStamp;


/**
 * Pruebas unitarias de la clase {@link TimeStampEntre}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class TimeStampEntreTest {
	private CriterioBusqueda cb;
	private List<Mensaje> mensajes;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cb = new TimeStampEntre("2001-09-11 14:12:11", "2001-09-11 14:13:11");
		mensajes = new LinkedList<Mensaje>();
		Mensaje m1 = new Mensaje(1, true, "prueba1", null, new Individuo("401"),
				new TimeStamp("2001-09-11 14:13:12"));
		Mensaje m2 = new Mensaje(2, true, "prueba2", null, new Individuo("4101"),
				new TimeStamp("2001-09-11 14:12:12"));
		mensajes.add(m1);
		mensajes.add(m2);
	}

	/**
	 * Test method for
	 * {@link TimeStampEntre#seleccionarMensajes(java.util.List)}.
	 */
	@Test
	public void testSeleccionarMensajes() {
		List<Mensaje> resultado = cb.seleccionarMensajes(mensajes);
		assertEquals(resultado.size(), 1);
		assertEquals(resultado.get(0).getTexto(), "prueba2");
	}

}
