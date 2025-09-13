@plugin @decorator
Feature: AI plugin Decorator
    Scenario: AI plugin Decorator - answer question about Kong
        Given I have headers "@headers" as below
            | Key           | Value                     |
            | Content-Type  | application/json          |
        And I have payload "@payload" from json file "data/ai-plugin-decorator/request-payload-positive.json"
        When "GatewayRestAgent" send a "POST" request to endpoint "/api/reg-test/decorator/chat" with "@headers", "" and "@payload"
        Then Get response as "@response"
        Then The "@response" status code should be 200
        Then The "@response" body should contain "an open-source API management platform"

    Scenario: AI plugin Decorator - refuse to answer question irrelevant to Kong
        Given I have headers "@headers" as below
            | Key           | Value                     |
            | Content-Type  | application/json          |
        And I have payload "@payload" from json file "data/ai-plugin-decorator/request-payload-negative.json"
        When "GatewayRestAgent" send a "POST" request to endpoint "/api/reg-test/decorator/chat" with "@headers", "" and "@payload"
        Then Get response as "@response"
        Then The "@response" status code should be 200
        Then The "@response" body should contain "Sorry, I can only answer questions about Kong."