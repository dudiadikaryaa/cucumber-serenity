package Test;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import Steps.contactusSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class contactus {
    @Steps
    contactusSteps contactusSteps;

    @When("the user clicks Contact Us Page button")
    public void userClickContactUsPage(){
        contactusSteps.clickContactUsPage();
    }

    @Then("user redirects to Contact Us Page")
    public void redirContactUs(){
        contactusSteps.assertContactUs();
    }
}
