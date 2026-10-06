# UI and API Automation Framework

This Maven project provides a starting framework for:

- Selenium UI tests using the Page Object Model.
- Cucumber BDD scenarios executed by TestNG.
- REST API tests using REST Assured.

## Prerequisites

- Java 8 or newer
- Maven 3.9 or newer
- Google Chrome (the WebDriver binary is managed automatically)

## Run the suite

```bash
mvn clean test
```

The example UI scenario uses Sauce Demo and runs headlessly by default. The example API test uses ReqRes. Both URLs and browser settings are in `src/test/resources/config.properties` and can be overridden with Maven properties:

```bash
mvn test -Dheadless=false -Dbrowser=chrome -Dcucumber.filter.tags="@smoke"
```

## Project structure

```text
src/test/java/com/example/framework/config   configuration loading
src/test/java/com/example/framework/driver   thread-safe WebDriver lifecycle
src/test/java/com/example/framework/pages    Page Objects
src/test/java/com/example/framework/hooks    Cucumber setup and cleanup
src/test/java/com/example/framework/steps    Cucumber step definitions
src/test/java/com/example/api                REST Assured tests
src/test/resources/features                  Gherkin feature files
```

Add new UI behavior through Page Objects and step definitions rather than locating elements directly in feature files. Add API clients/helpers under `com.example.api` as the API suite grows.
