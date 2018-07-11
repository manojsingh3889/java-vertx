package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class SimpleVerticle extends AbstractVerticle {

    /**
     * The AbstractVerticle class contains a start() method which you can override in your verticle class. The start() method is called by Vert.x when the verticle is deployed and ready to start.
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        System.out.println("SimpleVerticle:Starting simple verticle");
    }

    /**
     * The AbstractVerticle class also contains a stop() method you can override. The stop() method is called when Vert.x shuts down and your verticle needs to stop.
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        System.out.println("Stopping simple verticle");
    }


}
