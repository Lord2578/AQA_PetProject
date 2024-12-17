package aqa_course.ui;

import aqa_course.bo.AppleMusicCheckScheduleBO;
import aqa_course.util.AllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class CheckScheduleAppleMusicTest {
    @Test
    public void testCheckRadioSchedule() throws InterruptedException {
        //check radio schedule and verify
        AppleMusicCheckScheduleBO checkScheduleBO = new AppleMusicCheckScheduleBO();
        Assert.assertTrue(checkScheduleBO.goToAppleMusicHomePage().checkRadioSchedule(),"open Radio Schedule failed!");

    }


}