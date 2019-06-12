package com.example.demo.rabbitmq.confirm;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Confirm确认消息
 */
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

        //4、指定我们的消息投递模式：消息的确认模式
        channel.confirmSelect();

        String exchangeName = "test_confirm_exchange";
        String routingKey = "confirm.save";

        //5、发送一条信息
        String msg = "Hello RabbitMQ Send confirm message";
        channel.basicPublish(exchangeName,routingKey,
                null,msg.getBytes());

        //6、添加一个确认监听
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            //发送成功监听器返回应答
            public void handleAck(long l, boolean b) throws IOException {
                System.err.println("----ack----");
            }

            @Override
            //发送失败监听器返回应答
            public void handleNack(long l, boolean b) throws IOException {
                System.err.println("----no ack----");
            }
        });
    }
}
