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
2. Start [Writing Your Feature File Test Scenarios](#writing-the-test-case).
3. Create a new java class for you test case feature in `./java/Test/`
4. Start [Writing Your Test Java Class Script](#writing-your-test-java-class-script).
5. Create a new java class in `./java/Steps/`
6. Start [Writing Your Steps Java Class Script](#writing-your-steps-java-class-script).
7. Create a new java class in `./java/Pages/`
8. Start [Writing Your Pages Java Class Script](#writing-your-pages-java-class-script).
9. Create a new `{featureName}Suite.java` class in `./java/`
10. Start [Writing Your Runner Suite Java Class Script](#writing-your-runner-suite-java-class-script).

#### Writing the Test Case

#### Writing Your Test Java Class Script

#### Writing Your Steps Java Class Script

#### Writing Your Pages Java Class Script

#### Writing Your Runner Suite Java Class Script

#### Test Report
