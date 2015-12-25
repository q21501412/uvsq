package fr.uvsq.coo.projet.ex1.filters;

import java.util.List;

import fr.uvsq.coo.projet.ex1.core.Message;

/**
 * This interface represents the filter for messages.
 * 
 * Each concrete class will filter according its own characteristics and domain.
 * We can have some concrete classes for doing xmls filtering, size filtering
 * and also about the content itself.
 * 
 * Note: Creating many "filtrages" makes not really a difference. Would be
 * better having just one genericfiltrage with many kinds of FiltrageCriteria.
 * However using more than one for illustrating the OCP principle.
 * 
 * @author nicolas
 *
 */

public interface Filtrage {

	/**
	 * Description of the filtrage
	 * 
	 * @return filtrage description
	 */
	String getDescription();

	/**
	 * The actual filter for this class
	 * 
	 * @param messages
	 *            to be filtered
	 * @return Messages filtered out.
	 */
	List<Message> filtrer(List<Message> messages);
}
