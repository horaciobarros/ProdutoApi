package br.com.montreal.ws.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.montreal.ws.controller.StartApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = StartApplication.class)
public class ProdutoApiTests {
	
	@Test
	public void contextLoads() {
		
	}

}
