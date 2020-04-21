package Steps;

import Pages.contactusPages;
import net.thucydides.core.annotations.Step;

public class contactusSteps {
    contactusPages contactusPages;

    //Click Contact Us Page
    @Step
    public void clickContactUsPage(){
        contactusPages.clickContactUsPage();
    }

    //Assert Contact Us Page
    @Step
    public void assertContactUs(){
        contactusPages.assertContactUs();
    }
}
