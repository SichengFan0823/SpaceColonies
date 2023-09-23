// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- sichengfan
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * Class for ArrayQueue is a method class.
 * 
 * @author Sicheng Fan
 * @version <11/11/2021>
 * @param <T>
 *            Data type
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private final static int DEFAULT_CAPACITY = 20;
    /**
     * the max capacity for the array
     */
    final static int MAX_CAPACITY = 160;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;

    /**
     * a new ArrayQueue class
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        size = 0;
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
    }


    /**
     * ArrayQueue method to allow capacity
     * 
     * @param capacity
     *            the type
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        queue = (T[])new Object[capacity + 1];
        size = 0;
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
    }


    /**
     * getLengthOfUnderlyingArray method
     * 
     * @return the length of the array
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }


    /**
     * getSize method
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }


    /**
     * clear method
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        size = 0;
        enqueueIndex = 0;
        dequeueIndex = 0;
    }


    /**
     * dequeue method
     * 
     * @return the front value
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("No texts.");
        }
        else {
            T front = queue[dequeueIndex];
            queue[dequeueIndex] = null;
            dequeueIndex = incrementIndex(dequeueIndex);
            size--;
            return front;
        }
    }


    /**
     * enqueue method
     * 
     * @param newEntry
     *            add in queue
     */
    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = newEntry;
        size++;
    }


    /**
     * getFront method
     * 
     * @return T value
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("No texts.");
        }
        return queue[dequeueIndex];
    }


    /**
     * To check if it is empty
     * 
     * @return 0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * array format of the queue
     * 
     * @return the type
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException("No texts.");
        }
        @SuppressWarnings("unchecked")
        T[] anArray = (T[])new Object[this.getLengthOfUnderlyingArray()];
        for (int i = 0; i < this.getSize(); i++) {
            anArray[i] = this.queue[i];
        }
        return anArray;
    }


    /**
     * toString method
     * 
     * @return the array as string
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size; i++) {
            T a = queue[(dequeueIndex + i) % this.queue.length];
            s.append(a.toString());
            if (i < size - 1) {
                s.append(", ");
            }
        }
        return queue.toString();
    }


    /**
     * equals method
     * 
     * @return false and true
     * @param obj
     *            the Object
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> newQueue = (ArrayQueue<T>)obj;
            if (this.getSize() == newQueue.getSize()) {
                for (int i = 0; i < getSize(); i++) {
                    T myElement = queue[(dequeueIndex + i) % queue.length];
                    T otherElement = newQueue.queue[(newQueue.dequeueIndex + i)
                        % newQueue.queue.length];
                    if (!myElement.equals(otherElement)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    /**
     * isFull method
     */
    private boolean isFull() {
        return size + 1 == queue.length;
    }


    /**
     * To check the it is capacity or not
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] old = queue;
            int oldLen = old.length;
            int newLen = 2 * oldLen - 1;
            if (newLen > MAX_CAPACITY + 1) {
                throw new IllegalStateException();
            }
            queue = (T[])new Object[newLen];
            int j = enqueueIndex;
            for (int i = 0; i < oldLen - 1; i++) {
                queue[i] = old[j];
                incrementIndex(j);
            }
            enqueueIndex = 0;
            dequeueIndex = oldLen - 1;
        }
    }


    /**
     * increasing the index
     * 
     * @param index
     *            queue
     * @return the index
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }
}
