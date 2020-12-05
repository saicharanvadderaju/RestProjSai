Feature: Weather Validations

Scenario: Validate weather details for particular City
Given User has API Details
When user call getWeatherAPI with GET http request
Then Validate status code