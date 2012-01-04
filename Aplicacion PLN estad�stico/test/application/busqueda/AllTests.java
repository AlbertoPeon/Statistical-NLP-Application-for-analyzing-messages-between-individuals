package application.busqueda;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({DestinatarioContieneTest.class, DestinatarioNoContieneTest.class, 
	DestinatarioEmpiezaPorTest.class, DestinatarioTerminaPorTest.class,
	EmisorContieneTest.class, EmisorNoContieneTest.class, EmisorEmpiezaPorTest.class,
	EmisorTerminaPorTest.class, MensajeContieneTest.class,MensajeNoContieneTest.class,
	MensajeEmpiezaPorTest.class, MensajeTerminaPorTest.class, EtiquetasContieneTest.class,
	EtiquetasNoContieneTest.class, GruposContieneTest.class, GruposNoContieneTest.class,
	TimeStampAnteriorTest.class, TimeStampPosteriorTest.class, TimeStampEntreTest.class})
public class AllTests {

}
