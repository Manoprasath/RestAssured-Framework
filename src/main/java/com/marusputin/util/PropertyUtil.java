package com.marusputin.util;

import com.marusputin.constants.FrameworkConstants;
import com.marusputin.enums.PropertyKey;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Reading property file before executing the tests and only once
 * Read the property file contents and store it in static MAP
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyUtil {
    private static final Properties properties = new Properties();
    private static final Map<String, String> MAP_PROPERTIES= new HashMap<>();

    static {
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
//        properties.entrySet().forEach(e -> MAP_PROPERTIES.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
        properties.forEach((key, value) -> MAP_PROPERTIES.put(String.valueOf(key), String.valueOf(value)));
    }

    public static String getValue(PropertyKey key) {
        return MAP_PROPERTIES.get(key.getValue());
    }
}
