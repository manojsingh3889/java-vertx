package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class BasicVerticle extends AbstractVerticle {


    /**
     * Note: if future based function is implemented then only it will run.
     * The AbstractVerticle class also contains another version of start()
     * which takes a Future as parameter. This Future can be used to
     * asynchronously tell Vert.x if the Verticle was deployed successfully.
     * @param startFuture param
     * @throws Exception
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {
         /*deploy another verticle
        vertx.deployVerticle(anotherverticle);
        vertx available data member which reference to parent Vertx*/
        System.out.println(getClass().getSimpleName()+":Starting basic verticle "+startFuture);

        //sending message to event to channel 'say'
        vertx.eventBus().send("say","Basicverticle is in play");

        //publish to channel which is consumed by multiple verticle
        vertx.eventBus().publish("saytoall","Informing all that Basicverticle is in play");
    }

    /**
     * Note: if future based function is implemented then only it will run.
     *The AbstractVerticle class also contains another version of stop()
     *  which takes a Future as parameter. This Future can be used to asynchronously
     *  tell Vert.x if the Verticle was undeployed successfully.
     * @param stopFuture stop param
     * @throws Exception
     */
    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        System.out.println(getClass().getSimpleName()+":Stopping basic verticle "+stopFuture);
    }
}
