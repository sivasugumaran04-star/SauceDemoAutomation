package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class File_Utility {

	public static String getPropertyData(String key) {
		
		FileInputStream fis= null;
		try {
			 fis = new FileInputStream("./src/test/resources/commonData.properties");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return property.getProperty(key);
		
	}
	
}
