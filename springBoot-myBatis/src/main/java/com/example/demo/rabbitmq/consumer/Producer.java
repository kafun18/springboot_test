package com.example.demo.rabbitmq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Producer {
    public static void main(String[] args) throws Exception{
        //1、创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.108.160.171");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        //2、通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //3、通过connection创建一个Channel
        Channel channel = connection.createChannel();

        String exchangeName = "test_consumer_exchange";
        String routingKey = "consumer.save";

        String msg = "Hello RabbitMQ Consumer Message";

        for (int i=0; i<5; i++){
            //第三个参数为true消息无论是否发送成功也不会删除
            channel.basicPublish(exchangeName,routingKey,
                    true,null,msg.getBytes());

        }

    }
}
