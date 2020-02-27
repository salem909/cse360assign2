/*
 * Author: Salem Almarar
 * Class ID: 238
 * Assignment Number: #1
 * Description: A fixed size list of integers 
 */
package cse360assign2;

/**
 * The Class SimpleList represents a list of 10 integers
 * 
 * @author Salem Almarar
 */
public class SimpleList {

	private int[] list;
	private int count;

	/**
	 * Instantiates a new simple list with 10 integers
	 */
	public SimpleList() {
		this.list = new int[10];
		count = 0;
	}

	/**
	 * Adds the data to start of list. The last element falls off if list is full
	 *
	 * @param data the data
	 */
	public void add(int data) {
		for (int i = Math.min(count, list.length - 1); i > 0; i--) {
			list[i] = list[i - 1];
		}

		list[0] = data;
		count = Math.min(count + 1, list.length);

	}

	/**
	 * Removes the data from list if present
	 *
	 * @param data the data to remove
	 */
	public void remove(int data) {
		int index = search(data);
		if (index != -1) {
			for (int i = index + 1; i < count; i++) {
				list[i - 1] = list[i];
			}
			count--;
		}

	}

	/**
	 * Count the total number of items in the list
	 *
	 * @return the count
	 */
	public int count() {
		return count;
	}

	/**
	 * Returns the string version of list with each element separated by space
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s += list[i];
			if (i != count - 1) {
				s += " ";
			}
		}

		return s;
	}

	/**
	 * Search the data and return the index
	 *
	 * @param data the data to search
	 * @return the index if found, else -1
	 */
	public int search(int data) {
		for (int i = 0; i < count; i++) {
			if (list[i] == data)
				return i;
		}

		return -1;
	}

}