package com.example.demo.rabbitmq.dlx;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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

        String exchangeName = "test_dlx_exchange";
        String routingKey = "dlx.save";

        String msg = "Hello RabbitMQ DLX Message";

        for (int i=0; i<5; i++){
            //附带其它属性消息
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    //是否持久化消息，1否，2是
                    .deliveryMode(2)
                    .contentEncoding("UTF-8")
                    //过期时间
                    //消息一发出去就开始计算时间
                    .expiration("10000")
                    .build();
            //第三个参数为true消息无论是否发送成功也不会删除
            channel.basicPublish(exchangeName,routingKey,
                    true,properties,msg.getBytes());

        }

    }
}
