package ai.gateway.regression;

import ai.gateway.regression.config.Configurator;
import io.cucumber.core.cli.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    private static String getTags(String[] args) {
        String tags = null;
        int i=0;
        for(; i<args.length; i++) {
            if(args[i].equals("--tags") && i+1 < args.length) {
                tags = args[i+1];
                i++;
                break;
            }
        }
        if(tags != null){
            for(; i<args.length; i++) {
                if(args[i].startsWith("--")) {
                    break;
                }
            }
        }
        return tags;
    }

    public static void main(String[] args) throws IOException {
        Configurator configurator = Configurator.getInstance();
        logger.info("Test Project Name: {}", configurator.getTestProjectName());
        logger.info("Environment: {}", configurator.getEnvironment());

        //pass cucumber tags via args
        String tags = getTags(args);
        logger.info("Starting tests with tags: {}", tags == null ? "All" : tags);

        String[] cucumberOptions = new String[]{
                "--glue", "ai.gateway.regression.glue",
                "features",
                "--plugin", "html:target/cucumber-reports.html",
                "--tags", tags != null ? tags : ""
        };

        Main.main(cucumberOptions);
    }
}