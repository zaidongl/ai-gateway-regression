package ai.gateway.regression.config;

import ai.gateway.regression.agents.WebBrowserAgent;

public class WebBrowserAgentConfig extends AgentConfig{
    public static final String CONFIG_BROWSER_TYPE = "browser-type";
    public static final String CONFIG_HEADLESS = "headless";

    private String browserType = "chrome";
    private Boolean headless = true;

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public Boolean getHeadless() {
        return headless;
    }

    public void setHeadless(Boolean headless) {
        this.headless = headless;
    }

    @Override
    public String getAgentClassName() {
        return WebBrowserAgent.class.getName();
    }
}
