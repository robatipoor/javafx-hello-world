package org.robatipoor.util;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Resources
 */
public class Resources {

    public static URL getURLResourceFile(String relativePath) {
        URL resource = new Resources().getClass().getClassLoader().getResource(relativePath);
        if (resource == null) {
            throw new IllegalArgumentException("file " + relativePath + " is not found!");
        } else {
            return resource;
        }
    }

    public static URL getURLFXMLFile(String nameFile) {
        return getURLResourceFile("fxml-files/" + nameFile + ".fxml");
    }

    public static Properties getConfigFile() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream(getURLResourceFile("config.properties").getFile()));
        return properties;
    }

}