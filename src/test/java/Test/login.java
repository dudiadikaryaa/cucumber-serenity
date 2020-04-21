package Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.loginSteps;
import cucumber.api.java.en.Given;

public class login {
    @Steps
    loginSteps loginSteps;

    @Given("the user opens Web")
    public void userOpenWeb(){
        loginSteps.openWeb();
    }

    @When("the user clicks Login Portal button")
    public void userClickLoginButton(){
        loginSteps.clickLoginPage();
    }

    @And("the user input username {word}")
    public void userInputUsername(String username){
        loginSteps.inputUsername(username);
    }

    @And("the user input password {word}")
    public void userInputPassword(String password){
        loginSteps.inputPassword(password);
    }

    @And("the user clicks Login button")
    public void userLogin(){
        loginSteps.loginClick();
    }

    @And("show warning message")
    public void showMessageWarning(){
        loginSteps.assertWarning();
    }
}
