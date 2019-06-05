package com.example.demo.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer4DirectExchange {
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

        //4、声明
        String exchangeName = "test_direct_exchange";
        String routingKey = "test.direct";
        //5、发送
        String msg = "Hello World RabbitMQ 4 Direct Exchange Message ...";
        channel.basicPublish(exchangeName,routingKey,
                null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
