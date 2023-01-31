package starter.gorest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItemInArray;

public class UpdateUsersStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("PUT update user with valid json with id {int}")
    public void updateUserWithValidJsonWithId(int id){
        File json = new File(Constant.JSON_REQUEST+"/UpdateUsers.json");
        gorestAPI.putUpdateUsers(id, json);
    }

    @When("Send request PUT update user")
    public void sendRequestUpdateUser(){
        SerenityRest.when().put(GorestAPI.PUT_UPDATE_USER);
    }

    @And("Response body put should be email {string}, name {string}, gender {string} and status {string}")
    public void responseBodyNameShouldBeAndJob(String email, String name, String gender, String status){
        SerenityRest.then()
                .body(GorestResponse.EMAIL, equalTo(email))
                .body(GorestResponse.NAME, equalTo(name))
                .body(GorestResponse.GENDER, equalTo(gender))
                .body(GorestResponse.STATUS, equalTo(status));
    }

    @And("Validate json schema update users")
    public void validateJsonSchemaUpdateUsers(){
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UpdateUsersSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2
    @Given("PUT update user with valid json with id {int} without email")
    public void putUpdateUserWithValidJsonWithId(int id){
        File json = new File(Constant.JSON_REQUEST+"/UpdateUsersWithoutEmail.json");
        gorestAPI.putUpdateUsers(id, json);
    }

    @And("Response body message put should be email: can't be blank")
    public void responseBodyMessage(){
        SerenityRest.then()
                .body(GorestResponse.MESSAGE, Matchers.instanceOf(List.class));
    }

    @And("Validate json schema update users without email")
    public void validateJsonSchemaUpdateUsersWoEmail(){
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UpdateUsersWoEmailSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request PATCH update user")
    public void sendRequestPatchUpdateUser(){
        SerenityRest.when().patch(GorestAPI.PATCH_UPDATE_USER);
    }

}
