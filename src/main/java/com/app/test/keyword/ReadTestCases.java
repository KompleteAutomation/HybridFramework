package com.app.test.keyword;

import com.app.test.utility.Constants;
//import com.test.reflection.TestReflection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.app.test.keyword.ActionKeywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadTestCases {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ReadTestCases cases = new ReadTestCases();
		cases.readTestCases();
		
	}
	
    public void executeTestCase(String TCSheet) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	ActionKeywords keywords = new ActionKeywords();
    	
        // Call filePath variable using class name.
        String filePath = Constants.keywords;
//        System.out.println(filePath);
        // Create an object of file class and pass filePath as an input parameter to its constructor.
        
        File file = new File(System.getProperty("user.dir") + filePath);
//        System.out.println(file);
        // Create an ArrayList object of String type. It will accept String value only.
//        ArrayList ar = new ArrayList();

        try {
            // Create an object of FileInputStream class and pass file as parameter to its constructor.
            FileInputStream fis = new FileInputStream(file);
            // Create an object of XSSFWorkbook class and pass fis as parameter to its.
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            XSSFSheet sheet = wb.getSheet(TCSheet);
            Iterator row = sheet.rowIterator();
            row.next();

            // Checking the next element availability using reference variable row.
            while (row.hasNext()) {
                // Moving cursor to next Row using reference variable row.
                Row r = (Row) row.next();
                // Moving cursor to the cell by getting cell number.
                Cell celTS = r.getCell(0, Row.CREATE_NULL_AS_BLANK);
                Cell celDesc = r.getCell(1, Row.CREATE_NULL_AS_BLANK);
                Cell celKW = r.getCell(2, Row.CREATE_NULL_AS_BLANK);
                Cell celData = r.getCell(3, Row.CREATE_NULL_AS_BLANK);
                
                // Read the value of the cell using getStringCellValue() method.
                String TSID = celTS.getStringCellValue();
                String Desc = celDesc.getStringCellValue();
                String KW = celKW.getStringCellValue();
                String TData = celData.getStringCellValue();
                
//                if (Exec.equalsIgnoreCase("Y")) {
                	String methodName = KW;
//            		TestReflection tr = new TestReflection();
            		
            		Method methodAction = ActionKeywords.class.getDeclaredMethod(methodName,String.class);
            		methodAction.invoke(keywords,TData);
//            		System.out.println(sum);
//				}
                
            }
            
            // Return the data to the ArrayList method.

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return ar;
    }

    public void readTestCases() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // Call filePath variable using class name.
        String filePath = Constants.testcases;
        // Create an object of file class and pass filePath as an input parameter to its constructor.
        File file = new File(System.getProperty("user.dir") + filePath);
        System.out.println(file);
        // Create an ArrayList object of String type. It will accept String value only.
//        ArrayList ar = new ArrayList();

        try {
            // Create an object of FileInputStream class and pass file as parameter to its constructor.
            FileInputStream fis = new FileInputStream(file);
            // Create an object of XSSFWorkbook class and pass fis as parameter to its.
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            XSSFSheet sheet = wb.getSheet("Sheet1");
            System.out.println(sheet.getLastRowNum());
            Iterator row = sheet.rowIterator();
            
            row.next();

            // Checking the next element availability using reference variable row.
            while (row.hasNext()) {
                // Moving cursor to next Row using reference variable row.
                Row r = (Row) row.next();
                // Moving cursor to the cell by getting cell number.
                Cell cellTCID = r.getCell(0,Row.CREATE_NULL_AS_BLANK);
                Cell cellDesc = r.getCell(1, Row.CREATE_NULL_AS_BLANK);
                Cell cellExec = r.getCell(2, Row.CREATE_NULL_AS_BLANK);
                // Read the value of the cell using getStringCellValue() method.
                String TC_ID = cellTCID.getStringCellValue();
                String TC_Desc = cellDesc.getStringCellValue();
                String TC_Exec = cellExec.getStringCellValue();
                if (TC_Exec.equals("Y")) {
					
                	executeTestCase(TC_ID);
				}
                // Adding the value of the cells in the ArrayList by passing 'data'.
//                ar.add(data);
                // OR One line code: ar.add(row.next().getCell(colNo).getStringCellValue());
                
            }
//            System.out.println("List: " + ar);
            // Return the data to the ArrayList method.

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return ar;
    }


}
