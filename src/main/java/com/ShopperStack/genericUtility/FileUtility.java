package com.ShopperStack.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility implements FrameWorkConstants {

	FileInputStream fis;
	
	public String readPropertyData(String key) throws IOException{
		fis=new FileInputStream(propertyPath);
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}
	
	public String readExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
