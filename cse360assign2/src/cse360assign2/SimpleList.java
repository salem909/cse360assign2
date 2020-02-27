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
	 * Adds the data to start of list. 
	 *
	 * @param data the data
	 */
	public void add(int data) {
		if (list.length == count) {
			int newLength = (int) (list.length + Math.ceil(list.length * 0.5));
			int[] newList = new int[newLength];
			for (int i = 0; i < list.length; i++) {
				newList[i] = list[i];
			}

			list = newList;
		}

		for (int i = count; i > 0; i--) {
			list[i] = list[i - 1];
		}

		list[0] = data;
		count++;

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

			int emptySpaces = list.length - count;

			if (emptySpaces * 100 / list.length > 25 && list.length > 1) {
				int newLength = (int) (Math.floor(list.length * 0.75));
				int[] newList = new int[newLength];
				for (int i = 0; i < newList.length; i++) {
					newList[i] = list[i];
				}

				list = newList;
			}

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

	/**
	 * Add the data to end of list.
	 *
	 * @param data the data
	 */
	public void append(int data) {
		if (list.length == count) {
			int newLength = (int) (list.length + Math.ceil(list.length * 0.5));
			int[] newList = new int[newLength];
			for (int i = 0; i < list.length; i++) {
				newList[i] = list[i];
			}

			list = newList;
		}

		list[count++] = data;
	}
	
	/**
	 * First element in list
	 * @return the element, -1 if empty
	 */
	public int first() {
		return count == 0 ? -1 : list[0];
	}
	
	/**
	 * Last element in list
	 * @return the element, -1 if empty
	 */
	public int last() {
		return count == 0 ? -1 : list[count - 1];
	}
	
	/**
	 * Return the size of the list
	 * @return the size
	 */
	public int size() {
		return count;
	}
	

	

}