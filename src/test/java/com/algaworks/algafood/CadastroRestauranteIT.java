package com.algaworks.algafood;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
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

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroRestauranteIT {

    public static final int RESTAURANTE_ID_INEXISTENTE = 100;
    public static final String VIOLACAO_REGRA_DE_NEGOCIO_PROBLEM_TYPE = "Violação de regra de negócio";

    @LocalServerPort
    private int port;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    private String jsonCorretoRestauranteTeste;

    private String jsonRestauranteComCozinhaInexistente;

    private int qntRestaurantesCadastrados;

    private Restaurante restaurante;

    private Cozinha cozinhaAmericana;

    @BeforeEach
    public void setUp(){
        //Habilita um log
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.port = port;
        RestAssured.basePath = "/restaurantes";

        databaseCleaner.clearTables();
        prepararDados();

        jsonCorretoRestauranteTeste = ResourceUtils.getContentFromResource("/json/correto/restaurante-de-teste.json");
        jsonRestauranteComCozinhaInexistente = ResourceUtils.getContentFromResource("/json/incorreto/" +
                "restaurante-de-teste-incorreto.json");
    }

    @Test
    public void deveRetornarStatus200_QuandoConsultarRestaurantes(){
        given()
           .accept(ContentType.JSON)
        .when()
           .get()
        .then()
           .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornar201_QuandoCadastrarRestaurante(){
        given()
            .body(jsonCorretoRestauranteTeste)
            .contentType(ContentType.JSON)
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void deveRetornar404_QuandoCadastrarCozinhaInexistente() {
        given()
            .body(jsonRestauranteComCozinhaInexistente)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .body("title", equalTo(VIOLACAO_REGRA_DE_NEGOCIO_PROBLEM_TYPE));
    }

    @Test
    public void deveRetornar400_QuandoRestauranteInexistente(){
        given()
            .pathParam("restauranteId", RESTAURANTE_ID_INEXISTENTE)
            .accept(ContentType.JSON)
        .when()
            .get("/{restauranteId}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

    public void prepararDados(){
        Cozinha cozinhaTailandesa = new Cozinha();
        cozinhaTailandesa.setNome("Tailandesa");
        cozinhaRepository.save(cozinhaTailandesa);

        cozinhaAmericana = new Cozinha();
        cozinhaAmericana.setNome("Americana");
        cozinhaRepository.save(cozinhaAmericana);

        qntRestaurantesCadastrados = (int) restauranteRepository.count();

    }
}
