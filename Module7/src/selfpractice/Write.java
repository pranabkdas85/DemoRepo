package selfpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Write {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File src=new File("C:\\rep\\test.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wob=new XSSFWorkbook(fis);
		XSSFSheet sh1= wob.getSheetAt(0);
		sh1.createRow(0).createCell(0).setCellValue("Company_Name");
		sh1.getRow(0).createCell(1).setCellValue("Place");
		sh1.createRow(1).createCell(0).setCellValue("Invenger");
		sh1.getRow(1).createCell(1).setCellValue("Mangalore");
		sh1.createRow(2).createCell(0).setCellValue("XEROX");
		sh1.getRow(2).createCell(1).setCellValue("Noida");
		FileOutputStream fout=new FileOutputStream(src);
		wob.write(fout);
		//fout.close();
		
	}

}
