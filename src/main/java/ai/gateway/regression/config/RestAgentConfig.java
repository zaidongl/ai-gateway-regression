package ai.gateway.regression.config;

import ai.gateway.regression.agents.RestAgent;
import ai.gateway.regression.auth.HttpRequestAuth;

public class RestAgentConfig extends AgentConfig {
    private HttpRequestAuth requestAuth;
    private Integer connectionTimeout = 30000;
    private String baseUrl;

    @Override
    public String getAgentClassName() {
        return RestAgent.class.getName();
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public HttpRequestAuth getRequestAuth() {
        return requestAuth;
    }

    public void setRequestAuth(HttpRequestAuth requestAuth) {
        this.requestAuth = requestAuth;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
