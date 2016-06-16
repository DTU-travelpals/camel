package de.tomsu.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        // removed: ?noop=true
        from("file:src/data")
                .choice()
                    .when(xpath("/person/city = 'London'"))
                    .log("UK message")
                    .to("file:target/messages/uk")
                .when(xpath("/person/city = 'Friedrichshafen'"))
                    .log("DE message")
                    .to("file:target/messages/de")
                .otherwise()
                    .log("Other message")
                    .to("file:target/messages/others");
    }

}
