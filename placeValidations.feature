Feature: Validating Place APIs 

Scenario Outline: 
	Verfiy if the place is successfully added using the AddPlaceAPI 


	Given Add Place Payload "<name>" "<language>" "<address>" 
	#	When User calls the "AddPlaceAPI" using the Post http request
	When User calls the "addPlaceAPI" using the "POST" http request 
	Then the api call is success with the response code and the status code 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And verify place_Id create maps to "<name>" using "getPlaceAPI" 
	
	Examples: 
		|name |language |address |
		|Shasdfahacnk |Ennnffcglish |Bengaluru Ulsoor lake|
		|Rajendra|Telugu|Romford|
		#		|Abcsddffsa | Kandcfnada | Delhi |
		
Scenario: Verify whether the delete place functionality is working fine. 

	Given Delete Place Payload 
	When User calls the "deletePlaceAPI" using the "DELETE" http request 
	Then the api call is success with the response code and the status code 
	And  "status" in response body is "OK" 
	
#Scenario: Verify whether the user is able to update using the UpdatePlaceAPI 
#
#	Given Update Place Payload 
#	When User calls the "updatePlaceAPI" using the "PUT" http request
#	Then the api call is success with the response code and the status code
#	And "status" in response body is "OK"  
	

	
