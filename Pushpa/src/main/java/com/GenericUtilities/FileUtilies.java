package com.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilies {
	/**
	 * its used return the value from the property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\data\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
