package fr.uvsq.coo.projet.ex1.filters;

import java.util.List;

import fr.uvsq.coo.projet.ex1.core.Message;
import fr.uvsq.coo.projet.ex1.criteria.FiltrageCriteria;

/**
 * Responsible for xml filtering
 * 
 * @author nicolas
 *
 */
public class XmlFiltrage implements Filtrage {

	FiltrageCriteria criteria;

	public XmlFiltrage(FiltrageCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public String getDescription() {
		return "Filter for message type";
	}

	@Override
	public List<Message> filtrer(List<Message> messages) {
		return criteria.applyFiltrage(messages);
	}

}
