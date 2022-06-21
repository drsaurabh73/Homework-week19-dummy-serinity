package com.restapiexample.dummy.dummyinfo;

import com.restapiexample.dummy.constant.EndPoints;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
@RunWith(SerenityRunner.class)
public class FirstTest extends TestBase {

    @Test
    public void getDummyemployeeinfo() {
        Response response = given()
                .when()
                .get(EndPoints.GET_ALL_EMPLOYEE);
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
