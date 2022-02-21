package com.algaworks.algafood;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaIT {

	@LocalServerPort
	private int port;

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas(){
			//Habilita um log
			RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
			//RestAssured. <- pode ficar antes do given(), mas pode dar um import e usar sem.
			// ou usar como import estatico
			given()
				.basePath("/cozinhas")
				.port(port)
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveConter4Cozinhas_QuandoConsultarCozinhas(){
			RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

			given()
				.basePath("/cozinhas")
				.port(port)
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
					//Matchers.hasSize(4) -- import estatico
					.body("", hasSize(4))
					//Matchers.hasItems("Indiana", "Tailandesa")
					.body("nome", hasItems("Indiana", "Tailandesa"));
	}
}
