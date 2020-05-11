package com.ulyssesk;


import com.mongodb.MongoClient;
import com.ulyssesk.client.EgameScreenClient;
import com.ulyssesk.dao.DanmuDao;
import com.ulyssesk.dao.impl.DanmuDaoImpl;
import com.ulyssesk.util.LogbackUtil;
import com.ulyssesk.util.RedisUtil;
import org.springframework.data.mongodb.core.MongoTemplate;

public class App {
    public static void main(String[] args) {
        try {
            LogbackUtil.load("logback.xml");
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        //初始化template
        MongoClient mongoClient = new MongoClient("192.168.0.109:27017");
        RedisUtil.initRedis("39.100.142.29", 6379);
        MongoTemplate template = new MongoTemplate(mongoClient, "dys");
        DanmuDaoImpl dao = new DanmuDaoImpl();
        dao.setMongoTemplate(template);
        EgameScreenClient client = new EgameScreenClient();
        while (true) {
            try {
                client.getBullet(497383565, dao);
            } catch(Exception e) {
                System.out.println("链接断开，开始重试");
            }
        }
    }

}
