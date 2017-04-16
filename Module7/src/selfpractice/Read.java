package selfpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {

	public static void main(String[] args) throws IOException {

 File src=new File("C:\\rep\\test.xlsx");
 FileInputStream fis= new FileInputStream(src);
 @SuppressWarnings("resource")
XSSFWorkbook wb= new XSSFWorkbook(fis);
 XSSFSheet sh1= wb.getSheetAt(0);
 System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
 System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
 System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
 System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
 System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
 System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());
 System.out.println(sh1.getLastRowNum());
 System.out.println(sh1.getRow(0).getLastCellNum());
 
	}
}
