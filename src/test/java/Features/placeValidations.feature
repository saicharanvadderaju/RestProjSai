Feature: Validating place API's

@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
Given Add place payload with "<name>" "<language>" "<address>"
When user call "AddPlaceAPI" with "POST" http request
Then the API call got successful with status code 200
And "status" in the response body is "OK"
And Verify placed_Id created maps to "<name>" using "getPlaceApI"

Examples:
|name|language|address|
|abcd|English|wwwtf|
#|xyzc|Spanish|seacross|
#|jhyu|French|seacrossedone|

@DeletePlace
Scenario: Verify if Delete place functionality is working fine
Given DeletePlace payload
When user call "deletePlaceAPI" with "POST" http request
Then the API call got successful with status code 200
And "status" in the response body is "OK"

