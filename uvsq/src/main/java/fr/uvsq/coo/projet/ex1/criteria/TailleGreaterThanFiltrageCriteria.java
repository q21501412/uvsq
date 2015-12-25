package fr.uvsq.coo.projet.ex1.criteria;

import java.util.List;
import java.util.stream.Collectors;

import fr.uvsq.coo.projet.ex1.core.Message;

public class TailleGreaterThanFiltrageCriteria implements FiltrageCriteria {

	private int taille;

	public TailleGreaterThanFiltrageCriteria(int taille) {
		this.taille = taille;
	}
	
	@Override
	public List<Message> applyFiltrage(List<Message> msgs) {
		return msgs.stream().filter(m -> m.getTaille() > taille)
				.collect(Collectors.toList());
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

}
