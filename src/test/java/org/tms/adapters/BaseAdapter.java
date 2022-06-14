package org.tms.adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.tms.utils.StringConstant.TOKEN_NAME;

public class BaseAdapter {

    private static final String BASE_URL = "https://api.qase.io/v1";
    //private static final String TOKEN_VALUE= System.getProperty("token");


    private static final String TOKEN_VALUE = "d1d4ed11a18254455b2d3433f4a6b74f78127f73";
    Gson converter = new Gson();

    protected Response post(String url, String body){
        return
                given()
                        .header(TOKEN_NAME,TOKEN_VALUE)
                        .header("Content-Type","application/json")
                        .body(body)
                .when()
                        .post(BASE_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    protected String delete(String url){
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .header("Content-Type","application/json")
                    .when()
                        .delete(BASE_URL + url)
                    .then()
                        .log().all()
                        .extract().body().asString();
    }

}




