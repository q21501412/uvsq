package fr.uvsq.coo.projet.ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fr.uvsq.coo.projet.ex1.criteria.FiltrageCriteria;
import fr.uvsq.coo.projet.ex1.enums.FiltrageType;

public class FiltrageFactoryTest {

	FiltrageFactory factory;
	FiltrageCriteria filterCriteria;

	@Before
	public void setUp() throws Exception {

		factory = new FiltrageFactory();
		filterCriteria = Mockito.mock(FiltrageCriteria.class);
	}

	@Test
	public void testMotdeCleFiltrageCanBeCreatedByFactory() {
		assertNotNull(factory.createFiltrage(FiltrageType.MOT_DE_CLE,
				filterCriteria));
	}

	@Test
	public void testTypeFiltrageCanBeCreatedByFactory() {
		assertNotNull(factory.createFiltrage(FiltrageType.TYPE, filterCriteria));
	}

	@Test
	public void testTailleFiltrageCanBeCreatedByFactory() {
		assertNotNull(factory.createFiltrage(FiltrageType.TAILLE,
				filterCriteria));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsthrowIfnoFiltrageFound() {
		factory.createFiltrage(null, null);
	}
}
