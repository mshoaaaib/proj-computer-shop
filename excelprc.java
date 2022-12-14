package proj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelprc {
	
	XSSFWorkbook workbook1=new XSSFWorkbook();
	XSSFSheet sheet1=workbook1.createSheet("Computer Details");
	
	public void ExcelFn(String value ,String price, String description, int Row, int Col) throws Exception {
	
//	sheet1.createRow(0).createCell(1);
//	sheet1.createRow(0).createCell(2);
//	sheet1.createRow(0).createCell(3);
//	sheet1.getRow(0).getCell(1).setCellValue("Computer Name");
//	sheet1.getRow(0).getCell(2).setCellValue("Price");
//	sheet1.getRow(0).getCell(3).setCellValue("Description");
	sheet1.createRow(Row).createCell(Col);
	sheet1.getRow(Row).getCell(Col).setCellValue(value);
	sheet1.getRow(Row).createCell(Col+1).setCellValue(price);
	sheet1.getRow(Row).createCell(Col+2).setCellValue(description);
	File fil=new File("C:\\Users\\muham\\eclipse-workspace\\proj1\\details.xlsx");
	FileOutputStream fos=new FileOutputStream(fil);
	workbook1.write(fos);
	//workbook1.close();
	
}

	private void Function() {
		// TODO Auto-generated method stub
		
	}

}
