package starter.GoRest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.GoRest.StepDef.Utils.Constant;

import java.io.File;

public class GorestAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL + "/public/v2/posts?page={page}";//URL Get list users
    public static String GET_LIST_UNKNOWN = Constant.BASE_URL + "/public/v2/unknown";//Unknown
    //    public static String GET_LIST_Without_Param = Constant.BASE_URL + "/public/v2/posts";
    public static String GET_SINGLE_POSTS = Constant.BASE_URL + "/public/v2/posts/{id}";//URL Get single

    public static String POST_CREATE_USER = Constant.BASE_URL + "/public/v2/posts";//URL Post create users

    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/public/v2/posts/{id}";//URL Put update users
    public static String DELETE_USER = Constant.BASE_URL + "/public/v2/posts/{id}";//URL Delete users

    public static String GET_USER_POSTS = Constant.BASE_URL + "/public/v2/users/{id}/posts";
    public static String TOKEN = "1df940318e4614fb04ef21e409b06f867be41bd03321b623ef220c2c43d45bd8";

    @Step("Get single posts")
    public void getSinglePosts(int id) {
        SerenityRest.given()
                .pathParam("id", id);

    }

    @Step("Delete user")
    public void deleteUserValidid(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete user invalid id")
    public void deleteUserInvalid(String id) {
        SerenityRest.given()
                .pathParams("id", id);
    }

    @Step("Delete posts")
    public void deletePosts(int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer 1df940318e4614fb04ef21e409b06f867be41bd03321b623ef220c2c43d45bd8")
                .pathParam("id", id);
    }

    @Step("Get list user")
    public void getListUser(int page) {
        SerenityRest.given()
                .pathParams("page", page);
    }

    @Step("Get list user without parameter")
    public void getListUserWithoutParam() {
        SerenityRest.given();
    }

    @Step("Get list users invalid parameter")
    public void getListUserInvalid(String page) {
        SerenityRest.given()
                .pathParams("page", page);
    }

    @Step("Post create user")
    public void postCreatePosts(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer 1df940318e4614fb04ef21e409b06f867be41bd03321b623ef220c2c43d45bd8")
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update posts")
    public void putUpdatePosts(int id, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer 1df940318e4614fb04ef21e409b06f867be41bd03321b623ef220c2c43d45bd8")
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update posts invalid")
    public void putInvalidUpdatePosts(String id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get users posts")
    public void GetUsersPosts(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get users invalid id posts")
    public void GetUsersPostsInvalidPosts(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
}
