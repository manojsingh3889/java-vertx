package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

public class ServerBasedVerticle extends AbstractVerticle {
    private HttpServer httpServer = null;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        //create server
        httpServer = vertx.createHttpServer();
        //define handler
        httpServer.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest request) {
                System.out.println("Incoming request");
                System.out.println(request.uri());
                System.out.println(request.path());
                vertx.eventBus().send("say",request.getParam("message"));

                Buffer fullRequestBody = Buffer.buffer();
                //for POST request: body need to be accessed differently
                //first read body fully

                if(request.method() == HttpMethod.POST){
                    request.handler(new Handler<Buffer>() {
                        @Override
                        public void handle(Buffer buffer) {
                            fullRequestBody.appendBuffer(buffer);
                        }
                    });

                    request.endHandler(new Handler<Void>() {
                        @Override
                        public void handle(Void aVoid) {
                            System.out.println(fullRequestBody);
                        }
                    });
                }
//                request.response().end("A");
                //sending response back
                HttpServerResponse response = request.response();
                response.headers()
                        .add("Content-Type", "text/html");
                response.setStatusCode(201);
                response.end("Acknowledged");
                //or you can write directly like this response.end("Acknowledged");
            }
        });
        httpServer.exceptionHandler(new Handler<Throwable>() {
            @Override
            public void handle(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        //start server on port 9899
        httpServer.listen(9899);
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        httpServer.close();
    }
}
