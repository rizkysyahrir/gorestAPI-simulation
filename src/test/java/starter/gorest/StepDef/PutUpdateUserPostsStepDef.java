package starter.GoRest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GoRest.GorestAPI;
import starter.GoRest.StepDef.Utils.Constant;
import starter.GoRest.StepDef.Utils.Gorestresponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutUpdateUserPostsStepDef {

    @Steps
    GorestAPI gorestAPI;

    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFile = new File(Constant.JSON_REQUEST +"/PutUpdatePosts.json");
        gorestAPI.putUpdatePosts(id, jsonFile);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(GorestAPI.PUT_UPDATE_USER);
    }

    @And("Response body title should be {string} and body {string} and id {int} and user_id {int}")
    public void responseBodyTitleShouldBeAndBodyAndIdAndUser_id(String title, String body, int id, int user_id) {
        SerenityRest.then()
                .body(Gorestresponses.TITLE, equalTo(title))
                .body(Gorestresponses.BODY, equalTo(body))
                .body(Gorestresponses.ID, equalTo(id))
                .body(Gorestresponses.USER_ID, equalTo(user_id));
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/PutUserValidPostsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("PUT Update posts with id {string} and with invalid json file")
    public void putUpdatePostsWithIdAndWithInvalidJsonFile(String id) {
        File jsonFile = new File(Constant.JSON_REQUEST +"/PutUpdateInvalidPosts.json");
        gorestAPI.putInvalidUpdatePosts(id, jsonFile);
    }

    @And("Response body message should be {string}")
    public void responseBodyMessageShouldBe(String message) {
        SerenityRest.then()
                .body(Gorestresponses.MESSAGE, equalTo(message));
    }
}
