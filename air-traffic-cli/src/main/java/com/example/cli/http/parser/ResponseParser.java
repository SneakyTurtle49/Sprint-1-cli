
package com.example.cli.http.parser;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;

public class ResponseParser {
    private static final Gson gson = new Gson();

    public static <T> List<T> parseList(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
