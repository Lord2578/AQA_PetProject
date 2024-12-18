package aqa_course.api;

import aqa_course.util.AllureListener;
import aqa_course.util.ApiHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class CreateBoardTest {

    private static final Logger logger = LogManager.getLogger(CreateBoardTest.class);

    @DataProvider(name = "boardDataProvider")
    public Object[][] boardDataProvider() {
        return new Object[][]{
                {"Test Board 1"}
        };
    }

    @Test(dataProvider = "boardDataProvider")
    public void testCreateBoard(String boardName) {
        logger.info("Testing board creation with name: {}", boardName);

        String boardId = ApiHelper.createBoard(boardName);
        Assert.assertNotNull(boardId, "Board creation failed. ID is null");

        logger.info("Board created successfully with ID: {}", boardId);

        ApiHelper.deleteBoard(boardId);
        logger.info("Board deleted with ID: {}", boardId);
    }
}
