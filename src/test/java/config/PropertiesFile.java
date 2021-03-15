package config;

//import test.OrangeHRM;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) throws FileNotFoundException {
        getProperties();
        //setProperties();
        //getProperties();
    }

    public static void getProperties() {
        try {
            InputStream input = new FileInputStream(projectPath + "/src/test/java/config/config.properties");
            prop.load(input); // at this point properties are loaded and ready to be used
            String browser = prop.getProperty("browser");
            String baseurl = prop.getProperty("baseurl");
            System.out.println(browser + "\n" + baseurl);
            //OrangeHRM.browserName=browser;
        } catch (Exception exp) {
            exp.getMessage();
            exp.getCause();
            exp.printStackTrace();
        }
    }

    public static void setProperties() {
        try {
            OutputStream output = new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
            prop.setProperty("browser", "chrome");
            prop.store(output, null); // will store the browser as chrome
        } catch (Exception exp) {
            exp.getMessage();
            exp.getCause();
            exp.printStackTrace();
        }
    }


}
