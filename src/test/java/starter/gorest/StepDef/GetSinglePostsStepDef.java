package starter.GoRest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GoRest.GorestAPI;
import starter.GoRest.StepDef.Utils.Constant;
import starter.GoRest.StepDef.Utils.Gorestresponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSinglePostsStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("Get single posts with valid id {int}")
    public void getSinglePostsWithId(int id) {
        gorestAPI.getSinglePosts(id);
    }

    @When("Send request get single posts")
    public void sendRequestGetSinglePosts() {
        SerenityRest.when().get(GorestAPI.GET_SINGLE_POSTS);
    }

    @And("Validate json schema single user")
    public void validateJsonSchemaSingleUser() {
        File jsonFiles = new File(Constant.JSON_SCHEMA + "/GetSinglePostsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then()
                .body(Gorestresponses.MESSAGE, equalTo(message));
    }

    @Given("Get single posts with invalid id {int}")
    public void getSinglePostsWithInvalidId(int id) {
        gorestAPI.getSinglePosts(id);
    }

    @And("Get single posts invalid id assert json validation")
    public void getSinglePostsInvalidIdAssertJsonValidation() {
        File jsonFiles = new File(Constant.JSON_SCHEMA + "/GetSingleInvalidPostsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }
}


