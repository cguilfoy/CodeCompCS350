package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestScore {

	@Test
	public void testScore() 
	{
		Score score = new Score();
		Score score2 = new Score();
		
		assertThat(score.getStudent1(), is(equalTo("")));
		assertThat(score.getStudent2(), is(equalTo("")));
		assertThat(score.getRawScore(), is(equalTo(0.0)));
		assertThat(score.getZScore(), is(equalTo(0.0)));
		
		score.setStudent1("Bob");
		score.setStudent2("Tom");
		score.setRawScore(0.34);
		score.setZScore(2.34);
		
		assertFalse(score.equals(score2));
		assertThat(score.hashCode(), not(equalTo(score2.hashCode())));
		assertThat(score.toString(), not(equalTo(score2.toString())));
		
		Score score3 = (Score) score.clone();
		
		assertTrue(score.equals(score3));
		assertThat(score.hashCode(), is(equalTo(score3.hashCode())));
		assertThat(score.toString(), is(equalTo(score3.toString())));
		assertThat(score3.toString(), containsString("Bob"));
		assertThat(score3.toString(), containsString("Tom"));
	}

	@Test
	public void testScoreStringStringDoubleDouble() 
	{
		Score score = new Score("Bob", "Tom", 0.56, 4.29);
		
		assertThat(score.getStudent1(), is(equalTo("Bob")));
		assertThat(score.getStudent2(), is(equalTo("Tom")));
		assertThat(score.getRawScore(), is(equalTo(0.56)));
		assertThat(score.getZScore(), is(equalTo(4.29)));
		
		Score score2 = (Score) score.clone();
		
		score.setStudent1("Robert");
		score.setStudent2("Paul");
		score.setRawScore(0.34);
		score.setZScore(2.34);
		
		assertFalse(score.equals(score2));
		assertThat(score.hashCode(), not(equalTo(score2.hashCode())));
		assertThat(score.toString(), not(equalTo(score2.toString())));
	}

}
