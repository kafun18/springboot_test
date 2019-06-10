package com.example.demo.rabbitmq.ack;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

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

        String exchangeName = "test_ack_exchange";
        String routingKey = "ack.save";



        for (int i=0; i<5; i++){
            Map<String, Object> headers = new HashMap<String, Object>();
            headers.put("num",i);
            //附带其它属性消息
            AMQP.BasicProperties properties =
                    new AMQP.BasicProperties.Builder()
                            //是否持久化消息，1否，2是
                    .deliveryMode(2)
                    .contentEncoding("UTF-8")
                    .headers(headers)
                    .build();
            String msg = "Hello RabbitMQ ACK Message " + i;
            //第三个参数为true消息无论是否发送成功也不会删除
            channel.basicPublish(exchangeName,routingKey,
                    true,properties,msg.getBytes());

        }

    }
}
