package fr.uvsq.coo.projet.ex1.filters;

import java.util.List;

import fr.uvsq.coo.projet.ex1.core.Message;
import fr.uvsq.coo.projet.ex1.criteria.FiltrageCriteria;

/**
 * Filter by size
 * 
 * @author nicolas
 *
 */
public class TailleFiltrage implements Filtrage {

	FiltrageCriteria criteria;

	public TailleFiltrage(FiltrageCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public String getDescription() {
		return "Filters by size";
	}

	@Override
	public List<Message> filtrer(List<Message> messages) {
		return criteria.applyFiltrage(messages);
	}

}
