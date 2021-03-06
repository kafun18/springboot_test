package com.example.demo.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Consumer4FanoutExchange {
    public static void main(String[] args) throws Exception{
        //1、创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.108.160.171");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        //是否执行自动重连
        connectionFactory.setAutomaticRecoveryEnabled(true);
        connectionFactory.setNetworkRecoveryInterval(3000);

        //2、通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //3、通过connection创建一个Channel
        Channel channel = connection.createChannel();

        //4、声明
        String exchangeName = "test_fanout_exchange";
        String exchangeType = "fanout";
        String queueName = "test_fanout_queue";
        String routingKey = ""; //不设置路由键
        //声明一个交换机Exchange
        channel.exchangeDeclare(exchangeName,exchangeType,true
                ,false,false,null);
        //声明一个队列
        channel.queueDeclare(queueName,false,false
                ,false,null);
        //建立一个绑定关系
        channel.queueBind(queueName,exchangeName,routingKey);

        //durable是否持久化消息
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //参数，队列名称，是否自动ACK，Consumer
        channel.basicConsume(queueName,true,consumer);
        //循环获取消息
        while (true){
            //获取消息，如果没有消息，这一步将会一直阻塞
            QueueingConsumer.Delivery delivery =
                    consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("获取消息:"+msg);
        }

    }
}
