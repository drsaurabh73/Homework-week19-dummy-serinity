package com.restapiexample.dummy.dummyinfo;

import com.restapiexample.dummy.dummyinfosteps.DummySteps;
import com.restapiexample.dummy.testbase.TestBase;
import com.restapiexample.dummy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)
public class DummyCURDTestWithSteps extends TestBase {

    static String name = "Employee" + TestUtils.getRandomValue();
    static String salary = "Employee" + TestUtils.getRandomValue();
    static int age = 40;
    static int id = 1234;
    static String employeename = "Employee" + TestUtils.getRandomValue();
    static int employeesalary = 25000;
    static int employeeage = 42;
    static String profileimage = "Employee" + TestUtils.getRandomValue();
    static int employeeID;

    @Steps
    DummySteps dummySteps;
    @Title("This will create a new employee")
    @Test
    public void test001() {
        HashMap<Object, Object> employeedata = new HashMap<>();
        employeedata.put("Marks", "8");
        employeedata.put("Gentleman", "10");
        ValidatableResponse response = dummySteps.createDummy(name,salary,age,id,employeename,employeesalary,employeeage,profileimage,employeedata);
        response.log().all().statusCode(201);
        employeeID = response.log().all().extract().path("data.id");
        System.out.println(employeeID);
    }
    @Title("Verify if the user was added to the application")
    @Test
    public void test002 () {
        HashMap<Object, Object> storeMap = dummySteps.getEmployeeInfoByFirstname(employeeID);
        Assert.assertThat(storeMap, hasValue(name));
        System.out.println(employeeID);
    }
    @Title("Update the employee information and verify the updated information")
    @Test
    public void test003(){
        HashMap<Object, Object> employeedata = new HashMap<>();
        employeedata.put("Marks", "8");
        employeedata.put("Gentleman", "10");
        name = name  + "_updated";
        ValidatableResponse response = dummySteps.updateDummy(name,salary,age,id,employeename,employeesalary,employeeage,profileimage,employeedata);
        HashMap<Object, Object> studentMap = dummySteps.getEmployeeInfoByFirstname(employeeID);
        Assert.assertThat(studentMap, hasValue(name));
    }
    @Title("Delete the employee and verify if the employee is deleted!")
    @Test
    public void test004() {
        dummySteps.deleteProduct(employeeID).statusCode(200);
        dummySteps.getProductById(employeeID).statusCode(404);
    }
    @Title("Getting all employee information")
    public void test005() {
        dummySteps.getAllEmployees();
    }

}
