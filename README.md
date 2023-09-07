# UseCase1
Repository that contains all steps required in scope of this task, for productivity using AI generative 

## Description

This application implement a simple get endpoint that calls https://restcountries.com/v3.1/all and make some operations with the retrieved data:

- Filter countries by common name, checking if it contains the given string and retuning those that match
- Filter countries by population, returning those that have a smaller population than the given number
- Sort countries by name in ascending or descending order
- Paginate countries, returning a given number of entries

## How to run application

1. Clone the repository
2. Open the project in your IDE
3. Run the application (It will be listening on port 8080)
4. Make get request to http://localhost:8080/getCountries, passing as optional paramaters name(string that will filter), sort("ascend" or "descend"),.
    population(number that will filter), pagination(number that will limit the number of entries to return)
5. You will get a response with the countries that match the given criteria

## Examples

- http://localhost:8080/getCountries?name=united&sort=ascend&population=10000&pagination=5
  It  will return the first 5 countries that have "united" in their name, sorted by name in ascending order and with a population smaller than 10000

- http://localhost:8080/getCountries?name=united&sort=descend&population=10000&pagination=5
  It  will return the first 5 countries that have "united" in their name, sorted by name in descending order and with a population smaller than 10000

- http://localhost:8080/getCountries?name=united&sort=descend&population=10000
  It  will return all countries that have "united" in their name, sorted by name in descending order and with a population smaller than 10000

- http://localhost:8080/getCountries?name=united&sort=anscend&population=10000
  It  will return all countries that have "united" in their name, sorted by name in ascending order

- http://localhost:8080/getCountries?name=united&sort=descend
  It  will return all countries that have "united" in their name, sorted by name in descending order

- http://localhost:8080/getCountries?name=united&sort=ascend
  It  will return all countries that have "united" in their name, sorted by name in ascending order

- http://localhost:8080/getCountries?name=united
  It  will return all countries that have "united" in their name

- http://localhost:8080/getCountries?population=10000
  It  will return all countries with a population smaller than 10000

- http://localhost:8080/getCountries?pagination=5
  It  will return the first 5 countries

- http://localhost:8080/getCountries?sort=ascend
  It  will return all countries sorted by name in ascending order

- http://localhost:8080/getCountries?sort=descend
  It  will return all countries sorted by name in descending order

- http://localhost:8080/getCountries
  It will return all countries as trey are retrieved from api