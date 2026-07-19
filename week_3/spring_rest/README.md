# spring-learn

Compact Spring Boot project for the week 3 hands-on exercises.

## What is included

- `SpringLearnApplication` shows Spring Boot startup with logging.
- `displayDate()` loads `SimpleDateFormat` from `date-format.xml`.
- `displayCountry()` loads a `Country` bean and shows singleton lookup.
- `displayPrototypeCountry()` loads the same bean with prototype scope.
- `displayCountries()` loads a list of countries from `country.xml`.

## Files

- `src/main/resources/application.properties` contains logging setup and the server port.
- `src/main/resources/date-format.xml` defines the date format bean.
- `src/main/resources/country.xml` defines country beans and the country list.
- `src/main/resources/country-prototype.xml` defines the prototype-scoped country bean.

## Run

Open the project as a Maven project and run `SpringLearnApplication`.