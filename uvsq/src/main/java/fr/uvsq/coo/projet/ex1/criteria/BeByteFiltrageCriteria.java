package fr.uvsq.coo.projet.ex1.criteria;

import java.util.List;
import java.util.stream.Collectors;

import fr.uvsq.coo.projet.ex1.core.Message;
import fr.uvsq.coo.projet.ex1.enums.MessageType;

/**
 * Check if messages are type of byte.
 * 
 * @author nicolas
 */
public class BeByteFiltrageCriteria implements FiltrageCriteria {

	@Override
	public List<Message> applyFiltrage(List<Message> msgs) {
		return msgs.stream().filter(m -> MessageType.BYTE.equals(m.getType()))
				.collect(Collectors.toList());
	}

}
