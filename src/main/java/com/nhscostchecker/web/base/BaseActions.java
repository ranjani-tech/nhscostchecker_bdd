package com.nhscostchecker.web.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BaseActions {

    WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    protected void goToWeb(String url) {
        driver.get(url);
        String message = "Landing to Web Page: " + url;
        System.out.println(message);
    }

    @Step
    protected void waitUntilUrlContains(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(url));
        String message = "wait until URL: " + url + " is visible";
        System.out.println(message);
    }

    @Step
    protected WebElement findHeadingByText(String headingText) {
        return driver.findElement(By.xpath("//h1[contains(text(),'" + headingText + "')]"));
    }

    protected void clickOn(WebElement element) {
        try {
            element.click();
            String message = "User clicks On Element: " + element;
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Exception on clicking element" + element);
            System.out.println(e.getMessage());
        }
    }

    protected void checkIfTextIsExpected(WebElement element, String expected) {
        Assert.assertEquals(element.getText(), expected);
        String message = "Text is expected: " + expected;
        System.out.println(message);
    }

    protected void checkIfPageTitleContains(String expected) {
        String pageTitle = driver.getTitle();
        String message = "CHECK_IF" + pageTitle + "CONTAINS" + expected;
        System.out.println(message);
        Assert.assertTrue(pageTitle.contains(expected));
    }

    protected void inputTextBox(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
            String message = "INPUT_TEXT_FIELD" + element + "AND_VALUE" + value;
            System.out.println(message);
        } catch (InvalidElementStateException e) {
            String message = "unable to clear text box, InvalidElementStateException found";
            System.out.println(message);
        }

    }

    protected void checkIfTextContainsExpected(WebElement element, String expected) {
        Assert.assertTrue(element.getText().contains(expected));
        String message = "Text contains expected: " + expected;
        System.out.println(message);
    }
}
