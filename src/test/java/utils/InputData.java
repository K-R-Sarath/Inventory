package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputData {

	public static String[][] readExcel(String fileName) throws InvalidFormatException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(new File("./inputData/" + fileName + ".xlsx"));
		XSSFSheet worksheet = workbook.getSheetAt(0);
		int rowCount = worksheet.getLastRowNum();
		int cellCount = worksheet.getRow(0).getLastCellNum();
		String[][] inputData = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = worksheet.getRow(i);
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				inputData[i - 1][j] = cell.toString();
			}
		}
	
		workbook.close();
		return inputData;
	}
	
	public static String[][] readExcel1(String fileName) throws InvalidFormatException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(new File("./inputData/" + fileName + ".xlsx"));
		XSSFSheet worksheet = workbook.getSheetAt(1);
		int rowCount = worksheet.getLastRowNum();
		int cellCount = worksheet.getRow(0).getLastCellNum();
		String[][] inputData = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = worksheet.getRow(i);
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				inputData[i - 1][j] = cell.toString();
			}
		}
	
		workbook.close();
		return inputData;
	}

}

