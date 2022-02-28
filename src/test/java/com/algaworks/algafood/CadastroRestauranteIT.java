package com.algaworks.algafood;

import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroRestauranteIT {
    @LocalServerPort
    private int port;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    private String jsonCorretoRestauranteTeste;

    @BeforeEach
    public void setUp(){
        //Habilita um log
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.port = port;
        RestAssured.basePath = "/restaurantes";

        databaseCleaner.clearTables();
//        prepararDados();

        jsonCorretoRestauranteTeste = ResourceUtils.getContentFromResource("/json/correto/restaurante-de-teste.json");
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

//    @Test
//    public void deveRetornar201_QuandoCadastrarRestaurante(){
//        given()
//            .contentType(ContentType.JSON)
//        .when()
//        .then()
//
//    }


}
