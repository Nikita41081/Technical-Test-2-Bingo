package com.virgingames.testbase;


import io.restassured.RestAssured;
import org.junit.BeforeClass;
import com.virgingames.utils.PropertyReader;

/**
 * Created by Nikita
 */
public class TestBase {

    public static PropertyReader propertyReader;

    @BeforeClass
    public static void inIt() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = (propertyReader.getProperty("basePath"));

    }


}
