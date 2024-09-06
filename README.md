# GET-Task2
SetUp() class: This class contains Open() and Close()
Open() contains:
1- Switch case for selecting browser but that incase adding browser as a parameter in Open(), or as implemented configuration.properties class contains default browser that can be changed manually [chrome - firefox - edge]
2- instance from registration page to add text read from excel sheet [First name, Last name, Phone, Email, Course, Platform] and Pressing register button
Close() contains:
1- instance from relatedActions page to take screenshots and name it with the selected browser name
2- close the browser
-----------------------------------------------------------------------------------------------------
OpenBrowser() class: This class contains 2 Test cases
ValidScenario test contains:
1- Assertion for checking the thank you registration success page is the same as expected
InvalidScenario test contains:
1- Assertion for checking the thank you registration success page is different from the expected
-----------------------------------------------------------------------------------------------------
