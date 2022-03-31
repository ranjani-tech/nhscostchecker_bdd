package com.nhscostchecker.web;

import com.nhscostchecker.web.helper.DriverProvider;
import com.nhscostchecker.web.pages.NHSCostCheckerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private NHSCostCheckerPage nhsCostCheckerPage;
    protected static final String WALES = "Wales";
    protected static final String YES = "Yes";
    protected static final String NO = "No";


    //Constructor
    public StepDefinitions(){
        nhsCostCheckerPage = new NHSCostCheckerPage(DriverProvider.getDriver());
    }
    
    @Given("User is on NHS cost checker tool page")
    public void user_is_on_nhs_cost_checker_tool_page() {
        nhsCostCheckerPage.openStartPage();
    }

    @When("User skip cookie selection")
    public void user_skip_cookie_selection() {
        nhsCostCheckerPage.skipCookie();
    }

    @Then("I should be able to view Start button as per UX")
    public void i_should_be_able_to_view_start_button_as_per_ux() {
        nhsCostCheckerPage.checkStartPage();
    }

    @When("user clicks start button")
    public void user_clicks_start_button() {
        nhsCostCheckerPage.clickStartButton();
    }

    @And("user selects country live in as {string}")
    public void user_selects_country_live_in_as(String userCountry) {
        assertEquals(userCountry,WALES);
        nhsCostCheckerPage.selectCountryLiveInAsWales();
    }

    @And("user selects GP practice location in scotland or Wales as {string}")
    public void user_selects_gp_practice_location_in_scotland_or_wales_as(String userCountry) {
        assertEquals(userCountry,YES);
        nhsCostCheckerPage.selectGPPracticeLocation();
    }

    @And("user select country of dental practice as {string}")
    public void user_select_country_of_dental_practice_as(String userCountry) {
        assertEquals(userCountry,WALES);
        nhsCostCheckerPage.selectRegisteredDentalPractice();
    }

    @And("user enters date of birth as {int}-{int}-{int}")
    public void user_enters_date_of_birth_as(Integer expectedDate, Integer expectedMonth, Integer expectedYear) {
        nhsCostCheckerPage.selectAge(expectedDate.toString(),expectedMonth.toString(),expectedYear.toString());
    }

    @And("user select civil partnership status as {string}")
    public void user_select_civil_partnership_status_as(String civilPartnershipStatus) {
        assertEquals(civilPartnershipStatus,YES);
        nhsCostCheckerPage.selectUserLiveWithPartner();
    }

    @And("user select tax claim status as {string}")
    public void user_select_tax_claim_status_as(String taxClaimStatus) {
        assertEquals(taxClaimStatus,NO);
        nhsCostCheckerPage.selectUserTakesNoClaimBenefits();
    }

    @And("user select Maternity details as {string}")
    public void user_select_maternity_details_as(String maternityStatus) {
        assertEquals(maternityStatus,NO);
        nhsCostCheckerPage.selectUserNotPregnantOrNoBirthGivenInLastMonth();
    }

    @And("user select war pensioner and injury details status as {string}")
    public void user_select_war_pensioner_and_injury_details_status_as(String warPensionerStatus) {
        assertEquals(warPensionerStatus,NO);
        nhsCostCheckerPage.selectUserIsNotWarPensioner();
    }

    @And("user select diabetes status as {string}")
    public void user_select_diabetes_status_as(String diabetesStatus) {
        assertEquals(diabetesStatus,NO);
        nhsCostCheckerPage.selectUserIsNotDiabetes();
    }

    @And("user select glaucoma status as {string}")
    public void user_select_glaucoma_status_as(String glauomaStatus) {
        assertEquals(glauomaStatus,NO);
        nhsCostCheckerPage.selectUserIsNotGlaucoma();
    }

    @And("user select care home details as {string}")
    public void user_select_care_home_details_as(String careHomeStatus) {
        assertEquals(careHomeStatus,NO);
        nhsCostCheckerPage.selectUserDoesNotLiveInCareHome();
    }

    @And("user select financial details as {string}")
    public void user_select_financial_details_as(String basicFinanceStatus) {
        assertEquals(basicFinanceStatus,NO);
        nhsCostCheckerPage.selectUserIncomeMoreThan();

    }
    @Then("user should get a result that {string}")
    public void user_should_get_a_result_that(String resultContent) {
        nhsCostCheckerPage.resultPageContent(resultContent);
    }

    @And("user select for all family members glaucoma status as {string}")
    public void user_select_for_all_family_members_glaucoma_status_as(String glauomaStatus) {
        assertEquals(glauomaStatus,NO);
        nhsCostCheckerPage.selectUserAndFamilyIsNotGlaucoma();
    }

    @Then("NHS Cost Checker responds show NHS Cost Available")
    public void nhs_cost_checker_responds_show_nhs_cost_available(DataTable dataTable) {
        List<String> actualWhatNHSCostAvailableList = nhsCostCheckerPage.checkNHSCostAvailable();
        List<String> expectedWhatNHSCostAvailableList = dataTable.asList(String.class);

        for(String expectedWhatNHSCost: expectedWhatNHSCostAvailableList){
            System.out.println("expectedWhatNHSCost*********************************************************************");
            System.out.println("'" + expectedWhatNHSCost + "'");
            System.out.println(actualWhatNHSCostAvailableList);
            assertTrue(actualWhatNHSCostAvailableList.contains(expectedWhatNHSCost));
        }
        assertTrue(expectedWhatNHSCostAvailableList.containsAll(actualWhatNHSCostAvailableList));
    }

    @Then("user should get based on the age result that {string}")
    public void user_should_get_based_on_the_age_result_that(String ageResultMessage) {
        nhsCostCheckerPage.verifyAgeResultPage(ageResultMessage);
    }
}