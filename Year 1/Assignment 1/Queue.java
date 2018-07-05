
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by LinkedListElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author Annabel Kimber
 *
 */

import java.util.NoSuchElementException;

public class Queue {

	/**
	 * Attributes of the queue.
	 */

	private QueueElement head; 
	private QueueElement tail; 

	// TODO: You need some data to store the queue. Put the attributes here.

	/**
	 * Constructs an empty Queue.
	 */
	public Queue() {
		// TODO: Queue needs to be initialized to an empty Queue.

		head = null; 
		tail = null; 
	}

	/**
	 * Returns true if the queue is empty.
	 */
	public boolean isEmpty() {

		return ((head == null) && (tail == null));

		// return ((head == null) && (tail == null));
		// TODO: Needs to return true when empty and false otherwise

	}

	/**
	 * Returns the element at the head of the queue, or an exception if the queue is empty.
	 */
	public Object peek() throws NoSuchElementException {

		if (this.isEmpty()) {
			throw new NoSuchElementException("Tried to peek an empty queue.");
		} else {
			return head.getElement();
		}

		// TODO: Returns the front of the queue if it exists and throws an
		// exception otherwise

	}

	/**
	 * Removes the front element of the queue, or an exception if the queue is empty.
	 */
	public void dequeue() throws NoSuchElementException {

		if (this.isEmpty()) {
			throw new NoSuchElementException("Trued to dequeue an empty queue.");
		} else {

			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.getNext();
			}
		}
		// TODO: Removes the front front of the queue if it exists and throws an
		// exception otherwise
	}

	/**
	 * Puts an element on the back of the queue, if the queue is empty, both head and tail 
	 * will both link to the element.
	 */
	public void enqueue(Object element) {
		QueueElement newNode = new QueueElement(element, null);
		if (this.isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		// TODO: Puts an element on the back of the queue.
	}

	/**
	 * Method to print the full contents of the queue in order from head to
	 * tail, or print out a message if the queue is empty.
	 */
	public void print() {
		if (this.isEmpty()) {
			System.out.println("The queue is empty");
		} else {
			QueueElement curItem = head;
			while (curItem != null) {
				System.out.println(curItem.getElement());
				curItem = curItem.getNext();
			}
		}

		// TODO: Prints out the full queue. If empty prints out a line saying
		// so.
	}
}
