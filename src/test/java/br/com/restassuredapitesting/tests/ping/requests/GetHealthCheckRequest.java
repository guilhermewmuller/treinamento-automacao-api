package br.com.restassuredapitesting.tests.ping.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetHealthCheckRequest {

        @Step("Verificar se a API está online.")
        public Response healthCheck(){
            return given()
                    .header("Content-Type", "application/json")
                    .when()
                    .get("ping");
        }
    }
