package com.kellylyke.service;

import java.io.*;
import java.util.*;

/**
 * handles properties files -- yes this is taken from last semester ¯\_(ツ)_/¯
 * @author Eric Knapp
 *
 */
public interface PropertiesLoader{
    /**
     * loads properties file
     *@param propertiesFilePath to file with properties
     *@return properties from file
     *@throws Exception any failure
     **/
    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw ioException;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
        return properties;
    }
}