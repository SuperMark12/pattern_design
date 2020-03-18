package com.dou.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 配置文件读取
 */
public class PropertiesReader {

    public Map<String, String> getProperties() {
        Properties props = new Properties();
        Map<String, String> map = new HashMap<>();

        try {
            InputStream inputStream = getClass().getResourceAsStream("/type.properties");
            props.load(inputStream);
            Enumeration<?> enumeration = props.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                String property = props.getProperty(key);
                map.put(key, property);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
