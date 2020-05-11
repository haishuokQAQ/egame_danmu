package com.ulyssesk.dao.impl;

import com.ulyssesk.dao.DanmuDao;
import com.ulyssesk.pojo.Danmu;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.Serializable;
import java.util.List;

public class DanmuDaoImpl implements DanmuDao {
    protected MongoTemplate mongoTemplate;

    public void save(Danmu entity) {
        mongoTemplate.save(entity);
    }

    public void update(Danmu entity) {

    }

    public void delete(Serializable... ids) {

    }

    public Danmu find(Serializable id) {
        return null;
    }

    public List<Danmu> findAll() {
        return null;
    }

    public List<Danmu> findAll(String order) {
        return null;
    }

    public List<Danmu> findByProp(String propName, Object value) {
        return null;
    }

    public List<Danmu> findByProp(String propName, Object value, String order) {
        return null;
    }

    public List<Danmu> findByProps(String[] propName, Object[] values) {
        return null;
    }

    public List<Danmu> findByProps(String[] propName, Object[] values, String order) {
        return null;
    }

    public Danmu uniqueByProp(String propName, Object value) {
        return null;
    }

    public Danmu uniqueByProps(String[] propName, Object[] values) {
        return null;
    }

    public int countByCondition(String[] params, Object[] values) {
        return 0;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
