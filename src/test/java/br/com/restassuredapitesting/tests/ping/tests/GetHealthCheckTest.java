package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.suites.HealthCheck;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.ping.requests.GetHealthCheckRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GetHealthCheckTest extends BaseTest {

    GetHealthCheckRequest getHealthCheckRequest = new GetHealthCheckRequest();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category(HealthCheck.class)
    @DisplayName("API online")
    public void verificaApiOnline() throws Exception{
        getHealthCheckRequest.healthCheck().then()
                .statusCode(201);
    }
}
