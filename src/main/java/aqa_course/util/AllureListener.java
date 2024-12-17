package aqa_course.util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static aqa_course.driver.DriverProvider.getDriver;

public class AllureListener implements ITestListener, IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        if (testResult.getStatus() == ITestResult.FAILURE) {
            attachDOM();
            makeScreenShot();
            saveHtmlToFile();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        makeScreenShot();

        saveHtmlToFile();
    }

    @Attachment(value = "Page screen", type = "image/png")
    private byte[] makeScreenShot() {
        byte[] result = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        System.out.println("Made Screenshot");
        return result;
    }

    @Attachment(value = "Page source DOM", type = "text/html")
    private String attachDOM() {
        System.out.println("Attached DOM");
        return getDriver().getPageSource();
    }

    @Attachment(value = "HTML code", type = "text/plain")
    private String saveHtmlToFile() {
        String htmlSource = getDriver().getPageSource();
        String fileName = "pagesource" + System.currentTimeMillis() + ".html";

        File file = new File("allure-results/html-codes" + fileName);
        file.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            assert htmlSource != null;
            writer.write(htmlSource);
            System.out.println("Saved page HTML source to: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save HTML source");
        }
        return htmlSource;
    }
}