package br.com.montreal.ws.serviceTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ImagemServiceTest.class, ProdutoApiSuiteTest.class, ProdutoServiceTest.class })
public class AllTests {
	

}
