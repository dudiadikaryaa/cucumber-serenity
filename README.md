#  WebUI Automation Testing with Cucumber & Serenity

![Cucumber Logo](./docs/img/cucumber-logo.png)

![Serenity Logo](./docs/img/serenity-logo.png)

> Cucumber is a testing tool that supports Behavior Driven Development (BDD). It offers a way to write tests that anybody can understand, regardless of their technical knowledge. https://cucumber.io/

> Serenity BDD is a simple but powerful way to produce illustrated, narrative Test Reports that document and describe what your application does and how it works. www.thucydides.info/
 

### Prerequisites:

- Java 1.8
- Maven 3.5.2
- IntelliJ IDEA
- Chromedriver 81.0 (Depends on your Chrome Version)

### Get Started:
Clone this project repository into your local:
```sh
$ git clone https://github.com/dudiadikaryaa/cucumber-serenity.git
```

After you have successfully cloned this project repository, do the following:

```sh
$ cd cucumber-serenity
$ mvn install
```

### How to Run:

```sh
$ mvn clean verify                                          | Run all test & generate Test Report
$ mvn clean verify -Dcucumber.options="--tags @login"       | Run only @login tag & generate Test Report
```

### How does it work?
For the detail explanation, please go [here](docs/details.md) !

### Reference
- https://howtodoinjava.com/maven/how-to-install-maven-on-windows/
- https://serenity-bdd.github.io/theserenitybook/latest/cucumber.html
- https://www.guru99.com/introduction-to-cucumber.html