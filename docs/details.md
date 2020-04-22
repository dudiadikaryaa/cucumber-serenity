##  Let's start!
When you've successfully installed all the packages, you are ready to go. However, if you stumbled on some errors on installing some packages, you may need to adjust some dependencies to your device and OS.

#### Directory Architecture
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

#### Basic Coding Workflow

1. Create a new file `{featureName}.feature` in `./resources/features/`
2. Start [Writing Your Feature File Test Scenarios](#writing-feature-file-test-case).
3. Create a new java class in `./java/Test/` to define test steps in feature file
4. Start [Writing Your Test Java Class Script](#writing-your-test-java-class-script).
5. Create a new java class in `./java/Steps/`
6. Start [Writing Your Steps Java Class Script](#writing-your-steps-java-class-script).
7. Create a new java class in `./java/Pages/`
8. Start [Writing Your Pages Java Class Script](#writing-your-pages-java-class-script).
9. Create a new `{featureName}Suite.java` class in `./java/`
10. Start [Writing Your Runner Suite Java Class Script](#writing-your-runner-suite-java-class-script).

#### Writing Feature File Test Case
Here, you will write your Test Case Scenarios in BDD Gherkin Format.
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

#### Writing Your Test Java Class Script


#### Writing Your Steps Java Class Script

#### Writing Your Pages Java Class Script

#### Writing Your Runner Suite Java Class Script

#### Test Report
