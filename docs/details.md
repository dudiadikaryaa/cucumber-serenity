##  Let's start!
When you've successfully installed all the packages, you are ready to go. However, if you stumbled on some errors on installing some packages, you may need to adjust some dependencies to your device and OS.

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
   
### Writing Pages Java Class Script

### Writing Runner Suite Java Class Script

### Test Report
