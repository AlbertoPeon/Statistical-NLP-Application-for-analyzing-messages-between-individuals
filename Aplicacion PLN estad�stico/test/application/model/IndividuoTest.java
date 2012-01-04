/**
 * 
 */
package application.model;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alberto Rodríguez Peón
 * 
 */
public class IndividuoTest {
	private Individuo individuo1;
	private Individuo individuo2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		individuo1 = new Individuo("individuo1");
		individuo2 = new Individuo("individuo2");
	}

	/**
	 * Test method for
	 * {@link application.model.Individuo#addGrupo(application.model.Grupo)}.
	 */
	@Test
	public final void testAddGrupo() {
		individuo1.addGrupo(new Grupo("g1"));
		assertEquals(individuo1.getGrupos().size(), 1);
		assertEquals(individuo1.getGrupos().get(0), new Grupo("g1"));
		individuo1.addGrupo(new Grupo("g1"));
		assertEquals(individuo1.getGrupos().size(), 1);
		assertEquals(individuo1.getGrupos().get(0), new Grupo("g1"));
	}

	/**
	 * Test method for
	 * {@link application.model.Individuo#addGrupos(java.util.List)}.
	 */
	@Test
	public final void testAddGrupos() {
		List<Grupo> grupos = new LinkedList<Grupo>();
		grupos.add(new Grupo("g1"));
		grupos.add(new Grupo("g2"));
		individuo1.addGrupos(grupos);
		assertEquals(individuo1.getGrupos().size(), 2);
		assertEquals(individuo1.getGrupos().get(0), new Grupo("g1"));
		assertEquals(individuo1.getGrupos().get(1), new Grupo("g2"));
		individuo1.addGrupos(grupos);
		assertEquals(individuo1.getGrupos().size(), 2);
		assertEquals(individuo1.getGrupos().get(0), new Grupo("g1"));
		assertEquals(individuo1.getGrupos().get(1), new Grupo("g2"));
	}

	/**
	 * Test method for
	 * {@link application.model.Individuo#tieneMismosGrupos(java.util.List)}.
	 */
	@Test
	public final void testTieneMismosGrupos() {
		individuo1.addGrupo(new Grupo("grupo1"));
		individuo1.addGrupo(new Grupo("grupo2"));
		List<Grupo> grupos = new LinkedList<Grupo>();
		grupos.add(new Grupo("grupo1"));
		assertEquals(false, individuo1.tieneMismosGrupos(grupos));
		grupos.add(new Grupo("grupo2"));
		assertEquals(true, individuo1.tieneMismosGrupos(grupos));
		grupos.add(new Grupo("grupo3"));
		assertEquals(true, individuo1.tieneMismosGrupos(grupos));
	}

	/**
	 * Test method for
	 * {@link application.model.Individuo#tieneMismosGrupos(application.model.Individuo)}.
	 */
	@Test
	public final void testTieneMismosGruposIndividuo() {
		individuo1.addGrupo(new Grupo("grupo1"));
		individuo1.addGrupo(new Grupo("grupo2"));
		assertEquals(false, individuo2.tieneMismosGrupos(individuo1));
		individuo2.addGrupo(new Grupo("grupo1"));
		assertEquals(false, individuo1.tieneMismosGrupos(individuo2));
		individuo2.addGrupo(new Grupo("grupo2"));
		assertEquals(true, individuo1.tieneMismosGrupos(individuo2));
		individuo2.addGrupo(new Grupo("grupo3"));
		assertEquals(true, individuo1.tieneMismosGrupos(individuo2));

	}
}
