package com.example.demo.rabbitmq.returnlistener;

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

        String exchangeName = "test_return_exchange";
        String routingKey = "return.save";
        String routingKeyError = "abc.save";

        String msg = "Hello RabbitMQ Return Message";

        //返回监听
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchangeName,
                                     String rountingKey, AMQP.BasicProperties properties,
                                     byte[] body) throws IOException {
                System.err.println("---handle return---");
                System.err.println("replyCode:"+replyCode);
                System.err.println("replyText:"+replyText);
                System.err.println("exchangeName:"+exchangeName);
                System.err.println("rountingKey:"+rountingKey);
                System.err.println("properties:"+properties);
                System.err.println("body:"+new String(body));
            }
        });

        //第三个参数为true消息无论是否发送成功也不会删除
        channel.basicPublish(exchangeName,routingKeyError,
                true,null,msg.getBytes());

    }
}
