Feature: Feature Template
#
  #Scenario: Sample scenario
    #Given My api base URL is "baseUrl"
    #	And Port number is "port"
    #When My request method is "method"
    #	And I set header "key" as "value"
    #	And I set query parameter "param" as "value"
    #	And I set path parameter "param" as "value"
    #	And I set request body from "fileName"
    #	And I make a request to "endpoint"
    #Then I expect status code as "statusCode"
    #	And I want to print response body
    #	And I expect "node" equals "value" in response body
    #	And I expect "node" contains "value" in response body
    
    
Scenario: get proper success message for valid method
  Given My api base URL is "http://token.qa.elitecareer.net"
  When My request method is "POST"
  	And I set header "Content-Type" as "application/json"
 		And I set header "fusion-api-key" as "fusionqateam"
  	And I set request body from "employerCredentials.json"
  	And I make a request to "/api/v1/user"
  Then I expect status code as "201"
  	And I want to print response body
  	#And I expect "data.detail" equals "Specified method is not allowed" in response body
  	
Scenario: get proper error message for invalid request method
	  Given My api base URL is "http://token.qa.elitecareer.net"
		When My request method is "GET"
		And I set header "Content-Type" as "application/json"
 		And I set header "fusion-api-key" as "fusionqateam"
  	And I set request body from "employerCredentials.json"
  	And I make a request to "/api/v1/user"
  Then I expect status code as "405"
  	And I want to print response body
  	And I expect "message" contains "The request was invalid" in response body
    
Scenario: get proper error message for invalid header request method
	  Given My api base URL is "http://token.qa.elitecareer.net"
		When My request method is "POST"
			And I set header "Content-Type" as "application/json"
 			And I set header "fusion-api-key" as "fusionq"
  		And I set request body from "employerCredentials.json"
  		And I make a request to "/api/v1/user"
  	Then I expect status code as "401"
  		And I want to print response body
  		And I expect "message" contains "The request was invalid" in response body
