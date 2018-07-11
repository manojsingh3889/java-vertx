package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class SimpleVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        System.out.println("Starting simple verticle");
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        System.out.println("Stopping simple verticle");
    }
}
