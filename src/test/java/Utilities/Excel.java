package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static XSSFCellStyle style;
		public static  Font font;
		String file=System.getProperty("user.dir")+"\\src\\test\\resources\\Data.xlsx";
	
		
		public void setExcel(String text,int r,int c) throws IOException {
			fi=new FileInputStream(file);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet("Sheet1");
			if(ws.getRow(r) != null) {
		        row = ws.getRow(r);}
		    else {
		        row = ws.createRow(r);
		    }
			cell=row.createCell(c);
			cell=row.createCell(c);
			if((c==0 && r==0)||(c==1 && r==0)||(c==0 && r==5)) {
				// Create a font with bold style
		        font = wb.createFont();
		        font.setBold(true);
		
		        // Create a CellStyle with the bold font
		        style = wb.createCellStyle();
		        style.setFont(font);
		        cell.setCellStyle(style);
			}
			cell.setCellValue(text);
			fo=new FileOutputStream(file);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
		}
}
		
		
		  