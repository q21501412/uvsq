package fr.uvsq.coo.ex4_1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uvsq.coo.ex3_8.Personnel;

public class StreamPersonnelDaoTest {

	Dao<Personnel> dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new StreamPersonnelDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAStreamPersonnelCanBeCreatedAndListed() {
		
		
		Personnel entity = new Personnel.PersonnelBuilder().name("A")
				.fonction("directeur").build();
		dao.create(entity);
		assertEquals("A", dao.read("A").getName());
		System.out.println(dao.read(entity.getName()));

		
		
	}

}
