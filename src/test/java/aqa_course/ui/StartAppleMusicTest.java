package aqa_course.ui;

import aqa_course.bo.AppleMusicBO;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AppleMusicBO.class)
public class StartAppleMusicTest {
    @Test
    public void OpenPost() throws InterruptedException {

        AppleMusicBO redditBO = new AppleMusicBO();
        redditBO.search("skrillex").checkResults();
        redditBO.openMusic();
    }
}
