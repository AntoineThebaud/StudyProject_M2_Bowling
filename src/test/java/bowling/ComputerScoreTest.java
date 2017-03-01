package bowling;

import static org.junit.Assert.*;

import org.junit.Test;


public class ComputerScoreTest {

//    public static void main(String args[]) {
//    	String testClass = "ComputerScoreTest";
//     	org.junit.runner.JUnitCore.main(testClass);
//     }
   
	@Test 
	public void test() {
		assertEquals(ComputeScore.computeScore(new int[] {}), 0);
		assertEquals(ComputeScore.computeScore(new int[] {2}), 2);
		assertEquals(ComputeScore.computeScore(new int[] {2,7}), 9);
		assertEquals(ComputeScore.computeScore(new int[] {3,6,2,5}), 16);
		assertEquals(ComputeScore.computeScore(new int[] {3,7,2,5}), 19);
		assertEquals(ComputeScore.computeScore(new int[] {10,2,5}), 24);
		assertEquals(ComputeScore.computeScore(new int[] {10, 0, 0, 2}), 14);
		System.out.print("ComputeScoreTest: test ok \n");	
	}
	
	@Test(expected = IllegalArgumentException.class)  
	public void testException() {
		ComputeScore.computeScore(new int[] {-1});
		System.out.print("ComputeScoreTest: test exception  ok \n");	
	}
	
	@Test(expected = IllegalArgumentException.class)  
	public void testException1() {
		ComputeScore.computeScore(new int[] {2,11});
	}

	@Test(expected = IllegalArgumentException.class)  
	public void testException2() {
		ComputeScore.computeScore(new int[] {5,9});
		System.out.print("ComputeScoreTest: ok \n");
	}
	 
}
