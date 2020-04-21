package Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class loginPages extends PageObject{

    //Click Login Page
    @FindBy(id = "login-portal")
    WebElement loginPage; //Defining Button as WebElement

    public void clickLoginPage(){
        element(loginPage).shouldBeVisible();
        loginPage.click();

        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
    }

    //Input Username
    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(id = "text")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    public void inputUsername(String username){
        //Wait for element to be rendered
        waitForCondition().until(ExpectedConditions.elementToBeClickable(loginButton));

        usernameField.sendKeys(username);
    }

    //Input Password
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    //Click Login
    public void loginClick(){

        loginButton.click();

        //Warning Message Assertion
        //Containing the alert message text to String
        String alertMessage;
        alertMessage = getDriver().switchTo().alert().getText();

        //Assertion for alert text message
        assertEquals("Failure - strings are not equal", "validation failed", alertMessage);

        getDriver().switchTo().alert().accept();
    }

    //Assert Warning Message
    public void assertWarning(){
        //Assertion done in Login, because Selenium automatically close the Popup Message after failing to login
    }

}
