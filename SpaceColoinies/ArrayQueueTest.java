// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * Class for Person is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 */
public class ArrayQueueTest extends TestCase {
    private ArrayQueue<String> arr1;
    private ArrayQueue<String> arr2;
    private ArrayQueue<String> arr;

    /**
     * a sets up method
     */
    public void setUp() {
        arr1 = new ArrayQueue<String>();
        arr2 = new ArrayQueue<String>();
        arr = new ArrayQueue<String>(5);
    }


    /**
     * testGetLengthOfUnderlyingArray method
     */
    public void testGetLengthOfUnderlyingArray() {
        arr1.enqueue("a");
        arr1.enqueue("b");
        arr1.enqueue("c");
        assertEquals(arr1.getLengthOfUnderlyingArray(), 21);
        assertEquals(arr2.getLengthOfUnderlyingArray(), 21);
        assertEquals(arr.getLengthOfUnderlyingArray(), 6);
        assertEquals(arr.getSize(), 0);
    }


    /**
     * testGetSize method
     */
    public void testGetSize() {
        arr1.enqueue("a23f3");
        arr1.enqueue("1ddfgu");
        arr1.enqueue("ebrvc");
        arr1.enqueue("asd");
        arr1.enqueue("asdf");
        arr1.enqueue("rbgrs");
        arr1.enqueue("cqel");
        assertEquals(arr1.getSize(), 7);
    }


    /**
     * testIsEmpty method
     */
    public void testIsEmpty() {
        assertTrue(arr1.isEmpty());
        arr1.enqueue("safdas");
        assertFalse(arr1.isEmpty());
    }


    /**
     * testDequeue method
     */
    public void testDequeue() {
        arr1.enqueue("1");
        arr1.enqueue("2");
        assertEquals(2, arr1.getSize());
        assertEquals("1", arr1.dequeue());
        assertEquals(1, arr1.getSize());
        Exception exception = null;
        try {
            arr2.dequeue();
            fail("No texts");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("No texts", exception instanceof EmptyQueueException);
    }


    /**
     * testEnqueue method
     */
    public void testEnqueue() {
        for (int i = 0; i < 160; i++) {
            arr1.enqueue("eat");
        }
        assertEquals(160, arr1.getSize());

        for (int i = 0; i < 10; i++) {
            arr.enqueue("abc");
        }
        assertEquals(10, arr.getSize());
        Exception exception = null;
        try {
            arr1.enqueue("ads");
            fail("throw an IllegalStateException");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("throw an IllegalStateException",
            exception instanceof IllegalStateException);
    }


    /**
     * testGetFront method
     */
    public void testGetFront() {
        Exception exception = null;
        try {
            arr1.getFront();
            fail("No texts");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("No texts", exception instanceof EmptyQueueException);
        arr1.enqueue("asdf");
        arr1.enqueue("fg");
        assertEquals("asdf", arr1.getFront());
        assertEquals(2, arr1.getSize());
    }


    /**
     * testClear method
     */
    public void testClear() {
        arr1.enqueue("asdfg");
        arr1.enqueue("adsf");
        assertEquals(2, arr1.getSize());
        arr1.clear();
        assertEquals(0, arr1.getSize());
    }


    /**
     * testToArray method
     */
    public void testToArray() {
        Exception exception = null;
        try {
            arr1.toArray();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
        String[] testArray = new String[] { "1", "2", "3", "4" };
        arr1.enqueue("1");
        arr1.enqueue("2");
        arr1.enqueue("3");
        arr1.enqueue("4");

        for (int i = 0; i < testArray.length; i++) {
            assertTrue(arr1.toArray()[i].equals(testArray[i]));
        }
    }


    /**
     * testToString method
     */
    public void testToString() {
        assertEquals("[]", arr1.toString());
        arr1.enqueue("1");
        arr1.enqueue("2");
        arr1.enqueue("3");
        arr1.enqueue("4");
        assertEquals("[1, 2, 3, 4]", arr1.toString());
    }


    /**
     * testEquals method
     */
    public void testEquals() {
        arr1.enqueue("a");
        arr1.enqueue("b");
        arr1.enqueue("c");
        arr1.enqueue("d");

        arr2.enqueue("a");
        arr2.enqueue("b");
        arr2.enqueue("c");
        arr2.enqueue("d");
        assertTrue(arr2.equals(arr1));
        assertTrue(arr2.equals(arr2));
        ArrayQueue<String> arr3 = new ArrayQueue<String>();
        assertFalse(arr2.equals(arr3));
        arr2.dequeue();
        assertFalse(arr2.equals(arr1));
        Object a = new Object();
        Object b = null;
        assertFalse(arr2.equals(a));
        assertFalse(arr2.equals(b));
        arr3.enqueue("h");
        arr3.enqueue("b");
        arr3.enqueue("c");
        arr3.enqueue("d");
        assertFalse(arr1.equals(arr3));
    }

}
