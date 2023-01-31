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

import java.io.File;

public class PostCreateUserStepDef {

    @Steps
    GorestAPI gorestAPI;

    @When("post create posts with valid json file")
    public void postCreateCommentsWithValidJsonFile() {
        File jsonFiles = new File(Constant.JSON_REQUEST + "/PostCreatePosts.json");
        gorestAPI.postCreatePosts(jsonFiles);
    }

    @When("Send request post create posts")
    public void sendRequestPostCreate() {
        SerenityRest.when().post(GorestAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema create posts")
    public void validateJsonSchemaCreatePosts() {
        File jsonFiles = new File(Constant.JSON_SCHEMA + "/PostCreateValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @When("Post create new posts without title")
    public void postCreateNewPostsWithoutTitle() {
        SerenityRest.when().post(GorestAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} unprocessable")
    public void statusCodeShouldBeUnprocessable(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate invalid json schema create posts")
    public void validateInvalidJsonSchemaCreatePosts() {
        File jsonFiles = new File(Constant.JSON_SCHEMA + "/PostCreateInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }
}
