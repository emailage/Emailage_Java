package com.emailage.javawrapper.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ExtraInputParameterTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturnTheSameJsonWhenConvertClass() throws JsonProcessingException, JSONException {
        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        String expected = "{\"firstname\":\"\",\"lastname\":\"\",\"billaddress\":\"\",\"billcity\":\"\",\"billregion\":\"\",\"billpostal\":\"\",\"billcountry\":\"\",\"shipaddress\":\"\",\"shipcity\":\"\",\"shipregion\":\"\",\"shippostal\":\"\",\"shipcountry\":\"\",\"phone\":\"\",\"transamount\":0.0,\"transcurrency\":\"\",\"transorigin\":\"\",\"existingcustomer\":false,\"useragent\":\"\",\"acceptlang\":\"\",\"customerid\":\"\",\"urid\":\"\",\"deviceid\":\"\",\"devicesource\":\"\",\"response_language\":\"\",\"user_email\":\"\",\"secondary_email\":\"\",\"service_category\":\"\",\"service_date\":\"\",\"service_detail\":\"\",\"service_location\":\"\",\"time_to_service\":0,\"delivery_type\":\"\",\"custom1\":\"\",\"custom2\":\"\",\"cardFirstSix\":\"\",\"hashedCardNumber\":\"\"}";
        String result = objectMapper.writeValueAsString(extraInputParameter);
        JSONAssert.assertEquals(expected, result, JSONCompareMode.LENIENT);

    }
}
