package portaltech.testing.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static final String CONFIG_PROPERTIES_FILENAME = "/config.properties";
    private static PropertiesHelper propertiesHelper;

    private Properties properties;

    private PropertiesHelper() {
    }

    public static PropertiesHelper newInstance() {
        if (propertiesHelper == null) {
            propertiesHelper = new PropertiesHelper();
            propertiesHelper.loadProperties();
        }
        return propertiesHelper;
    }

    public Properties getProperties() {
        return properties;
    }

    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = new FileInputStream(this.getClass().getResource(CONFIG_PROPERTIES_FILENAME).getFile())) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
