package customLinkedList;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.razink.upwork.operr.util.CustomLinkedList;
import org.razink.upwork.operr.util.exception.EmptyListException;

public class TestCustomLinkedList {

	private static final Logger LOGGER = Logger
			.getLogger(TestCustomLinkedList.class.getName());

	@Test
	public void testAppendToList() {
		CustomLinkedList linkedList = new CustomLinkedList();
		LOGGER.info("List Size : " + linkedList.getSize());
		LOGGER.info("List Content : " + linkedList);

		linkedList.append(6);
		linkedList.append(1);
		linkedList.append(30);
		linkedList.append(4);
		linkedList.append(15);

		LOGGER.info("List Size After Append : " + linkedList.getSize());
		LOGGER.info("List Content After Append : " + linkedList);
		Assert.assertTrue(linkedList.getSize() == 5);
	}

	@Test
	public void testRemoveTailElement() {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.append(6);
		linkedList.append(1);
		linkedList.append(30);
		linkedList.append(4);
		linkedList.append(15);
		LOGGER.info("List Size : " + linkedList.getSize());
		LOGGER.info("List Content : " + linkedList);
		try {
			linkedList.removeTail();
		} catch (EmptyListException e) {
			LOGGER.severe("Unable to remove tail element from empty list");
		}
		LOGGER.info("List Size After Remove Tail : " + linkedList.getSize());
		LOGGER.info("List Content After Remove Tail : " + linkedList);
		Assert.assertTrue(linkedList.getSize() == 4);
	}

	@Test
	public void testRemoveTailElementListEmpty() {
		CustomLinkedList linkedList = new CustomLinkedList();
		LOGGER.info("List Size : " + linkedList.getSize());
		LOGGER.info("List Content : " + linkedList);

		try {
			linkedList.removeTail();
		} catch (EmptyListException e) {
			LOGGER.severe("Unable to remove tail element from empty list");
		}
	}

	@Test
	public void testRemoveTailOneElementList() {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.append(6);
		LOGGER.info("List Size : " + linkedList.getSize());
		LOGGER.info("List Content : " + linkedList);
		try {
			linkedList.removeTail();
		} catch (EmptyListException e) {
			LOGGER.severe("Unable to remove tail element from empty list");
		}
		LOGGER.info("List Size After Remove Tail : " + linkedList.getSize());
		LOGGER.info("List Content After Remove Tail : " + linkedList);
		Assert.assertTrue(linkedList.getSize() == 0);
	}
	
	@Test
	public void testRemoveGreaterThan() {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.append(40);
		linkedList.append(1);
		linkedList.append(30);
		linkedList.append(4);
		linkedList.append(15);
		LOGGER.info("List Size : " + linkedList.getSize());
		LOGGER.info("List Content : " + linkedList);
		try {
			linkedList.removeGreaterThan(10);
		} catch (EmptyListException e) {
			LOGGER.severe("Unable to remove tail element from empty list");
		}
		LOGGER.info("List Size After Remove Greater Than : " + linkedList.getSize());
		LOGGER.info("List Content After Remove Greater Than : " + linkedList);
		Assert.assertTrue(linkedList.getSize() == 2);
		
		linkedList.append(26);
		LOGGER.info("List Size After Appending a new Element : " + linkedList.getSize());
		LOGGER.info("List Content After Appending a new Element : " + linkedList);
		Assert.assertTrue(linkedList.getSize() == 3);
	}
}
