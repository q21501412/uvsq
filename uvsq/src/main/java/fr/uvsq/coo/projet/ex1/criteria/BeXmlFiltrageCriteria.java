package fr.uvsq.coo.projet.ex1.criteria;

import java.util.List;
import java.util.stream.Collectors;

import fr.uvsq.coo.projet.ex1.core.Message;
import fr.uvsq.coo.projet.ex1.enums.MessageType;

/**
 * Filter Responsible for checking if its xml.
 * 
 * @author nicolas
 *
 */
public class BeXmlFiltrageCriteria implements FiltrageCriteria {

	/**
	 * Filtering using lambda streams
	 */
	@Override
	public List<Message> applyFiltrage(List<Message> msgs) {
		return msgs.stream().filter(m -> MessageType.XML.equals(m.getType()))
				.collect(Collectors.toList());
	}
}
