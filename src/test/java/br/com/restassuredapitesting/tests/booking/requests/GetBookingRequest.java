package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Buscar todas as reservas.")
    public Response allBookings(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking");
    }

    @Step("Buscar uma única reserva.")
    public Response idBooking(int id){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking/"+ id);
    }

    @Step("Buscar IDs filtrando por Firstname.")
    public Response firstNameBooking(String param, String name){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .queryParam(param, name)
                .get("booking");
    }
}


