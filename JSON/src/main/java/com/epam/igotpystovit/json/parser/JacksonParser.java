package com.epam.igotpystovit.json.parser;

import com.epam.igotpystovit.json.JSONValidator;
import com.epam.igotpystovit.model.Gun;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.util.*;

public class JacksonParser implements Parser{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Gun> parseObjects(File jsonFile, File jsonSchemaFile) {
        Gun[] guns = new Gun[0];
        try{
            if (JSONValidator.validateJSON(jsonFile,jsonSchemaFile)){
                guns = objectMapper.readValue(jsonFile,Gun[].class);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return Arrays.asList(guns);
    }
}
