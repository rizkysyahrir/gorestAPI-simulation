package starter.GoRest.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GoRest.GorestAPI;

public class GetUserPostsStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("Get users post with valid id {int}")
    public void getSinglePostWithValidId(int id) {
        gorestAPI.GetUsersPosts(id);
    }

    @When("Send request get user posts")
    public void sendRequestGetUserPosts() {
        SerenityRest.when().get(GorestAPI.GET_USER_POSTS);
    }

    @Given("Get users post with invalid id {string}")
    public void getSinglePostWithInvalidId(String id) {
        gorestAPI.GetUsersPostsInvalidPosts(id);
    }
}
