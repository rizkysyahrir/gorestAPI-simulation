package starter.gorest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.gorest.GorestAPI;
import starter.gorest.Utils.Constant;
import starter.gorest.Utils.GorestResponse;

import java.io.File;
import java.util.List;

public class PostUsersStepDef {

    @Steps
    GorestAPI gorestAPI;

    @Given("Create new users with valid json")
    public void createUserWithValidJson(){
        File json = new File(Constant.JSON_REQUEST+"/CreateNewUsers.json");
        gorestAPI.postCreateUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestRegisterUser(){
        SerenityRest.when().post(GorestAPI.POST_CREATE_USER);
    }

    @And("Response body message should be email: \"has already been taken\"")
    public void responseBodyMessage(){
        SerenityRest.then()
                .body(GorestResponse.MESSAGE, Matchers.instanceOf(List.class));
    }
    @Then("Validate json schema create new users")
    public void validateJsonSchemaCreateUsers(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/CreateNewUsersSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    @Given("Create users same email with valid json")
    public void createUsersSamesEmailWithValidJson(){
        File json = new File(Constant.JSON_REQUEST+"/CreateUsersSameEmail.json");
        gorestAPI.postCreateUser(json);
    }

    @And("Validate json schema create users same email")
    public void validateJsonSchemaCreateUserSameEmail() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/CreateUsersSameEmailSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //    //create user
//    @Given("Post create users with valid json")
//    public void postCreateUserWithValidJson() {
//        File json = new File(Constant.JSON_REQUEST + "/CreateNewUsers.json");
//        gorestAPI.postCreateUser(json);
//    }
//
//    @Given("Post create user with invalid json")
//    public void postCreateUserWithInvalidJson() {
//        File json = new File(Constant.JSON_REQUEST + "/InvalidRequestUser.json");
//        gorestAPI.postCreateUser(json);
//    }
//
//    @When("Send request post create user")
//    public void sendRequestPostCreateUser() {
//        SerenityRest.when().post(GorestAPI.POST_CREATE_USER);
//    }
//
//    @Given("Register user with invalid json")
//    public void registerUserWithInvalidJson() {
//        File json = new File(Constant.JSON_REQUEST + "/RegisterUnsuccess.json");
//        gorestAPI.postRegisUser(json);
//    }
//
//    @And("Validate json schema failed register user")
//    public void validateJsonSchemaFailedRegisterUser() {
//        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterUnsuccessSchema.json");
//        SerenityRest.then()
//                .assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
//    }
}
