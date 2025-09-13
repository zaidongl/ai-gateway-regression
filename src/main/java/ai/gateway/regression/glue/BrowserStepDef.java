package ai.gateway.regression.glue;

import io.kiwi.agents.common.AgentsManager;
import io.kiwi.agents.gui.WebBrowserAgent;
import io.kiwi.context.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowserStepDef {
    private static final Logger logger = LogManager.getLogger(BrowserStepDef.class);
    ScenarioContext scenarioContext = null;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenarioContext = new ScenarioContext(scenario);
        logger.info("Starting scenario: {}", scenario.getName());
    }

    @After
    public void tearDown() {
        logger.info("Finished Scenario: {}", this.scenarioContext.getScenario().getName());
        this.scenarioContext = null;
    }

    @And("{string} login Kong with {string} if not logged in")
    public void loginKongWithIfNotLoggedIn(String agentName, String loginButton) {
        WebBrowserAgent agent = (WebBrowserAgent) AgentsManager.getInstance().getAgent(agentName);
        agent.waitForSelector(loginButton);
        if(agent.isVisible(loginButton)){
            agent.click(loginButton);
        } else {
            logger.info("Already logged in, no need to login again.");
        }
    }
}
