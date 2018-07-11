package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

public class EventVerticle extends AbstractVerticle {

    /**
     * Event based verticle
     * @param startFuture start param
     * @throws Exception
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        /*When a verticle wants to listen for messages from the event bus,
         it listens on a certain address. An address is just a name (a String) which you can choose freely.
         A verticle can obtain a reference to the event bus via the vertx instance inherited from AbstractVerticle*/
        vertx.eventBus().consumer("say", new Handler<Message<String>>() {
            @Override
            public void handle(Message<String> message) {
                System.out.println("EventVerticle:Saying - "+message.body());
            }
        });

        /*Multiple verticles can listen for messages on the same address. This means that an address is not
         unique to a single verticle. An address is thus more like the name of a channel you can communicate via.
         Multiple verticles can listen for messages on an address, and multiple verticles can send messages to an address.
         Check Eventverticle1
         */
        vertx.eventBus().consumer("saytoall", new Handler<Message<String>>() {
            @Override
            public void handle(Message<String> message) {
                System.out.println("EventVerticle:Saying - "+message.body());
            }
        });
    }
}
