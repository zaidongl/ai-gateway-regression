package ai.gateway.regression.config;

import ai.gateway.regression.agents.Agent;

public class AgentConfig {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAgentClassName(){
        return Agent.class.getName();
    }
}
