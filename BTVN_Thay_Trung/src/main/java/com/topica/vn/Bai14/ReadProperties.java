package com.topica.vn.Bai14;

import com.topica.vn.Bai14b.SqlConnectionPoolReplica;

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
            SqlConnectionPoolReplica.driver = properties.getProperty("driver");
            SqlConnectionPoolReplica.url = properties.getProperty("url");
            SqlConnectionPoolReplica.database = properties.getProperty("database");
            SqlConnectionPoolReplica.user = properties.getProperty("user");
            SqlConnectionPoolReplica.password = properties.getProperty("password");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
