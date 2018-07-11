package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;

public class SimpleVerticle extends AbstractVerticle {

    /**
     * The AbstractVerticle class contains a start() method which you can override in your verticle class. The start() method is called by Vert.x when the verticle is deployed and ready to start.
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        System.out.println("SimpleVerticle:Starting simple verticle");
        byte[] initialData = new byte[]{1, 2, 3};

        Buffer buffer     = Buffer.buffer(initialData);
        //writing
        System.out.println("buffer.length() = " + buffer.length());

        buffer.setByte  ( 0, (byte)  127);
        buffer.setShort ( 2, (short) 127);
        buffer.setInt   ( 4,         127);
        buffer.setLong  ( 8,         127);
        buffer.setFloat (16,      127.0F);
        buffer.setDouble(20,      127.0D);

        System.out.println("buffer.length() = " + buffer.length());

        //reading
        byte   aByte   = buffer.getByte  ( 0);
        short  aShort  = buffer.getShort ( 2);
        int    anInt   = buffer.getInt   ( 4);
        long   aLong   = buffer.getLong  ( 8);
        float  aFloat  = buffer.getFloat (16);
        double aDouble = buffer.getDouble(20);
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
