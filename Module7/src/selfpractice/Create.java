package selfpractice;


import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Create {
	public static void main(String args[]) throws Exception{
// create a  file
		
    @SuppressWarnings("resource")
	XSSFWorkbook workbook = new XSSFWorkbook();
    workbook.createSheet("test");
    FileOutputStream saver=new FileOutputStream("C:\\rep\\test.xlsx");
    workbook.write(saver);

 

}
}