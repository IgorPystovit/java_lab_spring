package com.epam.igotpystovit.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

import java.io.File;
import java.io.IOException;

public class JSONValidator {
    public static boolean validateJSON(File jsonFile, File jsonSchema) throws IOException, ProcessingException {
        JsonNode jsonContent = JsonLoader.fromFile(jsonFile);
        JsonNode jsonSchemaContent = JsonLoader.fromFile(jsonSchema);
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonValidator validator = factory.getValidator();
        ProcessingReport report = validator.validate(jsonSchemaContent, jsonContent);
        return report.isSuccess();
    }
}
