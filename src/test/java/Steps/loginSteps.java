package Steps;

import Pages.loginPages;
import net.thucydides.core.annotations.Step;

public class loginSteps {
    loginPages loginPages;

    //Open Website
    @Step
    public void openWeb(){
        loginPages.open();
    }

    //Click Login Page button
    @Step
    public void clickLoginPage(){
        loginPages.clickLoginPage();
    }

    //Input Username
    @Step
    public void inputUsername(String username){
        loginPages.inputUsername(username);
    }

    //Input Password
    @Step
    public void inputPassword(String password){
        loginPages.inputPassword(password);
    }

    //Click Login
    @Step
    public void loginClick(){
        loginPages.loginClick();
    }

    //Assert Warning Message
    @Step
    public void assertWarning(){
        loginPages.assertWarning();
    }
}
