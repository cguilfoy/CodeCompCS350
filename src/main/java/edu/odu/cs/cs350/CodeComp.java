package edu.odu.cs.cs350;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import edu.odu.cs.JarNeedsHeap.*;

/**
 * 
 * Main driver class taking arguments for options, the assignment directory, and the spreadsheet to output
 * Options to include a user specified spreadsheet, a spreadsheet name, and a help command
 *
 */

public class CodeComp {
	
	private static final Logger LOG = Logger.getLogger(CodeComp.class.getName());


	public static void main(String[] args) throws IOException
	{
		ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        LOG.addHandler(handler);

        new edu.odu.cs.JarNeedsHeap (2048, LOG, args);

		String directoryPath = "";
		String outputPath = "";
		String sheetName = "Report.xls";
		String templateName = "";
		
		// Loops through the arguments looking for -help. If it is found, displays the help
		// message and exits the program.
		for (int i = 0; i < args.length; i++)
		{
			if (args[i].equals("-help"))
			{
				System.out.println("Options are as follows: ");
				System.out.println("-template templateName allows you to replace the default "
						+ "spreadsheet template with one of your own choosing, enter "
						+ "the name of your template in place of templateName.");
				System.out.println("-report sheetname allows you to replace the default sheetname "
						+ "with a name of your choosing. Enter the new name in place of sheetname ");
				System.out.println("-help This displays the current options available.");
				System.exit(0);
			}
		}
		
		if (args.length % 2 == 1)
		{
			System.out.println("Too few or many arguements. Refer to help for correct input options.");
			System.exit(0);
		}
		
		// Searches the arguments for either the -template option or -report option,
		// if found the appropriate action is taken.
		for (int i = 0; i < args.length-2; i++)
		{
			if (args[i].equals("-template"))
			{
				templateName = args[i+1];
				
				i++;
			}
			else if (args[i].equals("-report"))
			{
				sheetName = args[i+1];
				
				String sheetNameCheck = "";
				
				if (sheetName.contains("."))
				{
					sheetNameCheck = sheetName.substring(sheetName.lastIndexOf("."), sheetName.length());
				}
				
				// If a sheetName doesn't have an excel extension, the report will not save.
				// This checks for the extension and adds it if needed.
				if (!sheetNameCheck.equals("xls") && !sheetName.equals("xlsx"))
				{
					sheetName = sheetName + ".xls";
				}
				
				i++;
			}
		}
		
		try 
		{
			directoryPath = args[args.length-2];
			outputPath = args[args.length-1];
		}
		catch (Exception e)
		{
			System.out.println("Error with command line input, please try again.");
		}
		
		Assignment assignment = new Assignment(directoryPath);
		
		// Finds student directories, and files within those directories. Then parses
		// and performs the lexical analysis on them, storing them as Token streams.
		try
		{
			assignment.findStudents(directoryPath);
		}
		catch (Exception e)
		{
			System.out.println("Error during parsing of Assignment Directory");
		}
		
		CodeComparer codeComp = new CodeComparer();
		
		// CodeComparer object will perform the comparisons between student code and scoring
		// saving the scores in Score objects that can be sorted and output later.
		try
		{
			System.out.println(assignment.toString());
			codeComp = assignment.generateComparisons();
		}
		catch (Exception e)
		{
			System.out.println("Error during printing of Assignment Directory");
		}
		
		// a new Spreadsheet object is created that will take the Scores and organize them
		// by zScore into a spreadsheet named either Report or the user specified name.
		Spreadsheet newSheet = new Spreadsheet();
		
		System.out.println("Analysis Completed. The results will be stored in a " + 
				"spreadsheet named " + sheetName + " located at " + outputPath + sheetName);
		
		newSheet.outputExcel(codeComp.scoreList, outputPath + sheetName, templateName);
	}
}
