package com.restapiexample.dummy.cucumber;

import com.restapiexample.dummy.dummyinfosteps.DummySteps;
import com.restapiexample.dummy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {

    static String name = "Employee" + TestUtils.getRandomValue();
    static String salary = "Employee" + TestUtils.getRandomValue();
    static int age = 40;
    static int id = 1234;
    static String employeename = "Employee" + TestUtils.getRandomValue();
    static int employeesalary = 25000;
    static int employeeage = 42;
    static String profileimage = "Employee" + TestUtils.getRandomValue();
    static int employeeID;
    static ValidatableResponse response;

    @Steps
    DummySteps dummySteps;

    @Given("^I am on Homepage of application DummyApi$")
    public void iAmOnHomepageOfApplicationDummyApi() {
    }
    @When("^User send a GET Request to list endpoint employees$")
    public void userSendAGETRequestToListEndpointEmployees() {
        response = dummySteps.getAllEmployees();

    }
    @Then("^User can get back a valid status code (\\d+) of employees$")
    public void userCanGetBackAValidStatusCodeOfEmployees(int code) {
        response.statusCode(code);
        response.assertThat().statusCode(code);
    }


    @When("^User can create new employee using POST method in products application$")
    public void userCanCreateNewEmployeeUsingPOSTMethodInProductsApplication() {
        HashMap<Object, Object> employeedata = new HashMap<>();
        employeedata.put("Marks", "8");
        employeedata.put("Gentleman", "10");
        ValidatableResponse response = dummySteps.createDummy(name,salary,age,id,employeename,employeesalary,employeeage,profileimage,employeedata);
        response.log().all().statusCode(201);
        employeeID = response.log().all().extract().path("data.id");
        System.out.println(employeeID);
    }

    @When("^User can create new employee using PUT method in employees application$")
    public void userCanCreateNewEmployeeUsingPUTMethodInEmployeesApplication() {
        HashMap<Object, Object> employeedata = new HashMap<>();
        employeedata.put("Marks", "8");
        employeedata.put("Gentleman", "10");
        name = name  + "_updated";
        ValidatableResponse response = dummySteps.updateDummy(name,salary,age,id,employeename,employeesalary,employeeage,profileimage,employeedata);
        HashMap<Object, Object> studentMap = dummySteps.getEmployeeInfoByFirstname(employeeID);
        Assert.assertThat(studentMap, hasValue(name));
    }

    @When("^User can Delete new employee using DELETE method in employees application$")
    public void userCanDeleteNewEmployeeUsingDELETEMethodInEmployeesApplication() {
        dummySteps.deleteProduct(employeeID).statusCode(204);
        response.assertThat().statusCode(200);
    }

    @And("^User verify that the employee is deleted successfully from employees$")
    public void userVerifyThatTheEmployeeIsDeletedSuccessfullyFromEmployees() {
        dummySteps.getProductById(employeeID).statusCode(404);
        response.assertThat().statusCode(200);
    }
}
