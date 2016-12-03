package com.hiveit.pe.eai.productservice.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

public class ReadForeignPropertiesUtil implements Serializable {

	private static final long serialVersionUID = 1L;       
	private static Properties propertiesFile;
	private static InputStream in;
	private static ReadForeignPropertiesUtil objetoClase;
    
	public static ReadForeignPropertiesUtil getSingleton(String filePathProp) {
    	if (objetoClase == null) {
    		try {
                objetoClase = new ReadForeignPropertiesUtil();
                propertiesFile = new Properties();
                in = new FileInputStream(filePathProp);
                propertiesFile.load(in);
                in.close();                

            } catch (Exception i) {
                objetoClase = null;
            }
        }
    	return objetoClase;
    }
	public String getValor(String key) {    	
		return propertiesFile.get(key).toString();
    }

}

