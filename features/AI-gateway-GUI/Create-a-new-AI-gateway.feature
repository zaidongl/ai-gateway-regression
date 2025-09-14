@reg-test @ai-gateway @gui
Feature: create a new AI gateway
  Scenario: Login Konnect - positive
    When "GatewayBrowserAgent" open page "https://cloud.konghq.com/us/ai-manager/"
    Then "GatewayBrowserAgent" should see UI element "Login-Page.continue-with-github"
    And "GatewayBrowserAgent" click UI element "Login-Page.continue-with-github"
    Then "GatewayBrowserAgent" should see UI element "Login-Page.user-textbox"
    And "GatewayBrowserAgent" input ciphertext "93986b616a596a79384b4347705633354f4c3332594a414d564e4e306d4e4a31574f48526c6b734174754d3d" into text box "Login-Page.user-textbox"
    And "GatewayBrowserAgent" input ciphertext "a65f303463514e2f622f385a5155307a7032562b50773d3d" into text box "Login-Page.password-textbox"
    And "GatewayBrowserAgent" click UI element "Login-Page.signin-button"
    Then "GatewayBrowserAgent" should be on page "AI-Gateway-Manager-Page"
