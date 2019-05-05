package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


public class SpreadsheetTest {
	
	@Test
	public void testSpreadsheetOutputNoneDefined() throws IOException {
		
		Score score1 = new Score("student1", "student2", 79, 80);
		Score score2 = new Score("student3", "student4", 42, 14);
		Score score3 = new Score("student5", "student6", 1, 111.154);
		Score score4 = new Score("student7", "student8", 0, 8140.12541);
		
		ArrayList<Score> testScoreList = new ArrayList<Score> ();
		testScoreList.add(score1);
		testScoreList.add(score2);
		testScoreList.add(score3);
		testScoreList.add(score4);
		
		Spreadsheet testSpreadOutput = new Spreadsheet();

		String excelFilePath = "";
		if (excelFilePath == "") {
			testSpreadOutput.outputExcel(testScoreList, "Report.xlsx", "");
		} else {
			testSpreadOutput.outputExcel(testScoreList, excelFilePath, "");
		}
		
		File file = new File("Report.xlsx");
		assertTrue(file.exists());
	}
	
	@Test
	public void testSpreadsheetOutputFileDefined() throws IOException {
		
		Score score1 = new Score("student1", "student2", 79, 80);
		Score score2 = new Score("student3", "student4", 42, 14);
		Score score3 = new Score("student5", "student6", 1, 111.154);
		Score score4 = new Score("student7", "student8", 0, 8140.12541);
		
		ArrayList<Score> testDefinedScoreList = new ArrayList<Score> ();
		testDefinedScoreList.add(score1);
		testDefinedScoreList.add(score2);
		testDefinedScoreList.add(score3);
		testDefinedScoreList.add(score4);
		
		Spreadsheet testSpreadOutputDefined = new Spreadsheet();
		
		String excelFilePath = "DefinedPath.xlsx";
		if (excelFilePath == "") {
			testSpreadOutputDefined.outputExcel(testDefinedScoreList, "Reports.xlsx", "");
		} else {
			testSpreadOutputDefined.outputExcel(testDefinedScoreList, excelFilePath, "");
		}
		
		File file = new File("DefinedPath.xlsx");
		assertTrue(file.exists());
	}
}
