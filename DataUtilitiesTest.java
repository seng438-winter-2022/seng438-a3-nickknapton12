package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class DataUtilitiesTest extends DataUtilities {
	
	
	
	
	public static class CloneTests{
		double [][] arr1;
		double [][] arr2;
		double [][] arr3;
		double [][] arr4;
		@Before
		public void setUp() throws Exception { 
			arr1 = new double [][]{
				{2,3,4},
				{4,5,2}
		};
			arr3 = new double [][]{
			{},
			{}
		};
			arr4 = new double [][]{
			{2,1},
			{}
		};
		
		}
		
		@Test
		public void cloneTest() {
			
			arr2 = DataUtilities.clone(arr1);
			assertTrue("They should be the same.", DataUtilities.equal(arr1, arr2));
		}
		
		@Test
		public void cloneTestNull() {
			
			arr2 = DataUtilities.clone(arr3);
			assertTrue("They should be the same.", DataUtilities.equal(arr3, arr2));
		}
		
		@Test
		public void cloneTestNullElement() {
			
			arr2 = DataUtilities.clone(arr4);
			assertTrue("They should be the same.", DataUtilities.equal(arr4, arr2));
		}
		
	}
	
	
	public static class EqualsTests{
		double [][] arr1;
		double [][] arr2;
		double [][] arr3;
		double [][] arr4;
		
		
		
		@Before
		public void setUp() throws Exception { 
			arr1 = new double [][]{
					{2,3,4},
					{4,5,2}
			};
			arr2 = new double [][]{
				{2,3,4},
				{4,5,2}
			};
			arr3 = new double [][]{
				{55,2,4},
				{4,2,1}
			};
			arr4 = new double [][]{
				{55,2,4},
				{4,2,1},
				{444}
			};
		}
			
		@Test
		public void equalsTestMatching() {
			assertTrue("They should be the same.", DataUtilities.equal(arr1, arr2));
		}
		@Test
		public void equalsTestNotMatching() {
			assertFalse("They should be different.", DataUtilities.equal(arr1, arr3));
		}
		@Test
		public void equalsTestNotMatchingExtraRow() {
			assertFalse("They should be different.", DataUtilities.equal(arr3, arr4));
		}
		@Test
		public void equalsTestNullFirst() {
			assertFalse("", DataUtilities.equal(null, arr4));
		}
		@Test
		public void equalsTestNullSecond() {
			assertFalse("", DataUtilities.equal(arr3, null));
		}
		
		@Test
		public void equalsTestNull() {
			assertTrue("", DataUtilities.equal(null, null));
		}
	}
	
	public static class RowAndColumnTestsValid{
		Mockery mockingContext;
		Values2D values;
		
	
		@Before
	    public void setUp() throws Exception { 
			mockingContext = new Mockery();
			values = mockingContext.mock(Values2D.class);
	    }
		
		//regular function
		@Test
		public void calculateColumnTotalTest() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
				oneOf(values).getValue(2, 0);
				will(returnValue(5));
				}
			});
			
		
			
			assertEquals("Column total should be 15.", 7.5, DataUtilities.calculateColumnTotal(values, 
					0,new int[] {1,2}), .000000001d);
		}
		
	
		
		@Test
		public void calculateColumnTotalTestBigRow() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
				oneOf(values).getValue(2, 0);
				will(returnValue(5));
				}
			});
			
			
			
	    
			
			
			assertEquals("Column total should be 15.", 2.5, DataUtilities.calculateColumnTotal(values, 
					0,new int[] {1,4}), .000000001d);
		}
		
		@Test
		public void calculateColumnTotalTestNull() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
				oneOf(values).getValue(2, 0);
				will(returnValue(null));
				}
			});
			
			
			
	    
			
			
			assertEquals("Column total should be 15.", 2.5, DataUtilities.calculateColumnTotal(values, 
					0,new int[] {1,2}), .000000001d);
		}
		
		@Test
		public void calculateRowTotalTest() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(5));
				}
			});
			
			
			
	    
			
			
			assertEquals("Row", 7.5, DataUtilities.calculateRowTotal(values, 
					0,new int[] {1,2}), .000000001d);
		}
		
		@Test
		public void calculateRowTotalTestBigColumn() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(5));
				}
			});
			
			
			
	    
			
			
			assertEquals("Row", 2.5, DataUtilities.calculateRowTotal(values, 
					0,new int[] {1,4}), .000000001d);
		}
		
		@Test
		public void calculateRowTotalTestNull() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(null));
				}
			});
			
			
			
	    
			
			
			assertEquals("Row", 2.5, DataUtilities.calculateRowTotal(values, 
					0,new int[] {1,2}), .000000001d);
		}
		
		
		
	

}
	
	
	
	
	public static class RowAndColumnTests{
		Mockery mockingContext;
		Values2D values;
		
	
		@Before
	    public void setUp() throws Exception { 
			mockingContext = new Mockery();
			values = mockingContext.mock(Values2D.class);
	    }
		
		//regular function
		@Test
		public void calculateColumnTotalTest() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
				oneOf(values).getValue(2, 0);
				will(returnValue(5));
				}
			});
			
			
			
	    
			
			
			assertEquals("Column total should be 15.", 15, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
		}
		
		//zero value (boundary)
		@Test
		public void calculateColumnTotalTestZero() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
				oneOf(values).getValue(2, 0);
				will(returnValue(0));
				}
			});
			
			
			
			assertEquals("Column total should be 10.", 10, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
		}
		
		//negative value (boundary)
		@Test
		public void calculateColumnTotalTestNegative() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(-2.5));
				}
			});
			
			assertEquals("Column total should be 5.", 5, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
		}
		//No rows (boundary)
		@Test
		public void calculateColumnTotalTestNoRows() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(0));
				}
			});
			
			assertEquals("Column total should be 0.", 0, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
		}
		
		//Other column (boundary)
		@Test
		public void calculateColumnTotalTestOtherColumn() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 1);
				will(returnValue(5));
				oneOf(values).getValue(1, 1);
				will(returnValue(5));
				oneOf(values).getValue(2, 1);
				will(returnValue(5));
				}
			});
			
			assertEquals("Column total should be 15.", 15, DataUtilities.calculateColumnTotal(values, 1), .000000001d);
		}
		
		//zero total (boundary)
		@Test
		public void calculateColumnTotalTestZeroTotal() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(0));
				oneOf(values).getValue(1, 0);
				will(returnValue(0));
				oneOf(values).getValue(2, 0);
				will(returnValue(0));
				}
			});
			
			assertEquals("Column total should be 0.", 0, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
		}
		
		//ROWS
		
		//regular function
		@Test
		public void calculateRowTotalTest() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(5));
				}
			});
	
			
			assertEquals("Row total should be 15.", 15, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//zero value
		@Test
		public void calculateRowTotalTestZero() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(0));
				}
			});
	
			
			assertEquals("Row total should be 10.", 10, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//zero total
		@Test
		public void calculateRowTotalTestZeroTotal() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(0));
				oneOf(values).getValue(0, 1);
				will(returnValue(0));
				oneOf(values).getValue(0, 2);
				will(returnValue(0));
				}
			});
	
			
			assertEquals("Row total should be 0.", 0, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//Negative
		@Test
		public void calculateRowTotalTestNegative() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-5));
				}
			});
	
			
			assertEquals("Row total should be 5.", 5, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//Negative total
		@Test
		public void calculateRowTotalTestNegativeTotal() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(0));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-5));
				}
			});
	
			
			assertEquals("Row total should be -2.5.", -2.5, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//No columns
		@Test
		public void calculateRowTotalTestNoColumns() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(0));
				}
			});
	
			
			assertEquals("Row total should be 0.", 0, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//Other row
		@Test
		public void calculateRowTotalTestOtherRow() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(1, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(1, 2);
				will(returnValue(5));
				}
			});
	
			
			assertEquals("Row total should be 15.", 15, DataUtilities.calculateRowTotal(values, 1), .000000001d);
		}
		
		//Other row
				@Test
				public void calculateRowTotalTestNullRow() {
					mockingContext.checking(new Expectations() {
						{
						oneOf(values).getColumnCount();
						will(returnValue(3));
						oneOf(values).getValue(1, 0);
						will(returnValue(7.5));
						oneOf(values).getValue(1, 1);
						will(returnValue(2.5));
						oneOf(values).getValue(1, 2);
						will(returnValue(null));
						}
					});
			
					
					assertEquals("Row total should be 15.", 10, DataUtilities.calculateRowTotal(values, 1), .000000001d);
				}
		
		//regular function
				@Test
				public void calculateColumnTotalTestNull() {
					mockingContext.checking(new Expectations() {
						{
						oneOf(values).getRowCount();
						will(returnValue(3));
						oneOf(values).getValue(0, 0);
						will(returnValue(7.5));
						oneOf(values).getValue(1, 0);
						will(returnValue(2.5));
						oneOf(values).getValue(2, 0);
						will(returnValue(null));
						}
					});
					
					
					
			    
					
					
					assertEquals("Column total should be 15.", 10, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
				}
	}
	
	//Create Number Array
	@RunWith(Parameterized.class)
	public static class createNumberArrayTests{
		
			
		double [] primitiveDoubleArray;
		
		Double [] objectDoubleArray;
		
		
		public createNumberArrayTests(double [] arr, Double [] arr2) {
			this.primitiveDoubleArray = arr;
			this.objectDoubleArray = arr2;
		}
		
		@Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{new double [] {2,3,4}, new Double [] {Double.valueOf(2),Double.valueOf(3),Double.valueOf(4)}},
	    		{new double [] {2.2,3.3,4.4}, new Double [] {Double.valueOf(2.2),Double.valueOf(3.3),Double.valueOf(4.4)}},
	    		{new double [] {-2,-3,-4}, new Double [] {Double.valueOf(-2),Double.valueOf(-3),Double.valueOf(-4)}},
	    		{new double [] {-2.2,-3.3,-4.4}, new Double [] {Double.valueOf(-2.2),Double.valueOf(-3.3),Double.valueOf(-4.4)}},
	    		{new double [] {2}, new Double [] {Double.valueOf(2)}},
	    		{new double [] {}, new Double [] {}}
	    		
	    	});
	    }
			
	    @Test
		public void createNumberArrayTest() {
			Assert.assertArrayEquals(objectDoubleArray,DataUtilities.createNumberArray(primitiveDoubleArray));
		}
	}
	
	//Create 2D Number Array
	@RunWith(Parameterized.class)
	public static class createNumberArray2DTests{
		
			
		double [][] primitiveDoubleArray2D;
		
		Double [][] objectDoubleArray2D;
		
		
		public createNumberArray2DTests(double [][] arr, Double [][] arr2) {
			this.primitiveDoubleArray2D = arr;
			this.objectDoubleArray2D = arr2;
		}
		
		@Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		//regular
	    		{
	    			new double [][]{ 
	    					{2,3,4},
	    					{5,6,7}
	    			}, new Double [][]{
	    				{Double.valueOf(2),Double.valueOf(3),Double.valueOf(4)},
	    				{Double.valueOf(5),Double.valueOf(6),Double.valueOf(7)},
	    			}
	    			
	    		},
	    		//one empty
	    		{
	    			new double [][]{ 
	    					{2,3,4},
	    					{}
	    			}, new Double [][]{
	    				{Double.valueOf(2),Double.valueOf(3),Double.valueOf(4)},
	    				{},
	    			}
	    			
	    		},
	    		//all empty
	    		{
	    			new double [][]{ 
	    					{},
	    					{}
	    			}, new Double [][]{
	    				{},
	    				{}
	    			}
	    			
	    		},
	    		//nothing
	    		{
	    			new double [][]{ 
	    					
	    			}, new Double [][]{
	    				
	    			}
	    			
	    		},
	    		{
	    			new double [][]{ 
	    					{-2,-3,-4},
	    					{-5,-6,-7}
	    			}, new Double [][]{
	    				{Double.valueOf(-2),Double.valueOf(-3),Double.valueOf(-4)},
	    				{Double.valueOf(-5),Double.valueOf(-6),Double.valueOf(-7)},
	    			}
	    			
	    		},
	    		{
	    			new double [][]{ 
	    					{2.2,3.2,4.2},
	    					{5.2,6.2,7.2}
	    			}, new Double [][]{
	    				{Double.valueOf(2.2),Double.valueOf(3.2),Double.valueOf(4.2)},
	    				{Double.valueOf(5.2),Double.valueOf(6.2),Double.valueOf(7.2)},
	    			}
	    			
	    		},
	    	});
	    }
			
	    @Test
		public void createNumberArrayTest() {
			Assert.assertArrayEquals(objectDoubleArray2D,DataUtilities.createNumberArray2D(primitiveDoubleArray2D));
		}
	}
	
	
	
	public static class getCumulativePercentagesTests {
		
		DefaultKeyedValues valuesTest = new DefaultKeyedValues();
		DefaultKeyedValues valuesTest2 = new DefaultKeyedValues();
		@Before
		public void setUp() throws Exception { 
		
			
			
		valuesTest.addValue("1",new Double(5));
		valuesTest2.addValue("2",null);
		}
		
		@Test
		public void percentagesTest() {
			assertEquals("Equals 1.0",1.0,getCumulativePercentages(valuesTest).getValue("1"));
		}
		
		@Test
		public void percentagesTestNull() {
			
			
			assertEquals("Equals NaN",Double.NaN,getCumulativePercentages(valuesTest2).getValue("2"));
		}
		
	}
	
	
	
	
	
	
}
	
	
	
	
	
	


