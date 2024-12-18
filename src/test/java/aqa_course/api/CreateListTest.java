package aqa_course.api;

import aqa_course.util.ApiHelper;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateListTest {

    private static final Logger logger = LogManager.getLogger(CreateListTest.class);

    @DataProvider(name = "listDataProvider")
    public Object[][] listDataProvider() {
        return new Object[][]{
                {"Board Alpha", "List A"}
        };
    }

    @Test(dataProvider = "listDataProvider")
    public void testCreateList(String boardName, String listName) {
        logger.info("Testing list creation on board: {} with name: {}", boardName, listName);

        String boardId = ApiHelper.createBoard(boardName);
        Assert.assertNotNull(boardId, "Board creation failed. ID is null");

        String listId = ApiHelper.createList(boardId, listName);
        Assert.assertNotNull(listId, "List creation failed. ID is null");

        Allure.addAttachment("Request", "text/plain", ApiHelper.getLastRequest(), "txt");
        Allure.addAttachment("Response", "application/json", ApiHelper.getLastResponse(), "json");

        logger.info("List created successfully with ID: {}", listId);

        ApiHelper.deleteBoard(boardId);
        logger.info("Board deleted with ID: {}", boardId);
    }
}
