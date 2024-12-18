package aqa_course.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Properties property = new Properties();

    static {
        try {
            property.load(PropertyReader.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }
}
