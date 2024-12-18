package aqa_course.DataProvider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                // Тестові дані для кожного тесту
                {"Test Board 1", "Board Alpha", "List 1", "Card 1"},
                {"Test Board 2", "Board Beta", "List 2", "Card 2"},
                {"Test Board 3", "Board Gamma", "List 3", "Card 3"}
        };
    }
}

