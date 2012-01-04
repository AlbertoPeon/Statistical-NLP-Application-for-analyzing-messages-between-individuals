package application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ application.main.AllTests.class,
		application.busqueda.AllTests.class, application.model.AllTests.class })
public class AllTests {

}
