/**
 * 
 */
package application.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alberto Rodríguez Peón
 * 
 */
public class MensajeTest {
	private Mensaje mensaje1;
	private Mensaje mensaje2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mensaje1 = new Mensaje(2, true, "prueba2", new Individuo("4101"),
				new Individuo("9"), null);
		mensaje2 = new Mensaje(1, true, "prueba2a", new Individuo("41101"),
				new Individuo("9"), null);

	}

	/**
	 * Test method for
	 * {@link application.model.Mensaje#etiquetar(application.model.Etiqueta)}.
	 */
	@Test
	public final void testEtiquetar() {
		mensaje1.etiquetar(new Etiqueta("et1"));
		assertEquals(mensaje1.getEtiquetas().size(), 1);
		assertEquals(mensaje1.getEtiquetas().get(0), new Etiqueta("et1"));
		mensaje1.etiquetar(new Etiqueta("et1"));
		assertEquals(mensaje1.getEtiquetas().size(), 1);
		assertEquals(mensaje1.getEtiquetas().get(0), new Etiqueta("et1"));

	}

	/**
	 * Test method for
	 * {@link application.model.Mensaje#tieneMismasTags(application.model.Mensaje)}
	 * .
	 */
	@Test
	public final void testTieneMismasTags() {
		mensaje1.etiquetar(new Etiqueta("e1"));
		mensaje1.etiquetar(new Etiqueta("e2"));
		assertEquals(mensaje1.tieneMismasTags(mensaje2), false);
		mensaje2.etiquetar(new Etiqueta("e1"));
		assertEquals(mensaje1.tieneMismasTags(mensaje2), false);
		mensaje2.etiquetar(new Etiqueta("e2"));
		assertEquals(mensaje1.tieneMismasTags(mensaje2), true);
		mensaje2.etiquetar(new Etiqueta("e3"));
		assertEquals(mensaje1.tieneMismasTags(mensaje2), true);

	}

}
