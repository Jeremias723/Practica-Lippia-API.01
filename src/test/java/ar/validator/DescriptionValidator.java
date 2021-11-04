package ar.validator;

import api.model.AddTimeResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;
import services.BaseService;
import services.EditTimeService;

public class DescriptionValidator {
    public static void validate(String expectedDescription) {

        AddTimeResponse response = (AddTimeResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(expectedDescription,response.getDescription(),"No coincide la descripción del proyecto");

    }
}
