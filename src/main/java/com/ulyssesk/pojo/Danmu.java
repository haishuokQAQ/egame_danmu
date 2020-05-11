package com.ulyssesk.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: barrage
 * @description: 弹幕实体
 * @author: zhaoshuai
 * @create: 2018-10-11 16:20
 **/
@ToString
@Setter
@Getter
@Data
@Document(collection="danmu")
public class Danmu implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
//    private Long id;
    //弹幕内容
    private String text;
    //用户姓名
    private String anchor_name;
    //说话的人的名字
    private String talkName;
    //用户id
    private String base_id;
    //录制人
    private String tenant_id;
    //弹幕时间
    private String time;

    public String getSerialStr() {
        StringBuilder sb = new StringBuilder();
        if (text != null ) {
            sb.append(text);
        }
        if (anchor_name != null ) {
            sb.append(anchor_name);
        }
        if (talkName != null ) {
            sb.append(talkName);
        }
        if (base_id != null ) {
            sb.append(base_id);
        }
        if (tenant_id != null ) {
            sb.append(tenant_id);
        }
        if (time != null ) {
            sb.append(time);
        }
        try {
            //初始化摘要对象
            MessageDigest md = MessageDigest.getInstance("md5");
            return new String(md.digest(sb.toString().getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
