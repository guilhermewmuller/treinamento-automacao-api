package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

@Feature("Reservas")
public class DeleteBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();
    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Deletar uma reserva específica.")
    public void deletarUmaReservaEspecifica() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");

        //System.out.println(primeiroId);

        deleteBookingRequest.deleteReservaEspecifica(primeiroId).then()
                .statusCode(201)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }
}
