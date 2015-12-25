package fr.uvsq.coo.projet.ex1;

import fr.uvsq.coo.projet.ex1.criteria.FiltrageCriteria;
import fr.uvsq.coo.projet.ex1.enums.FiltrageType;
import fr.uvsq.coo.projet.ex1.filters.Filtrage;
import fr.uvsq.coo.projet.ex1.filters.MotDeCleFiltrage;
import fr.uvsq.coo.projet.ex1.filters.TailleFiltrage;
import fr.uvsq.coo.projet.ex1.filters.XmlFiltrage;

/**
 * Responsabile for creating filter for given type and criteria.
 * 
 * @author nicolas
 * 
 *         Note : Factories generally are created as static. however static
 *         sometimes limitates OO and unit tests so unless real need keep
 *         non-static
 *
 */
public class FiltrageFactory {

	Filtrage createFiltrage(FiltrageType type, FiltrageCriteria criteria) {

		if (FiltrageType.MOT_DE_CLE.equals(type)) {
			return new MotDeCleFiltrage(criteria);
		} else if (FiltrageType.TAILLE.equals(type)) {
			return new TailleFiltrage(criteria);
		} else if (FiltrageType.TYPE.equals(type)) {
			return new XmlFiltrage(criteria);
		}

		throw new IllegalArgumentException(
				"Should provide a valid filtrage type");
	}

}
