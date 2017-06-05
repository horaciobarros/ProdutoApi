1) Compilar:

mvn package --> vai compilar, executar todos os testes e empacotar a aplicação


2) Exemplos de chamadas á API via código java:

String BASE_PATH = "http://localhost:8080/";

org.springframework.web.client.RestTemplate restTemplate;

// inclusão de produto:
Produto produto = new Produto();
produto.setDescricao("Café Três Corações");
produto.setNome("Café");
Produto response = restTemplate.postForObject(BASE_PATH + "create", produto, Produto.class);
assertThat(response.getId() != null);

// consultando o produto incluido:
Produto response = restTemplate.getForObject(BASE_PATH + "produto?id=" + produto.getId(), Produto.class);
assertThat(response.getId() != null);

3) Executando na linha de comando:

java -jar produtoapi-0.0.1-SNAPSHOT.jar
