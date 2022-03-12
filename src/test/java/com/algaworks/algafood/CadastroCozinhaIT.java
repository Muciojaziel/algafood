package com.algaworks.algafood;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;
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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaIT {

	public static final int COZINHA_ID_INEXISTENTE = 100;

	@LocalServerPort
	private int port;

	@Autowired
	private DatabaseCleaner databaseCleaner;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	private Cozinha cozinhaAmericana;
	private int quantidadeCozinhasCadastradas;
	private String jsonCorretoCozinhaChinesa;

	@BeforeEach
	public void setUp(){
		//Habilita um log
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";

		databaseCleaner.clearTables();
		prepararDados();

		jsonCorretoCozinhaChinesa = ResourceUtils.getContentFromResource("/json/correto/cozinha-chinesa.json");
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
	public void deveRetornarQuantidadeCorretaDeCozinhas_QuandoConsultarCozinhas(){
			given()
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				//Matchers.hasSize(2) -- import estatico
				.body("", hasSize(quantidadeCozinhasCadastradas));
				//Matchers.hasItems("Indiana", "Tailandesa")
				//.body("nome", hasItems("Indiana", "Tailandesa"));
	}

	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaExistente(){
			given()
				.pathParam("cozinhaId", cozinhaAmericana.getId())
				.accept(ContentType.JSON)
			.when()
				.get("/{cozinhaId}")
			.then()
				.statusCode(HttpStatus.OK.value())
				.body("nome", equalTo(cozinhaAmericana.getNome()));
	}

	@Test
	public void deveRetornarStatus404_QuandoConsultarCozinhaInexistente(){
			given()
				.pathParam("cozinhaId", COZINHA_ID_INEXISTENTE)
				.accept(ContentType.JSON)
			.when()
				.get("/{cozinhaId}")
			.then()
				.statusCode(HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void deveRetornar201_QuandoCadastrarCozinha(){
		given()
				.body(jsonCorretoCozinhaChinesa)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		.when()
				.post()
		.then()
				.statusCode(HttpStatus.CREATED.value());
	}

	private void prepararDados(){
		Cozinha cozinhaTailandesa = new Cozinha();
		cozinhaTailandesa.setNome("Tailandesa");
		cozinhaRepository.save(cozinhaTailandesa);

		cozinhaAmericana = new Cozinha();
		cozinhaAmericana.setNome("Americana");
		cozinhaRepository.save(cozinhaAmericana);

		quantidadeCozinhasCadastradas = (int) cozinhaRepository.count();
	}
}