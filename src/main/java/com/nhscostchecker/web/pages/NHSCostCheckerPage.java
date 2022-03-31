package com.nhscostchecker.web.pages;

import com.nhscostchecker.web.base.BasePage;
import com.nhscostchecker.web.helper.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class NHSCostCheckerPage  extends BasePage {

    @FindBy(xpath = "//h1[@class='heading-xlarge']")
    WebElement headingXLarge;

    //id="next-button"
    @FindBy(xpath = "//input[@id='next-button']")
    WebElement nextButton;

    //id="radio-wales"
    @FindBy(xpath = "//input[@id='radio-wales']")
    WebElement radioWales;

    //radio-yes
    @FindBy(xpath = "//input[@id='radio-yes']")
    WebElement radioYes;

    //input-dob-day
    @FindBy(xpath = "//input[@id='dob-day']")
    WebElement inputDay;

    //input-dob-month
    @FindBy(xpath = "//input[@id='dob-month']")
    WebElement inputMonth;

    //input-dob-year
    @FindBy(xpath = "//input[@id='dob-year']")
    WebElement inputYear;

    @FindBy(how = How.ID, using = "question-heading")
    WebElement questionHeading;

    @FindBy(xpath = "//h1[@id='question-heading']/span")
    WebElement questionHeadingInSpan;

    //radio-no
    @FindBy(xpath = "//input[@id='radio-no']")
    WebElement radioNo;

    @FindBy(how = How.ID, using = "result-heading")
    WebElement resultHeading;

    @FindAll(@FindBy(how = How.XPATH, using = "//ul[@class='form-hint-list']/li"))
    List<WebElement> allNHSCostElements;

    @FindBy(xpath= "//*[@class='lede']")
    WebElement resultUnder16;


    protected final String allowedCountry = "Wales";
    protected final String startPageTitle = "Check what help you could get to pay for NHS costs - NHSBSA";
    protected final String startPageHeader = "Check what help you could get to pay for NHS costs";

    protected final String gpInCountryQuestion = "Is your GP practice in Scotland or Wales?";
    protected final String dentalInCountryQuestion = "Which country is your dental practice in?";
    protected final String dobQuestion = "What is your date of birth?";
    protected final String partnerQuestion = "Do you live with a partner?";
    protected final String taxClaimQuestion = "Do you or your partner claim any benefits or tax credits?";
    protected final String maternityQuestion = "Are you pregnant or have you given birth in the last 12 months?";
    protected final String warPensionerQuestion = "Do you have an injury or illness caused by serving in the armed forces?";
    protected final String diabetesQuestion = "Do you have diabetes?";
    protected final String glaucomaQuestion = "Do you have glaucoma?";
    protected final String careHomeQuestion = "Do you or your partner live permanently in a care home?";
    protected final String savingsQuestion = "Do you and your partner have more than £16,000 in savings, investments or property?";
    protected final String glaucomaFamilyQuestion = "Do you or a family member have glaucoma?";


    public NHSCostCheckerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openStartPage() {
        goToWeb(PropertiesProvider.getProperties().getProperty("starturl"));
        waitUntilUrlContains(PropertiesProvider.getProperties().getProperty("starturl"));
    }

    public void skipCookie() {
        clickOn(skipCookieButton);
    }

    public void checkStartPage() {
        waitUntilUrlContains("start");
        checkIfTextIsExpected(headingXLarge, startPageHeader);
        checkIfPageTitleContains(startPageTitle);
    }

    public void clickStartButton() {
        waitUntilUrlContains("start");
        checkIfTextIsExpected(headingXLarge, startPageHeader);
        checkIfPageTitleContains(startPageTitle);
        clickOn(nextButton);
    }

    public void selectCountryLiveInAsWales() {

        waitUntilUrlContains("where-you-live");
        String youLiveInCountryQuestion = "Which country do you live in?";
        checkIfTextIsExpected(findHeadingByText(youLiveInCountryQuestion), youLiveInCountryQuestion);
        clickOn(radioWales);
        clickOn(nextButton);
    }

    public void selectGPPracticeLocation() {
        waitUntilUrlContains("gp-in-scotland-or-wales");
        checkIfTextIsExpected(findHeadingByText(gpInCountryQuestion), gpInCountryQuestion);
        clickOn(radioYes);
        clickOn(nextButton);
    }

    public void selectRegisteredDentalPractice() {
        waitUntilUrlContains("dental-practice-country");
        checkIfTextIsExpected(findHeadingByText(dentalInCountryQuestion), dentalInCountryQuestion);
        clickOn(radioWales);
        clickOn(nextButton);
    }

    public void selectAge(String setInputDay, String setInputMonth, String setInputYear) {
        waitUntilUrlContains("date-of-birth");
        checkIfTextIsExpected(findHeadingByText(dobQuestion), dobQuestion);
        inputTextBox(inputDay, setInputDay);
        inputTextBox(inputMonth, setInputMonth);
        inputTextBox(inputYear, setInputYear);

        clickOn(nextButton);
    }

    public void selectUserLiveWithPartner() {
        waitUntilUrlContains("partner");
        checkIfTextIsExpected(questionHeading, partnerQuestion);
        //checkIfTextIsExpected(findHeadingByText(partnerQuestion), partnerQuestion);
        clickOn(radioYes);
        clickOn(nextButton);
    }

    public void selectUserTakesNoClaimBenefits() {
        waitUntilUrlContains("claim-benefits-tax-credits");
        checkIfTextIsExpected(questionHeadingInSpan, taxClaimQuestion);
        //checkIfTextIsExpected(findHeadingByText(taxClaimQuestion), taxClaimQuestion);
        clickOn(radioNo);
        clickOn(nextButton);
    }

    public void selectUserNotPregnantOrNoBirthGivenInLastMonth() {
        waitUntilUrlContains("pregnant-or-given-birth");
        checkIfTextIsExpected(questionHeading, maternityQuestion);
        clickOn(radioNo);
        clickOn(nextButton);
    }

    public void selectUserIsNotWarPensioner() {
        waitUntilUrlContains("war-pensioner");
        checkIfTextIsExpected(questionHeading, warPensionerQuestion);
        clickOn(radioNo);
        clickOn(nextButton);
    }

    public void selectUserIsNotDiabetes() {
        waitUntilUrlContains("diabetes");
        checkIfTextIsExpected(questionHeading, diabetesQuestion);
        clickOn(radioNo);
        clickOn(nextButton);
    }

    public void selectUserIsNotGlaucoma() {
        waitUntilUrlContains("glaucoma");
        checkIfTextIsExpected(questionHeading, glaucomaQuestion);
        clickOn(radioNo);
        clickOn(nextButton);

    }

    public void selectUserDoesNotLiveInCareHome() {
        waitUntilUrlContains("care-home");
        checkIfTextIsExpected(questionHeading, careHomeQuestion);
        clickOn(radioNo);
        clickOn(nextButton);
    }

    public void selectUserIncomeMoreThan() {
        waitUntilUrlContains("saving");
        checkIfTextIsExpected(questionHeadingInSpan, savingsQuestion);
        clickOn(radioNo);
        clickOn(nextButton);
    }

    public void resultPageContent(String expectedContent) {
        waitUntilUrlContains("result");
        //checkIfTextIsExpected(headingXLarge, expectedContent);
        checkIfTextContainsExpected(resultHeading, expectedContent);
    }

    public void selectUserAndFamilyIsNotGlaucoma() {
        waitUntilUrlContains("glaucoma");
        checkIfTextIsExpected(questionHeading, glaucomaFamilyQuestion);
        clickOn(radioNo);
        clickOn(nextButton);
    }

    public List<String> checkNHSCostAvailable() {
        List<String> actualWhatNHSCostAvailableList = new ArrayList<String>();
        for (WebElement costelement : allNHSCostElements) {
            System.out.println("actualWhatNHSCostAvailable*********************************************************************");
            System.out.println("'" + costelement.getText() + "'");
            String actualWhatNHSCostAvailable = costelement.getText();
            actualWhatNHSCostAvailableList.add(actualWhatNHSCostAvailable);
        }

        return actualWhatNHSCostAvailableList;
    }

    public void verifyAgeResultPage(String ageResultMessage) {
        waitUntilUrlContains("result-under-16");
        checkIfTextIsExpected(resultUnder16, ageResultMessage);
    }
}
