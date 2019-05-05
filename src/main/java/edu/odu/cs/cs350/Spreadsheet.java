package edu.odu.cs.cs350;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Spreadsheet class to hold the information from a comparison between students
 * 
 * @author Apache POI spreadsheet method by www.codejava.net, edited by efryar
 * 
 */

public class Spreadsheet {
	private String sheetName;
	
	/**
	 * Default Constructor
	 */
	public Spreadsheet() {
	}
	
	/**
	 * 
	 * @param listSpreadsheet collection of rows that make up the spreadsheet
	 * @param excelFile title of the file to output the spreadsheet to
	 * @throws IOException 
	 */
	public void outputExcel (ArrayList<Score> scoreList, String excelFile, 
			String templateLoc) throws IOException {
		
		if (templateLoc.equals(""))
		{
			sheetName = excelFile;
			Workbook workbook = getWorkBook(excelFile);
			Sheet sheet = workbook.createSheet();
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 4000);
			sheet.setColumnWidth(3, 2500);
			sheet.setColumnWidth(4, 2500);
			
			Collections.sort(scoreList, new Comparator<Score>() {
				
				public int compare(Score s1, Score s2)
				{
					return Double.compare(s2.getZScore(), s1.getZScore());
				}
			});
			
			int rowCount = 0;
			
			Row row = sheet.createRow(++rowCount);

			Cell cell = row.createCell(1);
			cell.setCellValue("Student 1");
			
			cell = row.createCell(2);
			cell.setCellValue("Student 2");
			
			cell = row.createCell(3);
			cell.setCellValue("Raw Score");
			
			cell = row.createCell(4);
			cell.setCellValue("z Score");
			
			for (int i = 0; i < scoreList.size(); i++) 
			{
				Row newRow = sheet.createRow(++rowCount);

				DecimalFormat newdf = new DecimalFormat("0.00");
				
				Cell newCell = newRow.createCell(1);
				newCell.setCellValue(scoreList.get(i).getStudent1());
				
				newCell = newRow.createCell(2);
				newCell.setCellValue(scoreList.get(i).getStudent2());
				
				newCell = newRow.createCell(3);
				newCell.setCellValue(newdf.format(scoreList.get(i).getRawScore()));
				
				newCell = newRow.createCell(4);
				newCell.setCellValue(newdf.format(scoreList.get(i).getZScore()));
			}
			
			try (FileOutputStream outStream = new FileOutputStream(excelFile)) {
				workbook.write(outStream);
			}
			workbook.close();
		}
		else
		{
			try
			{
				FileInputStream inputStream = new FileInputStream(new File(templateLoc));
				sheetName = excelFile;
				Workbook workbook = new HSSFWorkbook(inputStream);
				Sheet sheet = workbook.getSheetAt(0);
				
				Collections.sort(scoreList, new Comparator<Score>() {
					
					public int compare(Score s1, Score s2)
					{
						return Double.compare(s2.getZScore(), s1.getZScore());
					}
				});
				
				int rowCount = 0;
				
				Row row = sheet.createRow(++rowCount);

				Cell cell = row.createCell(1);
				cell.setCellValue("Student 1");
				
				cell = row.createCell(2);
				cell.setCellValue("Student 2");
				
				cell = row.createCell(3);
				cell.setCellValue("Raw Score");
				
				cell = row.createCell(4);
				cell.setCellValue("z Score");
				
				for (int i = 0; i < scoreList.size(); i++) 
				{
					Row newRow = sheet.createRow(++rowCount);

					DecimalFormat newdf = new DecimalFormat("0.00");
					
					Cell newCell = newRow.createCell(1);
					newCell.setCellValue(scoreList.get(i).getStudent1());
					
					newCell = newRow.createCell(2);
					newCell.setCellValue(scoreList.get(i).getStudent2());
					
					newCell = newRow.createCell(3);
					newCell.setCellValue(newdf.format(scoreList.get(i).getRawScore()));
					
					newCell = newRow.createCell(4);
					newCell.setCellValue(newdf.format(scoreList.get(i).getZScore()));
				}
				
				try (FileOutputStream outStream = new FileOutputStream(excelFile)) {
					workbook.write(outStream);
					outStream.close();
				}
				workbook.close();
			}
			catch (Exception e)
			{
				System.out.println("Error with template location or file.");
			}
		}
	}
	
	/**
	 * 
	 * @param excelFile title of the excel file to output the spreadsheet
	 * @return the excel workbook being used 
	 * @throws IOException
	 */
	private Workbook getWorkBook (String excelFile) throws IOException {
		Workbook workbook = null;
		
		if (excelFile.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFile.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else if (excelFile == "") {
			workbook = new XSSFWorkbook();
		} else {
			throw new IllegalArgumentException("A non-Excel file was selected");
		}
			return workbook;			
		}

	/**
	 * 
	 */
	public Object clone() {
		Spreadsheet spreadClone = new Spreadsheet();		
		return spreadClone; 
	}
	
	/*
	 * toString method
	 */
    public String toString() 
    { 
        return this.sheetName; 
    }
    
    /*
     * Equals method
     */
    public boolean equals(Object obj)
    {
    	if (obj instanceof Spreadsheet)
    	{
    		Spreadsheet newSheet = (Spreadsheet) obj;
    		
    		return sheetName.equals(newSheet.sheetName);
    	}
    	else
    	{
    		return false;
    	}
    }
    
    /**
     * Hash method
     */
    public int hashCode()
    {
    	return sheetName.hashCode();
    }
    
}