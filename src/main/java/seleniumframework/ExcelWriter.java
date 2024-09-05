package seleniumframework;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void main(String[] args) throws Exception {
		String path="src/main/resources/Book2.xlsx";
		XSSFWorkbook studentfile =new XSSFWorkbook();
        XSSFSheet sheet=studentfile.createSheet("students");
        XSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue("1");
        row.createCell(1).setCellValue("ram");
        
        
        XSSFRow row1=sheet.createRow(1);
        row1.createCell(0).setCellValue("2");
        row1.createCell(1).setCellValue("sam");
        
        FileOutputStream fr=new FileOutputStream(path);
        studentfile.write(fr);
        studentfile.close();
	}

}
