package starter.gorest.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class DeleteUsersStepDef {

    @Steps
    GorestAPI gorestAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id){
        gorestAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser(){
        SerenityRest.when().delete(GorestAPI.DELETE_USER);
    }
}
