package com.example.demo.rabbitmq.ack;

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
        System.err.println("body:"+new String(body));
        System.err.println("consumerTag:"+consumerTag);
        System.err.println("envelope:"+envelope);
        System.err.println("properties:"+properties);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        channel.basicAck(envelope.getDeliveryTag(),false);
        if((Integer)properties.getHeaders().get("num")==0){
            //第三个参数为false表示不重回队列

            /**
             * 第三个参数为true时表示重回队列，意思就是num=0这条信息会
             * 等待其它信息执行完后重新回到队列最后面再执行
             */
            channel.basicNack(envelope.getDeliveryTag(),false,true);
        }else {
            //false表示不批量接收
            //basicAck这方法表示该信息处理完了再继续处理下一条信息
            channel.basicAck(envelope.getDeliveryTag(),false);
        }

    }
}
