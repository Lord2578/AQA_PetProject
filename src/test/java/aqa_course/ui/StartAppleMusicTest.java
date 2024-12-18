package aqa_course.ui;

import aqa_course.bo.AppleMusicBO;
import aqa_course.util.AllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class StartAppleMusicTest {
    @Test
    public void playMusic() throws InterruptedException {

        AppleMusicBO appleMusicBO = new AppleMusicBO();
        appleMusicBO.search("skrillex").checkResults();
        appleMusicBO.openMusic();
    }

    @Test
    public void playMusicFail() throws InterruptedException {

        AppleMusicBO appleMusicBO = new AppleMusicBO();
        appleMusicBO.search("skrillex").checkResults();
        Assert.fail();
        appleMusicBO.openMusic();
    }
}
