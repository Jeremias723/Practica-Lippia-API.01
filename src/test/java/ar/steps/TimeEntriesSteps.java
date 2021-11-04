package ar.steps;

import api.config.EntityConfiguration;
import api.model.AddTimeResponse;
import ar.validator.DescriptionValidator;
import ar.validator.TimeValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.StringUtils;
import services.BaseService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class TimeEntriesSteps extends PageSteps {

    @Given("^My account created in clockify and my X-Api-Key$")
    public void myAccountCreatedInClockifyAndMyXApiKey() {
        BaseService.API_KEY.set("Yzg3NDhjY2MtMmQ5My00YmNlLWFiOGQtNjhhYjU5NWE5Njdl");
    }

    @And("My valid workspace id")
    public void myValidWorkspaceId() {
        BaseService.ID_WORKSPACE.set("61717ee37bebf32276ae136b");
    }

    @And("My valid project id")
    public void myValidProjectId() {
        BaseService.ID_PROJECT.set("61718abc504d967c7d2987d3");
    }

    @Then("Validate the expected response was obtained in (.*)")
    public void theExpectedResponseWasObtainedInEntityWithTheJsonNameResponse(String entity) {
        TimeValidator.validateTimeIds();
    }

    @When("I perform a '(.*)' to '(.*)' with the endpoint '(.*)' and '(.*)'")
    public void iPerformAOperationToEntityWithTheEndpointJsonNameAnd(String methodName, String entity, String jsonName, String jsonReplacementValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonReplacementValues);
        String jsonPath = "request/".concat(jsonName);
        if (parameters == null) {
            entityService.getMethod(methodName.toLowerCase(), String.class).invoke("", jsonPath);
        } else {
            entityService.getMethod(methodName.toLowerCase(), String.class, Map.class).invoke("", jsonPath, parameters);
        }

    }

    private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }

    @And("A (.*) for the time entrie")
    public void aDescriptionForTheTimeEntrie(String cadena) {
        BaseService.DESCRIPTION.set(cadena);
    }

    @Then("Validate the expected (.*) on the new time entrie")
    public void validateTheExpectedDescriptionOnTheNewTimeEntrie(String expectedDescription) {
        DescriptionValidator.validate(expectedDescription);
    }



    @And("I have a new hour (.*) to set")
    public void theNewHour(String hour) {
        BaseService.HOUR.set(hour);
    }


    @And("Save the time entry id")
    public void myValidTimeEntryId() {
        AddTimeResponse response = (AddTimeResponse) APIManager.getLastResponse().getResponse();
        BaseService.ID_TIME.set(response.getId());
    }
}

