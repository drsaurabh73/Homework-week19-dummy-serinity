package com.restapiexample.dummy.dummyinfosteps;

import com.restapiexample.dummy.constant.EndPoints;
import com.restapiexample.dummy.model.DummyPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class DummySteps {

    @Step
    public ValidatableResponse createDummy(String name, String salary, int age, int id, String employeename, int employeesalary,
                                           int employeeage, String profileimage, HashMap<Object, Object> employeedata) {

        DummyPojo dummyPojo = new DummyPojo();
        dummyPojo.setName(name);
        dummyPojo.setSalary(salary);
        dummyPojo.setId(id);
        dummyPojo.setAge(age);
        dummyPojo.setEmployeename(employeename);
        dummyPojo.setEmployeesalary(employeesalary);
        dummyPojo.setEmployeeage(employeeage);
        dummyPojo.setProfielimage(profileimage);
        dummyPojo.setEmployeedata(employeedata);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(dummyPojo)
                .when()
                .post(EndPoints.CREATE_EMPLOYEE_BY_ID)
                .then();
    }

    @Step("Getting the product information with employee: {0}")
    public HashMap<Object, Object> getEmployeeInfoByFirstname(int employeeID) {

        HashMap<Object, Object> productMap = SerenityRest.given().log().all()
                .when()
                .pathParam("employeeID", employeeID)
                .get(EndPoints.GET_SINGLE_EMPLOYEE_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");
        return productMap;
    }

    @Step
    public ValidatableResponse updateDummy(String name, String salary, int age, int id, String employeename, int employeesalary,
                                           int employeeage, String profileimage, HashMap<Object, Object> employeedata) {

        DummyPojo dummyPojo = new DummyPojo();
        dummyPojo.setName(name);
        dummyPojo.setSalary(salary);
        dummyPojo.setId(id);
        dummyPojo.setAge(age);
        dummyPojo.setEmployeename(employeename);
        dummyPojo.setEmployeesalary(employeesalary);
        dummyPojo.setEmployeeage(employeeage);
        dummyPojo.setProfielimage(profileimage);
        dummyPojo.setEmployeedata(employeedata);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(dummyPojo)
                .when()
                .post(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();
    }

    @Step("Deleting employee information with employeeId: {0}")
    public ValidatableResponse deleteProduct(int employeeID) {
        return SerenityRest.given().log().all()
                .pathParam("employeeID", employeeID)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();
    }

    @Step("Getting employee information with employeeId: {0}")
    public ValidatableResponse getProductById(int employeeID) {
        return SerenityRest.given().log().all()
                .pathParam("employeeID", employeeID)
                .when()
                .get(EndPoints.GET_SINGLE_EMPLOYEE_BY_ID)
                .then();
    }

    @Step("Getting all employees information")
    public ValidatableResponse getAllEmployees() {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_EMPLOYEE)
                .then();

    }
}