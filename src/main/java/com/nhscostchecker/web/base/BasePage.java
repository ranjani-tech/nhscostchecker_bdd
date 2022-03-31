package com.nhscostchecker.web.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends BaseActions {

    private WebDriver driver;


    @FindBy(xpath = "//button[@id='nhsuk-cookie-banner__link_accept']")
    public WebElement skipCookieButton;


    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}

