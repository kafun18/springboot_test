package com.example.demo.rabbitmq.limit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class MyConsumer extends DefaultConsumer{

    private Channel channel;

    public MyConsumer(Channel channel) {

        super(channel);
        this.channel=channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.err.println("---consumer message---");
        System.err.println("consumerTag:"+consumerTag);
        System.err.println("envelope:"+envelope);
        System.err.println("properties:"+properties);
        System.err.println("body:"+new String(body));

        //false表示不批量接收
        //basicAck这方法表示该信息处理完了再继续处理下一条信息
        channel.basicAck(envelope.getDeliveryTag(),false);
    }
}
