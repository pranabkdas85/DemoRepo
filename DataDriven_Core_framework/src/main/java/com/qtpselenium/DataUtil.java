package com.qtpselenium;

import java.util.Hashtable;

public class DataUtil {
	public static Object[][] getTestData(Xls_Reader xls, String testname) {

		String sheetName = "Data";

		int testStartRowNum = 1;
		String cellData = xls.getCellData(sheetName, 0, testStartRowNum);
		while (!cellData.equals(testname) && !cellData.equals("Invalid")) {
			testStartRowNum++;
		}
		if(cellData.equals("Invalid")){
			System.out.println("Sheet name not valid. Invalid sheet name is "+sheetName);
			return null;
		}else{
			System.out.println("Test starts from row - " + testStartRowNum);
		}
		
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		// calculate rows of data
		int rows = 0;
		while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			rows++;
		}
		System.out.println("Total rows are  - " + rows);

		// calculate total cols
		int cols = 0;
		while (!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}
		System.out.println("Total cols are  - " + cols);
		Object[][] data = new Object[rows][1];
		// read the data
		int dataRow = 0;
		Hashtable<String, String> table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < cols; cNum++) {
				String key = xls.getCellData(sheetName, cNum, colStartRowNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
				// 0,0 0,1 0,2
				// 1,0 1,1
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
	}

	public static boolean isRuunnable(String testname, Xls_Reader xls) {
		String sheet = "testcases";
		boolean result = false;
		int rows = xls.getRowCount(sheet);
		for (int r = 2; r <= rows; r++) {
			String tname = xls.getCellData(sheet, "TCID", r);
			if (tname.equals(testname)) {
				String runmode = xls.getCellData(sheet, "Runmode", r);
				if (runmode.equals("Y"))
					result = true;
				else
					result = false;
			}
		}
		return result;
	}
}