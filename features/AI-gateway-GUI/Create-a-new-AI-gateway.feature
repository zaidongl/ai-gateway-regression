@reg-test @ai-gateway @gui
Feature: create a new AI gateway
  As a user
  I want to create a new AI gateway
  Scenario: Create a new AI gateway - positive
    When "GatewayBrowserAgent" open page "https://cloud.konghq.com/us/ai-manager/"
    And "GatewayBrowserAgent" login Kong with "Login-Page.continue-with-github" if not logged in
    Then "GatewayBrowserAgent" should see button "AI-Gateway-Manager-Page.new-gateway-button"
#    Then I should see the AI gateway with name "Test Gateway" in the list