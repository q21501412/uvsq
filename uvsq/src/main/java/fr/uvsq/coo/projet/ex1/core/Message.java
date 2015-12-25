package fr.uvsq.coo.projet.ex1.core;

import fr.uvsq.coo.projet.ex1.enums.MessageType;

public class Message {

	private int taille;
	private MessageType type;
	private String contenu;

	public Message(int taille, MessageType type, String contenu) {
		this.setTaille(taille);
		this.setType(type);
		this.setContenu(contenu);
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return taille + " | " + type.name() + " | " + contenu;
	}
}
