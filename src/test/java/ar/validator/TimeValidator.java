package ar.validator;

import api.model.TimeResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class TimeValidator {
    public static void validateTimeIds(){
        //Realizamos las validaciones correspondientes
        TimeResponse[] response = (TimeResponse[]) APIManager.getLastResponse().getResponse();
        for(TimeResponse time : response){
            Assert.assertNotNull(time.getId());
        }
    }
}
