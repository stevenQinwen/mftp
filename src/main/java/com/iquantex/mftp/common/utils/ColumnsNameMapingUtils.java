package com.iquantex.mftp.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ColumnsNameMapingUtils {

	
	public static String  transform2ChineseName(String name) {
        String chineseName= "";
        
        Properties properties = new Properties();
        InputStream in=null;
        try {
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/columns_name_mapping.properties");  
			InputStreamReader in_utf8 = new InputStreamReader(in, "utf-8");
            properties.load(in_utf8);
            chineseName = properties.getProperty(name);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return chineseName;
    }
}
	
	
	
	
	







