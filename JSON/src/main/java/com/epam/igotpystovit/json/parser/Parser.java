package com.epam.igotpystovit.json.parser;

import com.epam.igotpystovit.model.Gun;

import java.io.File;
import java.util.Collection;
import java.util.List;

public interface Parser {
    List<Gun> parseObjects(File jsonFile, File jsonSchema);
}
