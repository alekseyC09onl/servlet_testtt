package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public PropertiesReader() {
    }

    public static void loadProperties() {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return PROPERTIES.getProperty(key);
    }
}
