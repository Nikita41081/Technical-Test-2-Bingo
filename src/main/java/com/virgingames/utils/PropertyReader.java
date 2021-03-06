package com.virgingames.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Nikita
 */
public class PropertyReader {

    /**
     * Rules to implementing singleton design pattern
     * make the constructor private
     * create a static method to get the instance
     * create  a static member variables
     */


    // declare the property variable
    private static volatile PropertyReader propInstance;

    // create private constructor
    private PropertyReader() {

    }

    /**
     * This method will return instance of propertyReader class
     *
     * @return
     */

    public static synchronized PropertyReader getInstance() {
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }

    /**
     * This method will read property from property file
     *
     * @param propertyName
     * @return
     */

    public String getProperty(String propertyName) {
        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/virgingames/resources/application.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            System.out.println("Property not found");
        }
        return null;


    }


}
