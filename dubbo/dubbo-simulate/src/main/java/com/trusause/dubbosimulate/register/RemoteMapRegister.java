package com.trusause.dubbosimulate.register;

import com.trusause.dubbosimulate.provider.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author weicl
 * @Date 2022/7/6 下午3:22
 * @Version 1.0
 * @Description
 */
public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void regist(String interfaceName, URL url) {
        List<URL> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);

        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        REGISTER = getFile();
        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }

    public static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Map<String, List<URL>> map = (Map<String, List<URL>>) objectInputStream.readObject();
            return map;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
