package com.topica.vn.Bai14;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    public void getPropertiesValue() throws IOException {
        Properties properties = new Properties();
        String propertiesFileName = "resource.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

        try {
            if(inputStream != null){
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propertiesFileName + "' not found");
            }
            SqlProcedure.driver = properties.getProperty("driver");
            SqlProcedure.url = properties.getProperty("url");
            SqlProcedure.database = properties.getProperty("database");
            SqlProcedure.user = properties.getProperty("user");
            SqlProcedure.password = properties.getProperty("password");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
