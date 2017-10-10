Feature: Test the http://www.carmensystems.com/iptis/rtti API

Given I am connected to AWS DynamoDb

Scenario: Validate the API response with a valid postcode 
When I provide a valid postal code in the request
|postcode|
|AB107AP |
Then I should get a response with list of nearby postal code stations with distance and coordinates
|crs|distance|X|Y|
|ABD|2.70|394109|805933|
|PLN|6.04|392360|796759|
|STN|13.91|786187|386401|
|DYC|7.99|812759|388468|
|INR|17.66|821810|377577|
|INS|27.51|827611|362957|
|LAU|28.14|770900|370900|
|MTS|35.80|758004|371210|
|HNT|37.92|839636|353536|
|ARB|48.15|740961|363871|
|KEH|49.57|851667|343007|

 
Scenario: Validate the API response with an invalid postcode 
When I provide an  invalid postal code in the request
|postcode|
|XXX|
Then I should not get a response

Scenario: Validate the API response with a null postcode 
When I provide an  invalid postal code in the request
|postcode|
||
Then I should not get a response
