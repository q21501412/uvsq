package fr.uvsq.coo.projet.ex1.criteria;

import java.util.List;
import java.util.stream.Collectors;

import fr.uvsq.coo.projet.ex1.core.Message;

public class MotDeCleContainsFiltrageCriteria implements FiltrageCriteria {

	private String motDeCle;

	public MotDeCleContainsFiltrageCriteria(String motDeCle) {
		this.motDeCle = motDeCle;
	}

	@Override
	public List<Message> applyFiltrage(List<Message> msgs) {

		if ("".equals(motDeCle) || motDeCle == null) {
			throw new IllegalArgumentException(
					"Using empty keyword for filter: "
							+ MotDeCleContainsFiltrageCriteria.class);
		}

		return msgs.stream().filter(m -> m.getContenu().contains(motDeCle))
				.collect(Collectors.toList());
	}

	public void setMotDeCle(String motDeCle) {
		this.motDeCle = motDeCle;
	}
}
