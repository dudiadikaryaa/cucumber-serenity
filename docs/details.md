##  Let's start!
When you've successfully installed all the packages, you are ready to go. However, if you stumbled on some errors on installing some packages, you may need to adjust some dependencies to your device and OS.

We are using Selenium as our command scripts methods and Cucumber + Serenity for the BDD format and Test Reports.

### Directory Architecture
First thing first, here's the directory architecture that I've used until now, and it still works flawlessly.

    .
    ├── src            
    │   └── test 
    |        ├── java
    |              ├── Pages
    |              ├── Steps
    |              ├── Test
    |              ├── {featureName}Suite.java
    |        ├── resources
    |               └──── features
    ├── target
    ├── pom.xml
    └── serenity.properties

| Directory     | Description                                                       |
| ---------     | ----------------------------------------------------------------- |
| java          | Contains basically all the Java Scripts that you need             |
| resources     | Contains your feature files to write test cases in BDD Gherkin Fromat |
| Pages         | Code scripts for what you do in a Page and defining steps from 'Steps'                      |
| Steps         | Code scripts defining steps from 'Test'                        |
| Test          | Code scripts defining steps from feature file                        |
| *Suite.java   | This is a runner for your feature file                        |

---
### Basic Coding Workflow

1. Create a new file `{featureName}.feature` in `./resources/features/`
2. Start [Writing Your Feature File Test Scenarios](#writing-feature-file-test-case).
3. Create a new java class in `./java/Test/` to define test steps in feature file
4. Start [Writing Your Test Java Class Script](#writing-test-java-class-script).
5. Create a new java class in `./java/Steps/`
6. Start [Writing Your Steps Java Class Script](#writing-steps-java-class-script).
7. Create a new java class in `./java/Pages/`
8. Start [Writing Your Pages Java Class Script](#writing-pages-java-class-script).
9. Create a new `{featureName}Suite.java` class in `./java/`
10. Start [Writing Your Runner Suite Java Class Script](#writing-runner-suite-java-class-script).

---

### Writing Feature File Test Case
Here in `./resources/features/`, you will write your Test Case Scenarios in BDD Gherkin Format.
For example in this repo, I created `login.feature` file to test the Login Feature.

```gherkin
@login
Feature: Login Scenarios
  As a user
  I want to log in into the system
  So that I'm authorized to make transactions

  @case1
  Scenario: Login failed using incorrect username & password
    Given the user opens Web
    When the user clicks Login Portal button
    And the user input username asdf
    And the user input password asdf
    And the user clicks Login button
    Then show warning message
```
> Pay attention to the Tag at top of the file `@login`, it's important for you to create tags for each feature file so that later you can run those tags independently.

> You can also define variables that can be parsed into the step definition later, for example here `asdf` will be marked blue, showing that it's a variable. For how to make it as a variable will be explained in Test Java Script later.

There are much more for formatting the gherkin syntax in feature.file, please check the detailed explanation [here](https://cucumber.io/docs/gherkin/reference/).

---

### Writing Test Java Class Script
Here, you will write the Steps Definition in `./java/Test/` for the steps in feature file that you wrote earlier.
1. When you've created the file, add the java package first, to define your test Steps.

    ```java
    import net.thucydides.core.annotations.Steps;
    import Steps.loginSteps; //This is to import your java class in Steps File
    import cucumber.api.java.en.Given;
    import cucumber.api.java.en.And;
    import cucumber.api.java.en.When;
    ```
   
2. Add the `@Steps` & `loginSteps`to implement the imported package.
3. Define your Test Steps in feature file. For example here, this `Given` test steps in feature file:
    ```gherkin
    Given the user opens Web
    ``` 
    Write this code to define the code above:
    ```java
    @Given("the user opens Web")
    public void userOpenWeb(){
    }
    ```
   Pay attention to the wording inside (" "), it needs to be completely identical and same with the wording in steps in the `feature.file`, otherwise it won't glue the code.
   
   Note:
    ```gherkin
    And the user input username asdf //example of feature.file steps
    ```
    ```java
    @And("the user input username {word}")
    public void userInputUsername(String username){
       loginSteps.inputUsername(username);
    }
    ```
   To define a variable in a test steps, use `{word}` to convert the wording into variable, for example above, `asdf` will be defined as a variable.
4. Add the method name inside the step definition. You will define this method in the Steps File that has been imported in the java package.

---

### Writing Steps Java Class Script
Here in `./java/Steps/` you will define the methods that you've used and wrote in the java class in `java/Test` earlier.
1. Add the java package first with this code
   
    ```java
    import Pages.loginPages; //this is your pages file {featureName}Pages
    import net.thucydides.core.annotations.Step;
    ```
   
2. Add `loginPages loginPages` to implement the imported Pages file. 
   Add `@Step` above each method that you will define later to implement the java package.

3. Create the method defining the used method in your pervious Test File. For example:
    ```java
    loginSteps.clickLoginPage();
    ```   
   To define method above, write this script:
   ```java
   @Step
   public void clickLoginPage(){
       loginPages.clickLoginPage();
   }
   ```
   > Pay attention to `@Step` above the method, you will need to add it everytime you define a method.
   
   Note: For a method that contains a variable, you need to re-define the variable in the Steps file. For example:
   ```java
   loginSteps.inputUsername(username);
   ```
   
   To define the method above, write code like below:
   ```java
   @Step
   public void inputUsername(String username){
       loginPages.inputUsername(username);
   }
   ```
   > Notice that I redefine the variable in the parameter field (you can change the name of the variable too) and pass it again in the method inside of it.

---
   
### Writing Pages Java Class Script
Here in `.java/Pages/` you will define the method that you've used and wrote in `java/Steps/`. Basically, all the code about what you want to do for your testing (e.g. Clicking button, Asserting Text, Scrolling), you will write it here.
1. Add the mandatory java package
   
   ```java
   import net.thucydides.core.pages.PageObject; 
   ```
   And add `extends PageObject` into the java class method, so it will be like this:
   
   ```java
   public class loginPages extends PageObject{
   
   }
   ```
2. Define the method that you've used earlier. For example:
   ```java
   loginPages.clickLoginPage();
   ```
   To define method above, write your code like below:
   ```java
   public void clickLoginPage(){
   }
   ```
3. Before you write your scripts inside the java method, you might like to define the object that you are going to interact with. For example, in step above, I'm going to define `clickLoginPage` method, and I need to use and define the `Login` button, here's the example:
   ```java
   @FindBy(id = "login-portal")
   WebElement loginPage; //Defining Button as WebElement
   ``` 
   
   > Note that you will need to import a new java package to user the WebElement & FindBy package service.
   ```java
   import org.openqa.selenium.WebElement;
   import org.openqa.selenium.support.FindBy;
   ```
                                                                                                                                                                                                                                                                                                                                                                  
   In this case, I've inspected the web element and search for the `Login` button element details, and I found the id is `login-portal`. You can use other identifier too, like `name` , `class` , or `xpath`. 

4. Write the scripts for what are you going to do for the method. 
   
   You might need to import several packages for your scripts. For example, I use Selenium commands and other packages for my methods, so I add this additional packages.
   ```java
   import org.openqa.selenium.support.ui.ExpectedConditions;
   
   import java.util.ArrayList;
   
   import static org.junit.Assert.assertEquals;
   ```
   
   Then for the scripts to define what I'm going to do in this method, here's the example:
   ```java
   public void clickLoginPage(){
       element(loginPage).shouldBeVisible();
       loginPage.click();
   
       ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
       getDriver().switchTo().window(tabs2.get(1));
   }
   ```
   > You can modify the package that you need to use in your `Pages` file, it can differ between each `Pages` file.
---

### Writing Runner Suite Java Class Script

Here in `./java/` you will create a file, created just to be a runner file.
1. Create the java class file with format `{featureName}Suite`. 
   For example, for `login` I created `loginSuite` java class file.
   
   > Note that you can change this format to your needs in the pom.xml file.
   
   ```xml
   <configuration>
        <includes>
             <include>**/*Suite.java</include> //Here's where you can change it to your needs
                  </includes>
                  <argLine>-Xmx512m</argLine>
                  <threadCount>2</threadCount>
                  <!--                    <parallel>classes</parallel>-->
   </configuration>
   ```

2. Add this mandatory java package
   ```java
   import cucumber.api.CucumberOptions;
   import net.serenitybdd.cucumber.CucumberWithSerenity;
   import org.junit.runner.RunWith;
   ```
3. Below the package scripts (before the java class method scripts), add the following scripts:
   ```java
   @RunWith(CucumberWithSerenity.class)
   @CucumberOptions(features="src/test/resources/features/login/login.feature")
   ```
   
   >Note that you will need to point the `features="` to your feature.file directory.   
   
   You can add other configuration inside the `@CucumberOptions` like using `@tags` to only run a specific tag, or using `@skip` to skip a specific tag, etc. Please go [here](https://cucumber.io/docs/cucumber/api/#running-cucumber) for the complete documentation.
   
4. Your runner java class scripts should look like this
   ```java
   import cucumber.api.CucumberOptions;
   import net.serenitybdd.cucumber.CucumberWithSerenity;
   import org.junit.runner.RunWith;
   
   @RunWith(CucumberWithSerenity.class)
   @CucumberOptions(features="src/test/resources/features/login/login.feature")
   public class loginSuite {
   }
   ```
   
   You can run your test suite individually directly through IntelliJ Run option from the runner without generating serenity report.
---

### Test Report
