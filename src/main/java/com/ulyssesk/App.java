package com.ulyssesk;


import com.mongodb.MongoClient;
import com.ulyssesk.client.EgameScreenClient;
import com.ulyssesk.dao.DanmuDao;
import com.ulyssesk.dao.impl.DanmuDaoImpl;
import com.ulyssesk.kafka.Producer;
import com.ulyssesk.util.LogbackUtil;
import com.ulyssesk.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);
    private static  Properties properties;
    public static void main(String[] args) {
        try {
            LogbackUtil.load("logback.xml");
            properties = new Properties();
            properties.load(new FileInputStream(new File("conf/config.properties")));
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        String redisHost = properties.getProperty("redis.host");
        String kafkaHost = properties.getProperty("kafka.host");
        //初始化template
        RedisUtil.initRedis(redisHost, 6379);
        Producer.init(kafkaHost);
        EgameScreenClient client = new EgameScreenClient();
        while (true) {
            try {
                client.getBullet(497383565);
            } catch(Exception e) {
                System.out.println("链接断开，开始重试");
                logger.error("链接断开，开始重试 {}", e);
                e.printStackTrace();
            }
        }
    }

}
