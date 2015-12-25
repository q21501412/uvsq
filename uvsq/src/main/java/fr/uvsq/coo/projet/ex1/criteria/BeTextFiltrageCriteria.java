package fr.uvsq.coo.projet.ex1.criteria;

import java.util.List;
import java.util.stream.Collectors;

import fr.uvsq.coo.projet.ex1.core.Message;
import fr.uvsq.coo.projet.ex1.enums.MessageType;

/**
 * Messages for text
 * 
 * @author nicolas
 */
public class BeTextFiltrageCriteria implements FiltrageCriteria {

	/**
	 * Labda streams for checking text
	 */
	@Override
	public List<Message> applyFiltrage(List<Message> msgs) {
		return msgs.stream().filter(m -> MessageType.TEXT.equals(m.getType()))
				.collect(Collectors.toList());
	}

}
