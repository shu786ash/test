
Feature: verify complete ecommerce flow


Background:

Given user open TutorialsNinja registration page


@Smoke
Scenario Outline: verify complete ecommerce functionality

Given user open TutorialsNinja registration page
When user enter firstname <firstname>
And user enter lastname <lastname>
And user enter registration email <email>
And user enter telephone <telephone>
And user enter registration password <password>
And user enter confirm password <confirmpassword>
And user click on privacy policy checkbox
And user click on continue button

And user logout after registration

And user open login page
And user enter login email <email>
And user enter login password <password>
And user click on login button

And user search product <productname>
And user click on search button
And user click on searched product
And user click on add to cart button
And user click on shopping cart
And user click on checkout button
And user click on remove button
And user logout successfully

Then complete ecommerce flow should execute successfully


Examples:

|firstname|lastname|email|telephone|password|confirmpassword|productname|

|Ashish|Shukla|abc@gmail.com|7894563020|Ashi@123456|Ashi@123456|iPhone|