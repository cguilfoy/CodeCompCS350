package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class SourceFileTest 
{
	File file1 = new File("bar.foo");
	String pathName1 = file1.getAbsolutePath();
	
	File file = new File("TestDirectory/bob/ScoreTest2.java");

	@Test
	public void testSourceFileStringIntString() throws IOException 
	{
		SourceFile source = new SourceFile();
		
		assertThat(source.getFileExt(), is(equalTo("")));
		assertThat(source.getFileTitle(), is(equalTo("")));
		assertThat(source.getLineCount(), is(equalTo(0)));
		assertThat(source.getSourceFile(), is(equalTo(null)));
		
		source.setFile(pathName1);
		source.setFileExt("java");
		source.setFileLength(42);
		source.setFileTitle("SomeSweetTitle");
		source.setSourceFile(file1);
		
		SourceFile source2 = new SourceFile();
		
		assertFalse(source.equals(source2));
		assertThat(source.hashCode(), not(equalTo(source2.hashCode())));
		assertThat(source.toString(), not(equalTo(source2.toString())));
		
		source2 = (SourceFile) source.Clone();
		
		assertTrue(source.equals(source2));
		assertThat(source.hashCode(), is(equalTo(source2.hashCode())));
		assertThat(source.toString(), is(equalTo(source2.toString())));
	}
	
	@Test
	public void testSourceFileFile() throws IOException 
	{
		SourceFile source = new SourceFile(file);
		
		assertThat(source.getFileExt(), is(equalTo("java")));
		assertThat(source.getFileTitle(), is(equalTo("ScoreTest2")));
		assertThat(source.getLineCount(), is(equalTo(4)));
		assertThat(source.getSourceFile(), is(equalTo(file)));
		
		SourceFile source2 = (SourceFile) source.Clone();
		
		assertTrue(source.equals(source2));
		assertThat(source.hashCode(), is(equalTo(source2.hashCode())));
		assertThat(source.toString(), is(equalTo(source2.toString())));
	}
}
