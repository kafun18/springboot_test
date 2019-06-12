package com.example.demo.rabbitmq.bfxy.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqAMQPTest {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private RabbitAdmin rabbitAdmin;

    /**
     * SpringAMQP模式
     *
     * @throws Exception
     */
    @Test
    public void testAdmin() throws Exception {
        //第二个参数false表示不持久化
        rabbitAdmin.declareExchange(new DirectExchange(
                "test.direct", false, false));
        rabbitAdmin.declareExchange(new TopicExchange(
                "test.topic", false, false));
        rabbitAdmin.declareExchange(new FanoutExchange(
                "test.fanout", false, false));

        rabbitAdmin.declareQueue(new Queue("test.direct.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.topic.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.fanout.queue", false));

        /**
         * 第二个参数是与队列绑定，第四个参数是路由，
         * 第五个参数是信息
         */
        rabbitAdmin.declareBinding(new Binding("test.direct.queue",
                Binding.DestinationType.QUEUE,
                "test.direct", "direct", new HashMap<String, Object>()));

        /**
         * 另一种队列和交换机绑定的方法；.bind()表示创建一个队列，
         * .to()表示绑定到一个交换机，.with()表示路由
         */
        rabbitAdmin.declareBinding(
                BindingBuilder.bind(new Queue("test.topic.queue", false)) //直接创建队列
                        .to(new TopicExchange("test.topic", false, false))  //直接创建交换机，建立关联关系
                        .with("user.#"));  //指定路由key

        rabbitAdmin.declareBinding(
                BindingBuilder.bind(new Queue("test.fanout.queue", false)) //直接创建队列
                        .to(new FanoutExchange("test.fanout", false, false)));

        //清空队列数据
        rabbitAdmin.purgeQueue("test.topic.queue", false);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void testSendMessage() throws Exception {
        //1 创建消息
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("desc", "信息描述..");
        messageProperties.getHeaders().put("type", "自定义消息类型..");
        Message message = new Message("Hello RabbitMQ".getBytes(), messageProperties);

        //转换并且发送消息
        //new MessagePostProcessor()添加额外设置的消息
        rabbitTemplate.convertAndSend("topic001", "spring.amqp", message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                System.err.println("------添加额外的设置---------");
                message.getMessageProperties().getHeaders().put("desc", "额外修改的信息描述");
                message.getMessageProperties().getHeaders().put("attr", "额外新加的属性");
                return message;
            }
        });
    }

    @Test
    public void testSendMessage2() throws Exception {
        //1 创建消息
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        Message message = new Message("mq 消息1234".getBytes(), messageProperties);

        //普通的发送消息
        rabbitTemplate.send("topic001", "spring.abc", message);

        //转换并且发送消息
        rabbitTemplate.convertAndSend("topic001", "spring.amqp", "hello object message send!");
        rabbitTemplate.convertAndSend("topic002", "rabbit.abc", "hello object message send!");
    }

}