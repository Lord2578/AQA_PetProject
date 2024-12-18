package aqa_course.api;

import aqa_course.util.ApiHelper;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateCardTest {

    private static final Logger logger = LogManager.getLogger(CreateCardTest.class);

    @DataProvider(name = "cardDataProvider")
    public Object[][] cardDataProvider() {
        return new Object[][]{
                {"List 1", "Card 1"}
        };
    }

    @Test(dataProvider = "cardDataProvider")
    public void testCreateCard(String listName, String cardName) {
        logger.info("Testing card creation in list: {} with name: {}", listName, cardName);

        String boardId = ApiHelper.createBoard("Temporary Board");
        Assert.assertNotNull(boardId, "Board creation failed. ID is null");

        String listId = ApiHelper.createList(boardId, listName);
        Assert.assertNotNull(listId, "List creation failed. ID is null");

        ApiHelper.createCard(listId, cardName);
        logger.info("Card '{}' created successfully in list ID: {}", cardName, listId);

        Allure.addAttachment("Request", "text/plain", ApiHelper.getLastRequest(), "txt");
        Allure.addAttachment("Response", "application/json", ApiHelper.getLastResponse(), "json");

        ApiHelper.deleteBoard(boardId);
        logger.info("Board deleted with ID: {}", boardId);
    }
}
