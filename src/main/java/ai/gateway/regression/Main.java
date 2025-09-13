package ai.gateway.regression;

import io.kiwi.Runner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        logger.info("Starting Regression Tests for AI gateway...");
        String  tags = Runner.getTags(args);
        String[] cucumberOptions = new String[]{
                "features",
                "--glue", "io.kiwi.glue",
                "--glue", "ai.gateway.regression.glue",
                "--plugin", "html:target/cucumber-reports.html",
                "--tags", tags != null ? tags : ""
        };

        Runner.run(cucumberOptions);
    }
}