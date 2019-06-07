package com.example.finalproject.utils;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Objects;

public abstract class JsonUtils {

    public static Gson getGson(Type type) {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .registerTypeAdapter(type, new GsonRootSerializer())
                .create();
    }

    static class GsonRootSerializer implements JsonSerializer<Object> {
        @Override
        public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
            Gson gson = new Gson();
            JsonElement je = gson.toJsonTree(src);
            JsonObject jo = new JsonObject();
            jo.add(Objects.requireNonNull(src.getClass().getAnnotation(JsonRootName.class)).value(), je);
            return jo;
        }
    }

}
