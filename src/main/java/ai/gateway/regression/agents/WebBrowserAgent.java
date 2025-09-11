package ai.gateway.regression.agents;

import ai.gateway.regression.config.WebBrowserAgentConfig;

public class WebBrowserAgent extends Agent{
    private final WebBrowserAgentConfig config;

    public WebBrowserAgent(WebBrowserAgentConfig config) {
        this.config = config;
        this.name = config.getName();
    }
}
