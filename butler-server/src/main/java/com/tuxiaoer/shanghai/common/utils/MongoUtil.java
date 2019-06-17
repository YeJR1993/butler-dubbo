package com.tuxiaoer.shanghai.common.utils;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：YeJR
 * @version : 1.0
 * @date ：2019/5/29 15:06
 * @description：mongodb 测试类
 */
public class MongoUtil {

    private static final int BIGDATA_LIMIT = 500000;

    /**
     * 分页保存big data
     * @param sessionId
     * @param data
     * @param mongoTemplate
     * @param namePrefix
     * @param <T>
     * @return
     */
    public static <T> List<String> saveBigDataForCollection(String sessionId, List<T> data, MongoTemplate mongoTemplate, String namePrefix) {
        List<String> pageReuslt = new ArrayList<>();
        // 计算需要分页数
        int count = (int) Math.ceil((double) data.size() / (double) BIGDATA_LIMIT);
        // 循环存储
        for (int i = 0; i < count; i++) {
            int fromIndex = i * BIGDATA_LIMIT;
            int toIndex = (i+1) * BIGDATA_LIMIT;
            String collectionName = new StringBuilder(sessionId).append(namePrefix).append(i).toString();
            pageReuslt.add(collectionName);

            List<Object> all = mongoTemplate.findAll(Object.class, collectionName);
            if(all != null && all.size() > 0) {
                continue;
            }
            mongoTemplate.insert(data.subList(fromIndex, toIndex), collectionName);
        }
        return  pageReuslt;

    }

}
