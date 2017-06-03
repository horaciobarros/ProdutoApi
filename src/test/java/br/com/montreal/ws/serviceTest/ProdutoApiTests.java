package br.com.montreal.ws.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.montreal.ws.controller.StartApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StartApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProdutoApiTests {
	
	final String BASE_PATH = "http://localhost:8080/";
	
	@Test
	public void contextLoads() {
		
	}

}
