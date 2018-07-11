import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import verticles.BasicVerticle;
import verticles.ServerBasedVerticle;
import verticles.SimpleVerticle;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.factory.vertx();
        //verticle deployment
        vertx.deployVerticle(new SimpleVerticle());
        /*Also this can be done by passing verticle absolute name
        vertx.deployVerticle("verticle.SimpleVerticle");
        Use when you want deploy verticle using boot configurations*/
        vertx.deployVerticle("verticles.EventVerticle");
        vertx.deployVerticle("verticles.EventVerticle1");

        /*The verticle will be deployed asynchronously,
         so the verticle may not be deployed by the time the deployVerticle()
          method returns. If you need to know exactly when a verticle is fully deployed,
           you can provide a Handler implementation to the the deployVerticle()*/
        vertx.deployVerticle(new BasicVerticle(), new Handler<AsyncResult<String>>() {
            public void handle(AsyncResult<String> stringAsyncResult) {
                System.out.println(getClass().getSimpleName()+": BasicVerticle deployment complete");
            }
        });

        /*
        * or,
        * vertx.deployVerticle(new BasicVerticle(), stringAsyncResult -> {
        System.out.println("BasicVerticle deployment complete");
            });
        */

        vertx.deployVerticle(new ServerBasedVerticle());
    }
}
