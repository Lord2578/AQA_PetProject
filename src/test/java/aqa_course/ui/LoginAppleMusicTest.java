package aqa_course.ui;

import aqa_course.bo.AppleMusicLoginBO;
import aqa_course.util.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AppleMusicLoginBO.class})
public class LoginAppleMusicTest {
    @Test
    void appleMusicLoginTest() {
        AppleMusicLoginBO loginBO = new AppleMusicLoginBO();

        //getProperties
        String login = PropertyReader.getProperty("login");
        String password = PropertyReader.getProperty("password");

        //login
        loginBO.appleMusicLogIn(login,password);

        //verify login
        boolean isLoggedIn = loginBO.verifyLogin();
        Assert.assertTrue(isLoggedIn, "Login failed!");
    }
}