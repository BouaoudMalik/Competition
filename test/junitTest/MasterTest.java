package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import entity.Competitor;
import exceptions.NotPowerOfTwoException;
import mock.MockMaster;
import services.*;
import util.MapUtil;
/**
 * Test of master class
 * 
 *
 */
public class MasterTest {
	
	private MockMaster master;
	private int NBCOMPETITOR=16;
	private int NBGROUPS=4;
	static int testId=0;
	private SelectFirsts selection1 = new SelectFirsts();
	private SelectTwoFirsts selection2=new SelectTwoFirsts();
	private SelectTwoFirstTwoBestThird selection3=new SelectTwoFirstTwoBestThird();
	
	/**
	 * test if a master is correctly initialized
	 */
	@Before
	public void init() {
		testId++;
		master = new MockMaster(selection1 ,NBCOMPETITOR, NBGROUPS);
		assertEquals(4, master.getPools().size());
		System.out.printf("\bTEST[%d] OK",testId);
	}
	/**
	 * test if a play is correctly played by
	 * testing if the score of the winner is >0
	 */
	
	@Test
	public void testIfThePoolsArecorrectlyPlayed() {
		testId++;
		System.out.println("testIfThePoolsArecorrectlyPlayed");
		master = new MockMaster(selection1 ,NBCOMPETITOR, NBGROUPS);
		master.playPools();
		for(League l : master.getPools()) {
			assertTrue(l.getlWinnerLeague().getPoints()>0);
			
			for(Competitor c : MapUtil.mapToArrayList(l.ranking())) {
				assertTrue(l.getlWinnerLeague().getPoints()>=c.getPoints());
			}
			
		}
		System.out.printf("\bTEST[%d] OK",testId);
	}
	/**
	 * SelectionPhase should return the competitor with the good selection criteria
	 */
	@Test
	public void testSelectionPhase() {
		testId++;
		System.out.println("testSelectionPhase");
		master = new MockMaster(selection1, NBCOMPETITOR, NBGROUPS);
		master.playPools();
		ArrayList<Competitor> selected = master.selectionPhase();
		assertEquals(selected.size(),4);
		master = new MockMaster(selection2, NBCOMPETITOR, 4);
		master.playPools();
		selected = master.selectionPhase();
		assertEquals(selected.size(),8);
		System.out.printf("\bTEST[%d] OK",testId);
	}
	
	/**
	 * test if the selection TheFirst is correctly set
	 */
	@Test
	public void theFirstRightNumberOfParticipantIsSelected() {
		testId++;
		System.out.println("theFirstRightNumberOfParticipantIsSelected");
		master = new MockMaster(selection1,NBCOMPETITOR,NBGROUPS);
		master.playPools();
		assertEquals(master.selectionPhase().size(),master.getnbGroup());
		System.out.printf("\bTEST[%d] OK",testId);
	}
	
	/**
	 * test if the selection of the two firsts is correctly set
	 */
	@Test
	public void twoFirstRightNumberOfParticipantIsSelected() {
		testId++;
		master = new MockMaster(selection2,NBCOMPETITOR,NBGROUPS);
		master.playPools();
		assertEquals(master.selectionPhase().size(),2*master.getnbGroup());
		System.out.printf("\bTEST[%d] OK",testId);
	}
	
	/**
	 *  test if the selection of the two firsts and two best third is correctly set
	 */
	 
	@Test 
	public void TwoFirstTwoBestThirdRightNumberOfParticipantIsSelected() {
		testId++;
		master = new MockMaster(selection3,NBCOMPETITOR,NBGROUPS);
		master.playPools();
		assertEquals(master.selectionPhase().size(),2*master.getnbGroup()+2);
		System.out.printf("\bTEST[%d] OK",testId);
		
		
	}
	
	
	
	/**
	 * the test for selection to finals includes to set all the points of the competitors to 0
	 */
	
	@Test
	public void testFirstsForFinals0points() {
		testId++;
		//for two first
		master = new MockMaster(selection2,NBCOMPETITOR,NBGROUPS);
		master.playPools();
		ArrayList <Competitor> selected =master.selectionPhase();
		
		for(Competitor c : selected) {
			assertEquals(c.getPoints(),0);
		}
		System.out.printf("\bTEST[%d] OK",testId);
	}
	/**
	 * test if the two first have 0 points
	 */
	
	@Test
	public void testTwoFirstForFinals0points() {
		testId++;
		System.out.println("testIfTheselectionIsCorrectlySet");
		
		//for one first
		System.out.println("For selection criteria : the two first with 16 competitors and 4 groups");
		master = new MockMaster(selection1,NBCOMPETITOR,NBGROUPS);
		master.playPools();
		ArrayList <Competitor> selected =master.selectionPhase();
		
		for(Competitor c : selected) {
			assertEquals(c.getPoints(),0);
		}
		System.out.println("For selection criteria : the two first with 16 competitors and 4 groups");
		System.out.printf("\bTEST[%d] OK",testId);
	}
	
	/**
	 * test if the two firsts and two third participant have 0 points
	 */
	
	@Test
	public void testIfTwoFirstTwothirdsForFinalshave0points() {
		testId++;
		
		//for two firsts and best third
		
		master = new MockMaster(selection3,NBCOMPETITOR,NBGROUPS);
		master.playPools();
		ArrayList <Competitor> selected =master.selectionPhase();
		for(Competitor c : selected) {
			assertEquals(c.getPoints(),0);
		}
		System.out.printf("\bTEST[%d] OK",testId);
	}
	

	
	
	
	
	
	/**
	 * There should be only one competitor left after playMaster()
	 */
	@Test
	public void testPlayMaster() throws NotPowerOfTwoException{
		testId++;
		master = new MockMaster(selection1,NBCOMPETITOR, NBGROUPS);
		master.playMaster();
		assertNotNull(master.getWinnerOfFinals());
		assertTrue(master.getWinnerOfFinals().getPoints()>0);
		System.out.printf("\bTEST[%d] OK",testId);
	}
	
	
	
}
