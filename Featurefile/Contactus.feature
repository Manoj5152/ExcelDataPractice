Feature: Contactus feature

Scenario Outline: Contact us with different set of data
Given the user is on the Contact us page
When user fills the form from the given sheetname "<SheetName>" and rownumber <Rownumber>
And user clicks the send button
Then it shows a successful message "Your message has been successfully sent to our team."

Examples:
|SheetName|Rownumber|
|Contactus|0|
|Contactus|1|