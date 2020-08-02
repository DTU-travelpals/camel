package de.tomsu.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main mainApp = new Main();
        mainApp.start();
        CamelContext context = mainApp.getCamelContext();
        context.addRoutes(new MyRouteBuilder());
        mainApp.run(args);
        mainApp.stop();
    }

}

