package com.yuanjing.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Poseidon
 * @date 2019/6/6 11:31
 * @descrition 从配置文件中获取参数-工具类
 */
public class GetParameter {

    /**
     * @param  filename 加载的文件名称
     * @param key key名称
     * @return String 属性值
     * @throws Exception
     */
    public static String getProperty(String filename,String key) throws Exception {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(fileInputStream);
        String value = properties.getProperty(key);
        return value;
    }

}
