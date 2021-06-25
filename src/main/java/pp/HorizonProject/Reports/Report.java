package pp.HorizonProject.Reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class Report {
	private static final String HORIZONTAL_SEP = "-";
	private String verticalSep;
	private String joinSep;
	private String[] headers;
	private List<String[]> rows = new ArrayList<>();
	private boolean rightAlign;

	public Report() {
		setShowVerticalLines(true);
	}

	public void setRightAlign(boolean rightAlign) {
	    this.rightAlign = rightAlign;
	}

	public void setShowVerticalLines(boolean showVerticalLines) {
	    verticalSep = showVerticalLines ? "|" : "";
	    joinSep = showVerticalLines ? "+" : " ";
	}

	public String[] getHeaders() {
		return headers;
	}
	
	public void setHeaders(String... headers) {
	    this.headers = headers;
	}

	public List<String[]> getRows() {
		return rows;
	}
	
	public void addRow(String... cells) {
	    rows.add(cells);
	}

	public void print() {
		int[] maxWidths = headers != null ? Arrays.stream(headers).mapToInt(String::length).toArray() : null;

	    for (String[] cells : rows) {
	    	if (maxWidths == null) {
	    		maxWidths = new int[cells.length];
	        }
	        if (cells.length != maxWidths.length) {
	            throw new IllegalArgumentException("Liczba komórek w wierszach rzędów i headerow musi byc taka sama");
	        }
	        for (int i = 0; i < cells.length; i++) {
	            maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
	        }
	     }

	     if (headers != null) {
	        printLine(maxWidths);
	        printRow(headers, maxWidths);
	        printLine(maxWidths);
	     }
	     
	     for (String[] cells : rows) {
	        printRow(cells, maxWidths);
	     }
	     
	     if (headers != null) {
	        printLine(maxWidths);
	     }
	}

	private void printLine(int[] columnWidths) {
		for (int i = 0; i < columnWidths.length; i++) {
			String line = String.join("", Collections.nCopies(columnWidths[i] + verticalSep.length() + 1, HORIZONTAL_SEP));
	        System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
	    }
	    System.out.println();
	}

	private void printRow(String[] cells, int[] maxWidths) {
		for (int i = 0; i < cells.length; i++) {
			String s = cells[i];
	        String verStrTemp = i == cells.length - 1 ? verticalSep : "";
	        
	        if (rightAlign) {
	            System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
	        } else {
	            System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
	        }
	    }
	    System.out.println();
	}
	
	public void exportReportDataToExcel (String reportName) throws IOException {
		Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(reportName);
        int rowCount = 0;
        
        for (String[] rowToPrint : rows) {
        	Row row = sheet.createRow(rowCount);
        	int columnCount = 0;
        	rowCount++;
        	
        	for (String fieldToPrint : rowToPrint) {
        		Cell cell = row.createCell(columnCount);
        		cell.setCellValue(fieldToPrint);
        		columnCount++;
        	}
        }
        
        try (FileOutputStream outputStream = new FileOutputStream(reportName + ".xls");){
        	workbook.write(outputStream);
		} 
        
        System.out.println("Export ukończony");
	}
}
