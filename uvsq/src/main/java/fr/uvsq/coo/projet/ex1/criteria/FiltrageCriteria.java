package fr.uvsq.coo.projet.ex1.criteria;

import java.util.List;

import fr.uvsq.coo.projet.ex1.core.Message;

/**
 * This interface represents the list of criterias that should be used.
 * 
 * Note: We can have a hierarchy of classes from this one. You will note that
 * some criterias have the same 'body' ( this is illustrated in
 * TailleGreaterThan and TailleLessThan criterias ). So we could have a generic
 * TailleCriteria having the same constructor and encapsulating the attribute
 * taille. however for avoid inheritance ( loosely couple ) I rewrote for all
 * classes.
 * 
 * @author nicolas
 *
 */
public interface FiltrageCriteria {

	List<Message> applyFiltrage(List<Message> msgs);

}
