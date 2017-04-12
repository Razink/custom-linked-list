package org.razink.upwork.operr.util;

import org.razink.upwork.operr.util.exception.EmptyListException;

public class CustomLinkedList {

	/**
	 * Head element of the linked list
	 */
	private Element firstElement;

	/**
	 * Linked list size
	 */
	private int size;

	/**
	 * Default Constructor.
	 * <p>
	 * Sets first element to null and set intial size to 0
	 */
	public CustomLinkedList() {
		firstElement = null;
		size = 0;
	}

	/**
	 * Appends int value as a new element at the end of the linked list
	 * 
	 * @param value
	 *            Value to append to the linked list
	 */
	public void append(int value) {
		//Creating new element with int value constructor
		Element newElement = new Element(value);
		
		// If list is empty, set new element as first element
		if (size == 0) {
			firstElement = newElement;
		} else 
		// Else get the last element of the list and set new element as his nextElement
		{
			getLastElement().nextElement = newElement;
		}
		size++;
	}

	/**
	 * Removes tail element from the list
	 * <p>
	 * If the list is empty throws a checked EmptyListException
	 * 
	 * @return Removed element
	 * @throws EmptyListException
	 */
	public Element removeTail() throws EmptyListException {
		Element removedElement;
		// If list contains more than one element , get second last element and set his nextElement to null
		if (size > 1) {
			removedElement = getSecondLastElement().nextElement;
			getSecondLastElement().nextElement = null;
			size--;
		// Else if list contains only 1 element, set firstElement to null
		} else if (size == 1) {
			removedElement = firstElement;
			firstElement = null;
			size--;
		} else 
		// if list is empty throw Exception
		{
			throw new EmptyListException();
		}
		return removedElement;
	}

	/**
	 * Remove elements with greater value than the provided parameter from the
	 * list
	 * 
	 * @param value
	 * @throws EmptyListException
	 */
	public void removeGreaterThan(int value) throws EmptyListException {
		if (size > 0) {
			Element previousElement = null;
			Element currentElement = firstElement;
			// Loop over the list
			while (currentElement != null) {
				
				if (currentElement.value > value) {
					//Element to remove is the first element : set firstElement to next element in the list
					if (previousElement == null) {
						firstElement = currentElement.nextElement;
					} else 
					//Element to remove is not the first element : set previousElement.nextElement to next element 
					{
						previousElement.nextElement = currentElement.nextElement;
					}
					size--;
				} else 
				// if element is not greater than value, set previous element to currentElement
				{
					previousElement = currentElement;
				}
				// Move cursor to next element
				currentElement = currentElement.nextElement;
			}
		} else 
		// if list is empty throw Exception
		{
			throw new EmptyListException();
		}
	}

	/**
	 * Get last element in the list
	 * 
	 * @return Last element in the list
	 */
	private Element getLastElement() {
		if (size > 0) {
			Element lastElement = firstElement;
			while (lastElement.nextElement != null) {
				lastElement = lastElement.nextElement;
			}
			return lastElement;
		}
		return null;
	}

	/**
	 * Get second last element in the list
	 * 
	 * @return Second Last element in the list
	 */
	private Element getSecondLastElement() {
		if (size > 1) {
			Element lastElement = firstElement;
			while (lastElement.nextElement.nextElement != null) {
				lastElement = lastElement.nextElement;
			}
			return lastElement;
		}
		return null;
	}

	/**
	 * Getter for size attribute
	 * 
	 * @return List size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Inner class representing a linked list element
	 * @author Nizar
	 *
	 */
	private static class Element {
		/**
		 * Element value
		 */
		Integer value;
		/**
		 * Next element in the list
		 */
		Element nextElement;

		/**
		 * Constructor using int value to initialize Element
		 * @param value int value of the element
		 */
		public Element(int value) {
			this.value = value;
			this.nextElement = null;
		}
	}

	@Override
	/**
	 * Returns String representation of the linked list
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Element current = firstElement;
		while (current != null) {
			sb.append(current.value);
			current = current.nextElement;
			if (current != null)
				sb.append(',');
		}
		sb.append("]");
		return sb.toString();
	}

}
