Feature: Gesture 

@Regression
Scenario: Swipe Functionality

Given user launched android mobile application
When  user taped on swipe button
And   user swiped toward "left" once
Then  verify user swiped sucessfully

@Regression
Scenario: Scroll Functionality

Given user launched android mobile application
When  user taped on swipe button
And   user scrolled upto the "You found me!!!"
Then  verify user scrolled sucessfully


