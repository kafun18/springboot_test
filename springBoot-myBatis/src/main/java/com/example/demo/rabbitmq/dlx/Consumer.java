package com.example.demo.rabbitmq.dlx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 死信队列
 */
public class Consumer {
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

        //这就是一个普通的交换机和队列以及路由
        String exchangeName = "test_dlx_exchange";
        String routingKey = "dlx.save";
        String queueName = "test_dlx_queue";

        channel.exchangeDeclare(exchangeName,"topic",true,false,null);

        Map<String, Object> agruments = new HashMap<String, Object>();
        agruments.put("x-dead-letter-exchange","dlx.exchange");
        //这个agruments属性，要设置到声明队列上
        channel.queueDeclare(queueName,true,false,false,agruments);
        channel.queueBind(queueName,exchangeName,routingKey);

        //要进行死信队列的声明：
        channel.exchangeDeclare("dlx.exchange","topic",true,false,null);
        channel.queueDeclare("dlx.queue",true,false,false,null);
        channel.queueBind("dlx.queue","dlx.exchange","#");

        channel.basicConsume(queueName,true,new MyConsumer(channel));



    }
}
