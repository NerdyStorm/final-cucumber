@Regression
Feature: Bank Feature

    This feature is testing the bank feature in the Techfios billing page

    Background:
        Given User is on techfios website in the billing page

    Scenario Outline: Scenario Outline name
        When User enters "username" <username>
        When User enters "password" <password>
        When User clicks "login"
        Then User should land on Dashboard page
		And User clicks "bankCash"
		And User clicks "newAccount"
		And User enters "accountTitle" in accounts page
		And User enters "description" in accounts page
		And User enters "initialBalance" in accounts page
		And User enters "accountNumber" in accounts page
		And User enters "contactPerson" in accounts page
		And User enters "phone" in accounts page
		And User enters "internetBankingURL" in accounts page
		And User clicks "submit"
		Then User should be able to validate account created successfully


        Examples:
            | username            | password |
            | "demo@techfios.com" | "abc123" |