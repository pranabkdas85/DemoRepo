package selfpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class end2end {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		//Create XLSX file
		XSSFWorkbook wb= new XSSFWorkbook();
		wb.createSheet("Sheet1");
		File path= new File("C:\\rep\\end2end.xlsx");
		FileOutputStream fout= new FileOutputStream(path);
		wb.write(fout);
		
		//Write in XLSX file
		FileInputStream fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheet("Sheet1");
		sh1.createRow(0).createCell(0).setCellValue("Pranab");
		sh1.getRow(0).createCell(1).setCellValue("Tatanagar");
		
		sh1.createRow(1).createCell(0).setCellValue("Arshad");
		sh1.getRow(1).createCell(1).setCellValue("Patna");
	    fout=new FileOutputStream(path);
		wb.write(fout);
		
		
		fis= new FileInputStream(path);
		 System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
		 fout.close();
	}

}
