
package com.thiendz.tool.autopadlet.util;

import org.json.XML;

public class JsonUtils {

    public static JJson xmlToJJson(String xml) {
        return JJson.parse(XML.toJSONObject(xml).toString());
    }
}
