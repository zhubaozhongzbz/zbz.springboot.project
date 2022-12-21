package com.zbz.boot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class GsonUtil {

    private static final Gson gson;
    static {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:SS").create();
    }

    public static <T> T FromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T deserializeFromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
}