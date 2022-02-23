package com.algaworks.algafood;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaIT {

	@LocalServerPort
	private int port;

	@Autowired
	private DatabaseCleaner databaseCleaner;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@BeforeEach
	public void setUp(){
		//Habilita um log
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		//
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";

		databaseCleaner.clearTables();
		prepararDados();
	}

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas(){
			given()
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveConter2Cozinhas_QuandoConsultarCozinhas(){
			given()
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				//Matchers.hasSize(2) -- import estatico
				.body("", hasSize(2));
				//Matchers.hasItems("Indiana", "Tailandesa")
				//.body("nome", hasItems("Indiana", "Tailandesa"));
	}

	@Test
	public void deveRetornar201_QuandoCadastrarCozinha(){
		given()
				.body("{\"nome\": \"Chinesa\"}")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		.when()
				.post()
		.then()
				.statusCode(HttpStatus.CREATED.value());
	}

	private void prepararDados(){
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Americana");
		cozinhaRepository.save(cozinha2);
	}
}
