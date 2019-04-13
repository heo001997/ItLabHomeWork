package com.topica.vn.Bai14b;

import com.topica.vn.Bai14.SqlPrestatement;

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
            com.topica.vn.Bai14.SqlPrestatement.driver = properties.getProperty("driver");
            com.topica.vn.Bai14.SqlPrestatement.url = properties.getProperty("url");
            com.topica.vn.Bai14.SqlPrestatement.database = properties.getProperty("database");
            com.topica.vn.Bai14.SqlPrestatement.user = properties.getProperty("user");
            SqlPrestatement.password = properties.getProperty("password");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
