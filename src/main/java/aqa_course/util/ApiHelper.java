package aqa_course.util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private static final Logger logger = LogManager.getLogger(ApiHelper.class);

    private static final String BASE_URL = PropertyReader.getProperty("baseURL");
    private static final String TRELLO_KEY = PropertyReader.getProperty("key");
    private static final String TRELLO_TOKEN = PropertyReader.getProperty("token");

    @Step("Create board with name: {name}")
    public static String createBoard(String name) {
        logger.info("Creating board with name: {}", name);
        Response response = given()
                .queryParam("name", name)
                .queryParam("key", TRELLO_KEY)
                .queryParam("token", TRELLO_TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + "boards")
                .then().log().body()
                .statusCode(200)
                .extract().response();

        String boardId = response.jsonPath().getString("id");
        logger.info("Board created with ID: {}", boardId);
        return boardId;
    }

    @Step("Update board name to: {newName} for board ID: {boardId}")
    public static void updateBoardName(String boardId, String newName) {
        logger.info("Updating board name to: {} for board ID: {}", newName, boardId);
        given()
                .queryParam("name", newName)
                .queryParam("key", TRELLO_KEY)
                .queryParam("token", TRELLO_TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .put(BASE_URL + "boards/" + boardId)
                .then().log().body()
                .statusCode(200);
        logger.info("Board name updated to: {}", newName);
    }

    @Step("Delete board with ID: {boardId}")
    public static void deleteBoard(String boardId) {
        logger.info("Deleting board with ID: {}", boardId);
        given()
                .queryParam("key", TRELLO_KEY)
                .queryParam("token", TRELLO_TOKEN)
                .header("Accept", "application/json")
                .when()
                .delete(BASE_URL + "boards/" + boardId)
                .then().log().body()
                .statusCode(200);
        logger.info("Board with ID: {} deleted", boardId);
    }

    @Step("Create list with name: {name} on board ID: {boardId}")
    public static String createList(String boardId, String name) {
        logger.info("Creating list with name: {} on board ID: {}", name, boardId);
        Response response = given()
                .queryParam("name", name)
                .queryParam("idBoard", boardId)
                .queryParam("key", TRELLO_KEY)
                .queryParam("token", TRELLO_TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + "lists")
                .then().log().body()
                .statusCode(200)
                .extract().response();

        String listId = response.jsonPath().getString("id");
        logger.info("List created with ID: {}", listId);
        return listId;
    }

    @Step("Create card with name: {name} in list ID: {listId}")
    public static void createCard(String listId, String name) {
        logger.info("Creating card with name: {} in list ID: {}", name, listId);
        given()
                .queryParam("name", name)
                .queryParam("idList", listId)
                .queryParam("key", TRELLO_KEY)
                .queryParam("token", TRELLO_TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + "cards")
                .then().log().body()
                .statusCode(200);
        logger.info("Card with name: {} created in list ID: {}", name, listId);
    }
}
