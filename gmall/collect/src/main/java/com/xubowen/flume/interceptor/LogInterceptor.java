package com.xubowen.flume.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/**
 * @author XuBowen
 * @date 2022/3/6 15:56
 */
public class LogInterceptor implements Interceptor {
    public void initialize() {

    }

    public Event intercept(Event event) {
        // 取出body
        String body = new String(event.getBody(), StandardCharsets.UTF_8);
        // 通过fastjson判断数据是否完整
        try {
            JSON.parseObject(body);
        } catch (JSONException e) {
            return null;
        }
        return event;
    }

    public List<Event> intercept(List<Event> events) {
        Iterator<Event> iterator = events.iterator();
        // 从迭代中移除元素
        while (iterator.hasNext()) {
            Event event = iterator.next();
            Event result = intercept(event);
            if (result == null) {
                iterator.remove();
            }
        }
        return events;
    }

    public void close() {

    }


    public static class MyBuilder implements Builder{
        @Override
        public Interceptor build() {
            return new LogInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }

}
