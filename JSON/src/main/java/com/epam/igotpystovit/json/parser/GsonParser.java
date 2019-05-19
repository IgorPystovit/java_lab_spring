package com.epam.igotpystovit.json.parser;

import com.epam.igotpystovit.model.Gun;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GsonParser implements Parser {
    private Gson gson = new Gson();
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            if (fieldAttributes.getAnnotation(Expose.class) == null){
                return false;
            }
            return true;
        }

        @Override
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    };
    @Override
    public List<Gun> parseObjects(File jsonFile, File jsonSchema) {
        gsonBuilder.setExclusionStrategies(exclusionStrategy);
        Gun[] guns = new Gun[0];
        try{
            guns = gsonBuilder.create().fromJson(new FileReader(jsonFile),Gun[].class);
        } catch (IOException e){
            System.out.println(e);
        }
        return Arrays.asList(guns);
    }
}
