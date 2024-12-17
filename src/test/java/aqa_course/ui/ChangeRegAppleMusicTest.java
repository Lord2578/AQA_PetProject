package aqa_course.ui;

import aqa_course.bo.AppleMusicChangeRegBO;
import com.automation.remarks.video.annotations.Video;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeRegAppleMusicTest {
    @Test
    @Video
    public void testChangeToUaRegion() throws InterruptedException {
        //change region and verify
        AppleMusicChangeRegBO regionBO = new AppleMusicChangeRegBO();
        Assert.assertTrue(regionBO.goToAppleMusicHomePage().changeToUaRegion(),"change theme Failed!");

    }


}