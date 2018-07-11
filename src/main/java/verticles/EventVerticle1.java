package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

public class EventVerticle1 extends AbstractVerticle {

    /**
     * Event based verticle
     * @param startFuture start param
     * @throws Exception
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {

        vertx.eventBus().consumer("saytoall", new Handler<Message<String>>() {
            @Override
            public void handle(Message<String> message) {
                System.out.println("EventVerticle1:Saying - "+message.body());
            }
        });
    }
}
