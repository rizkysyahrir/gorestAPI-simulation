package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.gorest.Utils.Constant;

import java.io.File;

public class GorestAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL + "/public/v2/users?page={page}";//URL Get list users

    public static String GET_LIST_UNKNOWN = Constant.BASE_URL + "/public/v2/unkonwn";//URL Get list users

    public static String GET_SINGLE_USER = Constant.BASE_URL + "/public/v2/users/{id}";//URL Get single

    public static String POST_CREATE_USER = Constant.BASE_URL + "/public/v2/users";//URL Post create users

    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/public/v2/users/{id}";//URL Put update users

    public static String PATCH_UPDATE_USER = Constant.BASE_URL + "/public/v2/users/{id}";//URL Patch update users

    public static String DELETE_USER = Constant.BASE_URL + "/public/v2/users/{id}";//URL Delete users

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get single users")
    public void getSingleUserId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list users")
    public void getListUsers(String page) {
        SerenityRest.given()
                .pathParam("page", page)
                .get(GET_LIST_USERS);
    }

    @Step("Get list users")
    public void getListUsersUnknown() {
        SerenityRest.given()
                .get(GET_LIST_UNKNOWN);
    }

    @Step("Post create users")
    public void postCreateUser(File json){
        SerenityRest.given().headers("Authorization","Bearer d0458302309555760e28b2f640c85b88ba5639d4f4421bac49d94d6492344f14")
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update users")
    public void putUpdateUsers(int id, File json){
        SerenityRest.given().headers("Authorization","Bearer d0458302309555760e28b2f640c85b88ba5639d4f4421bac49d94d6492344f14")
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch Update users")
    public void patchUpdateUsers(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete users")
    public void deleteUser(int id){
        SerenityRest.given().headers("Authorization","Bearer d0458302309555760e28b2f640c85b88ba5639d4f4421bac49d94d6492344f14")
                .pathParam("id", id);
    }
}
