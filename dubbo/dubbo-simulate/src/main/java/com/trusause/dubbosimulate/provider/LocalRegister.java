package com.trusause.dubbosimulate.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weicl
 * @Date 2022/7/6 下午3:34
 * @Version 1.0
 * @Description
 */
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void regist(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }

}
