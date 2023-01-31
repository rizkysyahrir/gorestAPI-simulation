package starter.gorest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.jruby.ext.api.array;
import starter.gorest.GorestAPI;
import starter.gorest.Utils.Constant;
import starter.gorest.Utils.GorestResponse;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class ListUsersStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page){
        SerenityRest.given()
                .headers("Authorization","Bearer $d0458302309555760e28b2f640c85b88ba5639d4f4421bac49d94d6492344f14");
        gorestAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser(){
        SerenityRest.when().get(GorestAPI.GET_LIST_USERS);
    }

    @And("Response body id should be {int}")
    public void responseBodyPageShouldBe(int data_id){
        SerenityRest.then().body(GorestResponse.DATA_ID, Matchers.instanceOf(List.class));
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/ListUsersSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list users with unknown")
    public void getListUserUnknown() {
        gorestAPI.getListUsersUnknown();
    }

    @When("Send request unknown get list user")
    public void sendRequestListUserUnknown(){
        SerenityRest.when().get(GorestAPI.GET_LIST_UNKNOWN);
    }

    //Scenario2

    @Given("Get single user with id {int}")
    public void getSingleUserWithId(int id){
        gorestAPI.getSingleUserId(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser(){
        SerenityRest.when().get(GorestAPI.GET_SINGLE_USER);
    }

//    @And("Response body page should be {int}")
//    public void responseBodyIdShouldBe(int page){
//        SerenityRest.then().body(GorestResponse.PAGE, equalTo(page));
//    }
    @Then("Should return status code {int}")
    public void ShouldReturnStatusCode(int statusCode){
    SerenityRest.then().statusCode(statusCode);
}

    @And("Validate json schema single user not found")
    public void validateJsonSchemaSingleUserNf(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleUserNFSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 3
    @And("Validate json schema single user")
    public void validateJsonSchemaSingleUser(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
