package starter.GoRest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GoRest.GorestAPI;
import starter.GoRest.StepDef.Utils.Constant;

import java.io.File;

public class GetListUserPosts {

    @Steps
    GorestAPI gorestAPI;

    @Given("Get list user without parameter")
    public void getListUserWithoutParameter() {
        gorestAPI.getListUserWithoutParam();

    }

    @When("Send request get list posts")
    public void sendRequestGetListPosts() {
        SerenityRest.when().get(GorestAPI.GET_LIST_USERS);
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser() {
        File jsonFiles = new File(Constant.JSON_SCHEMA + "/GetListUserPostSchema");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @Given("Get list user with valid parameter {int}")
    public void getListUserWithValidParameterPage(int page) {
        gorestAPI.getListUser(page);
    }

    @Given("Get list user with invalid parameter {string}")
    public void getListUserWithInvalidParameterPage(String page) {
        gorestAPI.getListUserInvalid(page);
    }

    @Given("Get list user with unknown parameter")
    public void getListUserWithUnknownParameter() {
        gorestAPI.getListUserWithoutParam();
    }

    @When("Send request get list posts unknown parameter")
    public void sendRequestGetListPostUnknownParam() {
        SerenityRest.when().get(GorestAPI.GET_LIST_UNKNOWN);
    }

    @When("Send request get list posts without parameter")
    public void sendRequestGetListPostWithoutParam() {
        SerenityRest.when().get(GorestAPI.GET_LIST_UNKNOWN);
    }
}
