package starter.GoRest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GoRest.GorestAPI;

public class DeletePostsStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("delete posts with valid id {int}")
    public void deletePostsWithValidIdId(int id) {
        SerenityRest.given();
        gorestAPI.deleteUserValidid(id);
    }

    @When("Send request delete posts")
    public void sendRequstDeletPosts() {
        SerenityRest.when().get(GorestAPI.DELETE_USER);
    }

    @Then("response code should be {int} OK")
    public void responseCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("delete posts with invalid id {string}")
    public void deletePostsWithInvalidId(String id) {
        SerenityRest.given();
        gorestAPI.deleteUserInvalid(id);
    }

    @Then("response code should be {int} not found")
    public void responseCodeShouldBeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }


    @Given("authorization bearer token")
    public void authorizationBearerToken() {
        GorestAPI.TOKEN = "1df940318e4614fb04ef21e409b06f867be41bd03321b623ef220c2c43d45bd8";
    }

    @And("Delete comments with id {int}")
    public void deleteCommentsWithId(int id) {
        SerenityRest.given();
        gorestAPI.deletePosts(id);

    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}