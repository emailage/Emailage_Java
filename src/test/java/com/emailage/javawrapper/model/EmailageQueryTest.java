package com.emailage.javawrapper.model;

import com.emailage.javawrapper.model.response.EmailageQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.hamcrest.MatcherAssert.assertThat;

public class EmailageQueryTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturnTheSameJsonWhenConvertClass() throws JsonProcessingException, JSONException {
        EmailageQuery emailageQuery = new EmailageQuery();
        String expected = "{\"email\":null,\"ipaddress\":null,\"queryType\":null,\"count\":0,\"created\":null,\"lang\":null,\"responseCount\":0,\"results\":null,\"raw\":null,\"flag\":null,\"billcity\":null,\"billpostal\":null,\"transamount\":null,\"existingcustomer\":null,\"fraudcodeID\":null,\"acceptlang\":null,\"billaddress\":null,\"billregion\":null,\"billcountry\":null,\"deviceid\":null,\"devicesource\":null,\"firstname\":null,\"lastname\":null,\"phone\":null,\"shipaddress\":null,\"shipcity\":null,\"shipcountry\":null,\"shippostal\":null,\"shipregion\":null,\"transcurrency\":null,\"transorigin\":null,\"urid\":null,\"customerid\":null,\"cardFirstSix\":null,\"user_email\":null,\"useragent\":null,\"time_to_service\":null,\"secondary_email\":null,\"service_date\":null,\"service_location\":null,\"service_detail\":null,\"service_category\":null,\"service_type\":null,\"hashedCardNumber\":null,\"custom1\":null,\"custom2\":null,\"response_language\":null}";
        String result = objectMapper.writeValueAsString(emailageQuery);
        JSONAssert.assertEquals(result, expected, true);

    }
}
