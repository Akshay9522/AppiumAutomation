Feature: Login 

@Regression
Scenario: Login Functionality

Given user launched android mobile application
When  user entered Username "abc@gmail.com" and Password as "abc@1234"
And   user clicked on sign
Then  login must be successful message displayed
And   clicked on ok

@Regression
Scenario: Check Login Functionality By Multiple User

Given user launched android mobile application
When  user entered Username "<username>" and Password as "<password>"
And   user clicked on sign
Then  login must be successful message displayed
And   clicked on ok

Examples:
|username|password|
|abc1@gmail.com|password1|
|abc2@gmail.com|password2|