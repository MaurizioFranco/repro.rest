package maurizio.franco;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class, provides main method to startup the web server. 
 * 
 * @author maurizio.franco
 */
public class Demo {
	private static Logger logger = LoggerFactory.getLogger(Demo.class);
	/**
	 * Default URI where Grizzly HTTP server will listen on
	 */
    public static final String BASE_URI = "http://localhost:9000/repro.rest/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in maurizio.franco package
        final ResourceConfig resourceConfig = new ResourceConfig().packages("maurizio.franco.demo.resource");
        resourceConfig.register(new CORSFilter());
//        resourceConfig.register(new RESTRequestFilter());
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        logger.info(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

