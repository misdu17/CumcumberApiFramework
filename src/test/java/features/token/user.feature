Feature: Token API: user end point test

 @regression
 Scenario: Check vaild response fr all valid data
    Given My api base URL is "http://token.qa.elitecareer.net"
    When My request method is "POST"
    	And I set header "Content-Type" as "application/json"
    	And I set header "fusion-api-key" as "fusionqateam"
    	And I set request body from "employerCredentials.json"
    	And I make a request to "/api/v1/user"
    Then I expect status code as "201"
    	And I want to print response body
  		#And I expect "data.detail" equals "Specified method is not allowed" in response body
  		
@regression @sanity
Scenario: Check proper error message for invalid endpoint
    Given My api base URL is "http://token.qa.elitecareer.net"
    When My request method is "POST"
    	And I set header "Content-Type" as "application/json"
    	And I set header "fusion-api-key" as "fusionqateam"
    	And I set request body from "employerCredentials.json"
    	And I make a request to "/api/v1/invalid"
    Then I expect status code as "404"
    	And I want to print response body
  		And I expect "data.detail" equals "The specified Endpoint is invalid" in response body