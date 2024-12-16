package aqa_course.ui;

import aqa_course.bo.RedditBO;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void TestMethod_1() {
        RedditBO redditBO = new RedditBO();
        redditBO.search("something").checkResults();
        redditBO.openFirstPost();
    }
}
