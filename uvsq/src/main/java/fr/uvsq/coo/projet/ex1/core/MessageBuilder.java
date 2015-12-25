package fr.uvsq.coo.projet.ex1.core;

import fr.uvsq.coo.projet.ex1.enums.MessageType;

/**
 * Builder for Message.
 * 
 * Note: Even though official builder are embedded into classes itself. I prefer
 * to have it separated for better readability and reuse.
 * 
 * @author nicolas
 *
 */
public final class MessageBuilder {

	private int taille;
	private MessageType type;
	private String contenu;

	public MessageBuilder taille(int taille) {
		this.taille = taille;
		return this;
	}

	public MessageBuilder type(MessageType type) {
		this.type = type;
		return this;
	}

	public MessageBuilder contenu(String contenu) {
		this.contenu = contenu;
		return this;
	}

	public Message build() {
		return new Message(taille, type, contenu);
	}
}
