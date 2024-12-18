Feature: Testing Saucedemo Website Functionality

Background: Testing Login functionality with valid credentials

				Given user is on login page
				
				When user enters valid username and password
				
				And Click login button
				
				Then User is logged in and navigated to product page
				

Scenario: Testing Functionality of add to cart product

			 Given user is adding  product to cart 
			 When user click continue shopping and user is on product page
			 And user adding multiple product and click cart button
		 
     	 When user click on checkout button
 
     	 And  user is on checkout page and enter valid firstname, lastname and zipcode
     
     	 Then user is on payment option page and click on finish button
    
  

    
    
    
    