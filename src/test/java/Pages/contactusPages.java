package Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class contactusPages extends PageObject{

    //Click Contact Us Page
    @FindBy(id = "contact-us")
    WebElement contactUsPage;

    public void clickContactUsPage(){
        element(contactUsPage).shouldBeVisible();
        contactUsPage.click();
    }

    //Assert Redirects to Contact Us Page
    @FindBy(xpath = "/html/body/div[1]/div/div/section/div/div[2]/form/div/input[1]")
    WebElement buttonReset;

    @FindBy(name = "contactme")
    WebElement titlePage;

    public void assertContactUs(){

        //Change to new Tab
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));

        String titleText;
        titleText = titlePage.getText();

        waitForCondition().until(ExpectedConditions.elementToBeClickable(buttonReset));
        assertEquals("Failure - strings are not equal", "CONTACT US", titleText);
    }
}
