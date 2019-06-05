package com.example.demo.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer4FanoutExchange {
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
        String exchangeName = "test_fanout_exchange";
        //5、发送
        for (int i=0; i<10; i++){
            String msg = "Hello World RabbitMQ 4 Fanout Exchange Message ...";
            //路由键随便填也不影响发送
            channel.basicPublish(exchangeName,"asdcx",
                    null,msg.getBytes());
        }

        channel.close();
        connection.close();
    }
}
