package fr.uvsq.coo.projet.ex1.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.uvsq.coo.projet.ex1.enums.MessageType;

/**
 * Purely pojo class, nothing really to set. Just check attributes
 * 
 * @author nicolas
 *
 */
public class MessageTest {

	Message message;

	@Test
	public void testConstructorSetFields() {

		message = new Message(10, MessageType.TEXT, "my text");

		assertEquals(10, message.getTaille());
		assertEquals(MessageType.TEXT, message.getType());
		assertEquals("my text", message.getContenu());

	}

}
