package com.marusputin.tests;

import com.marusputin.annotations.TestDetails;
import com.marusputin.pojo.AddPlace;
import com.marusputin.pojo.Location;
import com.marusputin.reports.ExtentLoggers;
import com.marusputin.specbuilders.ApiSpecBuilders;
import com.marusputin.util.FileUtils;
import com.marusputin.util.RandomUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddPlaceTest {

    @TestDetails(author = {"Mano"}, category = {"smoke", "regression"})
    @Test()
    public void addPlaceTestUsingPojo() {
        AddPlace place = AddPlace.builder()
                .accuracy(RandomUtils.getNumber())
                .address(RandomUtils.getAddress().fullAddress())
                .name("Frontier house")
                .website("http://google.com")
                .language("French-IN")
                .types(List.of("shoe park", "shop"))
                .location(Location.builder().lat(-38.383494).lng(33.427362).build())
                .phone_number("(+91) 983 893 3937")
                .build();

        RequestSpecification requestSpecification = given().spec(ApiSpecBuilders.addPlaceRequestSpecBuilder())
                .body(place);
        ExtentLoggers.logRequest(requestSpecification);

        Response response = requestSpecification.when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();

        ExtentLoggers.info("response details below");
        ExtentLoggers.log(response.prettyPrint());

        assertThat(response.getStatusCode(), Matchers.equalTo(200));
//        assertThat(response.jsonPath()., Matchers.equalTo(200));
    }

    @TestDetails(author = {"Mano"}, category = {"smoke", "regression"})
    @Test
    public void addPlaceUsingExternalFile(Method method) {
        String input = FileUtils.readJsonAndGetAsString("/AddPlacePayload.json")
                .replace("address_value", RandomUtils.getAddress().fullAddress())
                .replace("50", String.valueOf(RandomUtils.getNumber()));

        Response response = given().spec(ApiSpecBuilders.addPlaceRequestSpecBuilder())
                .body(input)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();
        ExtentLoggers.log(response.prettyPrint());
        FileUtils.storeStringAsJsonFile(method.getName(), response);
    }
}
