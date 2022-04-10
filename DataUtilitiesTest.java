package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.security.InvalidParameterException;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import junit.framework.TestCase;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;

public class DataUtilitiesTest extends DataUtilities {
	
	private static final double EPSILON = 0.0000001d;
	
	/////////////////////////////////////////////////////////////////////////////////////
	//////////////////////// Calculate Column Total Tests ///////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	// TC 1
	@Test
	public void testCalculateColumnTotalThrowsExceptionForNullParam() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown, expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			return;
		}
	}

	// TC 2
	@Test
	public void testCalculateColumnTotalReturnsZeroForInvalidColumn() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 1, 0);
		defaultKeyedValues2D.addValue(15, 2, 0);
		try {
			assertEquals("Invalid column input, expects 0.0", 0.0, 
					DataUtilities.calculateColumnTotal(defaultKeyedValues2D, -1), EPSILON);
		} catch (Exception e) {
			fail("Index out of bounds error, should return 0. " + e.getClass() + " was returned");
		}
	}
	
	// TC 3
	@Test
	public void testCalculateColumnTotalReturnsZeroWhenExceedingNumberOfColumns() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 1, 0);
		defaultKeyedValues2D.addValue(15, 2, 0);
		try {
			assertTrue("No data exists in column 6, default value of zero should be returned", 
					DataUtilities.calculateColumnTotal(defaultKeyedValues2D, 6)==0.0);
		} catch (Exception e) {
			fail("Index out of bounds error, should return 0. " + e.getClass() + " was returned");
		}
	}
	
	// TC 4
	@Test
	public void testCalculateColumnTotalReturnsCorrectValueForNominalValue() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 0, 1);
		defaultKeyedValues2D.addValue(15, 0, 2);
		defaultKeyedValues2D.addValue(20, 0, 3);
		defaultKeyedValues2D.addValue(25, 0, 4);
		assertEquals("The column contains only the value 15 so the total should be 15", 15.0, 
				DataUtilities.calculateColumnTotal(defaultKeyedValues2D, 2), EPSILON);
	}
	
	// TC 5
	@Test
	public void testCalculateColumnTotalReturnsCorrectValueForMin() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 0, 1);
		defaultKeyedValues2D.addValue(15, 0, 2);
		defaultKeyedValues2D.addValue(20, 0, 3);
		defaultKeyedValues2D.addValue(25, 0, 4);
		assertEquals("The column contains only the value 5 so the total should be 5", 5.0, 
				DataUtilities.calculateColumnTotal(defaultKeyedValues2D, 0), EPSILON);
	}
	
	// TC 6
	@Test
	public void testCalculateColumnTotalReturnsCorrectValueForMinPlus() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 0, 1);
		defaultKeyedValues2D.addValue(15, 0, 2);
		defaultKeyedValues2D.addValue(20, 0, 3);
		defaultKeyedValues2D.addValue(25, 0, 4);
		assertEquals("The column contains only the value 10 so the total should be 10", 10.0, 
				DataUtilities.calculateColumnTotal(defaultKeyedValues2D, 1), EPSILON);
	}
	
	// TC 7
	@Test
	public void testCalculateColumnTotalReturnsCorrectValueForMax() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 0, 1);
		defaultKeyedValues2D.addValue(15, 0, 2);
		defaultKeyedValues2D.addValue(20, 0, 3);
		defaultKeyedValues2D.addValue(25, 0, 4);
		assertEquals("The column contains only the value 25 so the total should be 25", 25.0, 
				DataUtilities.calculateColumnTotal(defaultKeyedValues2D, 4), EPSILON);
	}
	
	// TC 8
	@Test
	public void testCalculateColumnTotalReturnsCorrectValueForMaxMinus() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 0, 1);
		defaultKeyedValues2D.addValue(15, 0, 2);
		defaultKeyedValues2D.addValue(20, 0, 3);
		defaultKeyedValues2D.addValue(25, 0, 4);
		assertEquals("The column contains only the value 20 so the total should be 20", 20.0, 
				DataUtilities.calculateColumnTotal(defaultKeyedValues2D, 3), EPSILON);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	////////////////////////  Calculate Row Total Tests /////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	// TC 1
	@Test
	public void testCalculateRowTotalThrowsExceptionForNullParam() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown, expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			return;
		}
	}
	
	// TC 2
	@Test
	public void testCalculateRowTotalReturnsZeroForInvalidRow() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 0, 1);
		defaultKeyedValues2D.addValue(15, 0, 2);
		try {
			assertEquals("Invalid row input, expects 0.0", 0.0, 
					DataUtilities.calculateRowTotal(defaultKeyedValues2D, -1), EPSILON);
		} catch (Exception e) {
			fail("Index out of bounds error, should return 0. " + e.getClass() + " was returned");
		}
	}
	
	// TC 3
	@Test
	public void testCalculateRowTotalReturnsZeroWhenExceedingNumberOfRows() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 0, 1);
		defaultKeyedValues2D.addValue(15, 0, 2);
		try {
			assertTrue("No data exists in row 6, default value of zero should be returned", 
					DataUtilities.calculateRowTotal(defaultKeyedValues2D, 6)==0.0);
		} catch (Exception e) {
			fail("Index out of bounds error, should return 0. " + e.getClass() + " was returned");
		}
	}
	
	// TC 4
	@Test
	public void testCalculateRowTotalReturnsCorrectValueForNominalValue() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 1, 0);
		defaultKeyedValues2D.addValue(15, 2, 0);
		defaultKeyedValues2D.addValue(20, 3, 0);
		defaultKeyedValues2D.addValue(25, 4, 0);
		assertEquals("The row contains only the value 15 so the total should be 15", 15.0, 
				DataUtilities.calculateRowTotal(defaultKeyedValues2D, 2), EPSILON);
	}
	
	// TC 5
	@Test
	public void testCalculateRowTotalReturnsCorrectValueForMin() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 1, 0);
		defaultKeyedValues2D.addValue(15, 2, 0);
		defaultKeyedValues2D.addValue(20, 3, 0);
		defaultKeyedValues2D.addValue(25, 4, 0);
		assertEquals("The column contains only the value 5 so the total should be 5", 5.0, 
				DataUtilities.calculateRowTotal(defaultKeyedValues2D, 0), EPSILON);
	}
	
	// TC 6
	@Test
	public void testCalculateRowTotalReturnsCorrectValueForMinPlus() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 1, 0);
		defaultKeyedValues2D.addValue(15, 2, 0);
		defaultKeyedValues2D.addValue(20, 3, 0);
		defaultKeyedValues2D.addValue(25, 4, 0);
		assertEquals("The column contains only the value 10 so the total should be 10", 10.0, 
				DataUtilities.calculateRowTotal(defaultKeyedValues2D, 1), EPSILON);
	}
	
	// TC 7
	@Test
	public void testCalculateRowTotalReturnsCorrectValueForMax() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 1, 0);
		defaultKeyedValues2D.addValue(15, 2, 0);
		defaultKeyedValues2D.addValue(20, 3, 0);
		defaultKeyedValues2D.addValue(25, 4, 0);
		assertEquals("The row contains only the value 25 so the total should be 25", 25.0, 
				DataUtilities.calculateRowTotal(defaultKeyedValues2D, 4), EPSILON);
	}
	
	
	// TC 8
	@Test
	public void testCalculateRowTotalReturnsCorrectValueForMaxMinus() {
		DefaultKeyedValues2D defaultKeyedValues2D = new DefaultKeyedValues2D();
		defaultKeyedValues2D.addValue(5, 0, 0);
		defaultKeyedValues2D.addValue(10, 1, 0);
		defaultKeyedValues2D.addValue(15, 2, 0);
		defaultKeyedValues2D.addValue(20, 3, 0);
		defaultKeyedValues2D.addValue(25, 4, 0);
		assertEquals("The row contains only the value 20 so the total should be 20", 20.0, 
				DataUtilities.calculateRowTotal(defaultKeyedValues2D, 3), EPSILON);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  Create Number Array Tests //////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	// TC 1
	@Test
	public void testCreateNumberArrayThrowsExceptionForNullParam() {
			try {
				DataUtilities.createNumberArray(null);
				fail("No exception thrown, expected IllegalArgumentException to be thrown");
			} catch (IllegalArgumentException e) {
				return;
			}
	}
	
	// TC 2
	@Test
	public void testCreateNumberArrayEmptyDoubleArrayToNumberArray() {
			double[] dArray = {};
			Number[] nArray = DataUtilities.createNumberArray(dArray);
			assertEquals("nArray should be empty, expected 0", 0, nArray.length);
	}
	
	// TC 3
	@Test
	public void testCreateNumberArrayValidDoubleArrayDataCreatesNumberArray() {
			double[] dArray = {1.0, 5.0, 10.0, -15.0, 20.5, 25.0}; //last data item always doesn't match
			Number[] expected = {1.0, 5.0, 10.0, -15.0, 20.5, 25.0};
			Number[] nArray = DataUtilities.createNumberArray(dArray);
			for (int i = 0; i < dArray.length; i++) {
				assertEquals("Values at index[" + i + "] do not match nArray value.",expected[i],nArray[i]);
			}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  Create Number Array 2D Tests ///////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	// TC 1
	@Test
	public void testCreateNumberArray2DThrowsExceptionForNullParam() {
			try {
				DataUtilities.createNumberArray2D(null);
				fail("No exception thrown, expected IllegalArgumentException to be thrown");
			} catch (IllegalArgumentException e) {
				return;
			}
	}
	
	// TC 2
	@Test
	public void testCreateNumberArray2DEmptyDoubleArrayToNumberArray() {
			double[][] dArray = {};
			Number[][] nArray = DataUtilities.createNumberArray2D(dArray);
			assertEquals("nArray should be empty, expected 0", 0, nArray.length);
	}
	
	// TC 3
	@Test
	public void testCreateNumberArray2DValidDoubleArrayDataCreatesNumberArray() {
			double[][] dArray = {{1.0, 5.0}, {10.0, -15.0}};
			Number[][] expected = {{1.0, 5.0}, {10.0, -15.0}};
			Number[][] nArray = DataUtilities.createNumberArray2D(dArray);
			for (int i=0 ; i < dArray.length; i++) {
				for (int j = 0; j < dArray.length;j++) {
					assertEquals("Values at [" + i + "][" + j + "] do not match nArray value" ,expected[i][j], nArray[i][j]);
				}
			}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////Get Cumulative Percentages Tests ///////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	// TC 1
	@Test
	public void testGetCumulativePercentagesThrowsExceptionForNullParam() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown, expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			return;
		}
	}
	
	// TC 2
	@Test
	public void testGetCumulativePercentagesNullValues() {
		DefaultKeyedValues values = new DefaultKeyedValues();
		values.addValue("0", null); 
		values.addValue("1", null);
		values.addValue("2", null);
		
		assertEquals("Null value returned.", null,
				DataUtilities.getCumulativePercentages(values).getValue(0)); //returns NaN (not a number)
	    assertEquals("Null value returned.", null, 
	    		DataUtilities.getCumulativePercentages(values).getValue(1)); //returns NaN (not a number)
		assertEquals("Null value returned.", null,
				DataUtilities.getCumulativePercentages(values).getValue(2)); //returns NaN (not a number)
	}
	
	// TC 3
	@Test
	public void testGetCumulativePercentagesReturnsEmptyKeyedValues() {
		KeyedValues values = new DefaultKeyedValues();
		KeyedValues cumulativeValues = DataUtilities.getCumulativePercentages(values);
		assertEquals("Object empty, expected 0", 0, cumulativeValues.getItemCount());
	}
	
	// TC 4
	@Test
	public void testGetCumulativePercentagesReturnsValidValues() {
		 DefaultKeyedValues values = new DefaultKeyedValues();
	     values.addValue("0", 5); //cumulative skips the first index when adding, returns 5/11
	     values.addValue("1", 9);
	     values.addValue("2", 2);
	     KeyedValues cumulativeValues = DataUtilities.getCumulativePercentages(values);
	     assertEquals(0.3125, cumulativeValues.getValue(0));
	     assertEquals(0.875, cumulativeValues.getValue(1));
	     assertEquals(1.0, cumulativeValues.getValue(2));
	}
	
}
