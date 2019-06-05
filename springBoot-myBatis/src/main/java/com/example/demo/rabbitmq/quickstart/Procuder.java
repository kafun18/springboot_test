package com.example.demo.rabbitmq.quickstart;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

//生产者
public class Procuder {
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

        Map<String, Object> headers = new HashMap<>();
        headers.put("my1",111);
        headers.put("my2",222);

        //附带其它属性消息
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                //是否持久化消息，1否，2是
                .deliveryMode(2)
                .contentEncoding("UTF-8")
                //过期时间
                .expiration("10000")
                .headers(headers)
                .build();

        //4、通过Channel发送数据
        for (int i=0; i<5; i++){
            String msg = "Hello RabbitMQ";
            channel.basicPublish("","test001",properties,msg.getBytes());
        }
        //5、记得要关闭相关连接
        channel.close();
        connection.close();

    }
}
