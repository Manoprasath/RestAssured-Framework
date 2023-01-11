package com.marusputin.specbuilders;

import com.marusputin.enums.PropertyKey;
import com.marusputin.util.PropertyUtil;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * This class is to create common specification for both request and response
 */
public final class ApiSpecBuilders {

    private ApiSpecBuilders() {
    }

    public static RequestSpecification addPlaceRequestSpecBuilder() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .setBaseUri(PropertyUtil.getValue(PropertyKey.BASE_URI))
                .addQueryParam("key", "qaclick123")
                .build();
    }
}
