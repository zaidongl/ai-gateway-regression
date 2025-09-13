@plugin @guard
Feature: AI plugin Guard
    @positive
    Scenario: AI plugin Guard - allow prompt not matched with the deny patterns
        Given I have headers "@headers" as below
            | Key           | Value                     |
            | Content-Type  | application/json          |
        And I have payload "@payload" from json file "data/ai-plugin-guard/request-payload-positive.json"
        When "GatewayRestAgent" send a "POST" request to endpoint "/api/reg-test/guard/chat" with "@headers", "" and "@payload"
        Then Get response as "@response"
        Then The "@response" status code should be 200
        Then The "@response" body should contain "1 + 1 = 2"

    @negative
    Scenario: AI plugin Guard - reject prompt matched with the deny pattern and is blocked
        Given I have headers "@headers" as below
            | Key           | Value                     |
            | Content-Type  | application/json          |
        And I have payload "@payload" from json file "data/ai-plugin-guard/request-payload-negative.json"
        When "GatewayRestAgent" send a "POST" request to endpoint "/api/reg-test/guard/chat" with "@headers", "" and "@payload"
        Then Get response as "@response"
        Then The "@response" status code should be 400
        Then The "@response" body should contain "bad request"