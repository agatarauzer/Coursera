/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test

		//test adding null element, add should throw an exception
		try {
			shortList.add(null);
			fail("Null element");
		}
		catch (NullPointerException e) {

		}

		//test adding element to a empty list, should return true;
		// get method should return these element
		int element1 = 78;
		boolean result1 = emptyList.add(element1);
		int resultElement1 = emptyList.get(0);

		Assert.assertTrue("Add: to empty list: ", result1);
		Assert.assertEquals("Add: element " + element1 + " to empty list: ", 78, resultElement1);

		//test adding element to already filled list, should return true;
		//get method should return these element
		int element2 = 33;
		boolean result2 = longerList.add(element2);
		int resultElement2 = longerList.get(10);

		Assert.assertTrue("Add: element to filled list: ", result2);
		Assert.assertEquals("Add: element " + element2 + " to filled list: ", 33, resultElement2);

	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test

		//size after adding elements
		longerList.add(45);
		longerList.add(22);
		longerList.add(33);
		Assert.assertEquals("Size: longer list with 3 more elements", 13, longerList.size());

		//size after removing elements





		//size of empty list
		Assert.assertEquals("Size: empty list", 0, emptyList.size());

	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test

		try {
			shortList.add(1,null);
			fail("Null element");
		}
		catch (NullPointerException e) {

		}

		try {
			longerList.add(-2, 7);
			fail("Invalid index");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			longerList.add(45, 5);
			fail("Invalid index");
		}
		catch (IndexOutOfBoundsException e) {

		}

		//add to empty list
		emptyList.add(0,888);
		Assert.assertEquals("Add at index: to empty list", (Integer) 888, emptyList.get(0));


		// test if get method returns added element
		//in the middle of the list
		longerList.add(5, 99);
		Assert.assertEquals("Add at index: element 99 was added to list: ", (Integer) 99, longerList.get(5));

		//in the beginning of the list
		longerList.add(0, 77);
		Assert.assertEquals("Add at index: element 77 was added to list: ", (Integer) 77, longerList.get(0));

		//in the end of the list
		shortList.add(2, "C");
		Assert.assertEquals("Add at index: element C was added to list: ", "C", shortList.get(2));

		//check size
		Assert.assertEquals("Add at index: size of longer list: ", 12, longerList.size());
		Assert.assertEquals("Add at index: size of short list: ", 3, shortList.size());

	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
