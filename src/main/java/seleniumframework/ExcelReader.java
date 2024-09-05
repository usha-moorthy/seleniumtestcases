package seleniumframework;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws Exception {
		// /seleniumframework/src/main/resources/Book1.xlsx
		//String path=System.getProperty("user.dri")+"/src/main/resources/Book1.xlsx";


		
		
		String path = "src/main/resources/Book1.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				System.out.print(cell + "   ");

			}
			System.out.println();
		}

	}

}
