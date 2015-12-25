package fr.uvsq.coo.projet.ex1.filters;

import java.util.List;

import fr.uvsq.coo.projet.ex1.core.Message;
import fr.uvsq.coo.projet.ex1.criteria.FiltrageCriteria;

public class MotDeCleFiltrage implements Filtrage {

	FiltrageCriteria criteria;

	/**
	 * Makes no sense having a filtrage without it criteria
	 * 
	 * @param criteria
	 */
	public MotDeCleFiltrage(FiltrageCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public String getDescription() {
		return "Mot de Cle filter";
	}

	@Override
	public List<Message> filtrer(List<Message> messages) {
		return criteria.applyFiltrage(messages);
	}

}
