import io.vertx.core.Vertx;
import verticles.SimpleVerticle;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.factory.vertx();
        vertx.deployVerticle(new SimpleVerticle());
        /*Also this can be done by passing verticle absolute name
        vertx.deployVerticle("verticle.SimpleVerticle");
        Use when you want deploy verticle using boot configurations*/
    }
}
