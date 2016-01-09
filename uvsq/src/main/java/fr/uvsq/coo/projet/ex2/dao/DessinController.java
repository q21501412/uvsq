package fr.uvsq.coo.projet.ex2.dao;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.uvsq.coo.projet.ex2.Circle;
import fr.uvsq.coo.projet.ex2.Dessin;
import fr.uvsq.coo.projet.ex2.Forme;

public class DessinController {

	MongoDbFormeDao dao;

	public DessinController() {
		dao = new MongoDbFormeDao();
	}

	public List<FormeDTO> getFormes() {

		List<Forme> formes = dao.list();

		List<FormeDTO> formeDTOs = new ArrayList<FormeDTO>();

		for (Forme f : formes) {

			FormeDTO dto = new FormeDTO();

			dto.area = f.getArea();
			dto.color = f.getColor();
			dto.id = f.getId();
			dto.name = f.getName();
			dto.properties = f.properties();

			if (f instanceof Dessin) {
				dto.type = FormeType.DESSIN;
			} else {
				dto.type = FormeType.FORME;
			}
			formeDTOs.add(dto);
		}
		return formeDTOs;
	}

	public void createCircle(double r, Point centre, Color color) {
		Forme f = new Circle(r, centre, color);
		dao.create(f);
	}

	public void remove(long optionDelete) {
		dao.delete(optionDelete);
	}

	public void createDessin(String idList, String formeName) {
		
	 List<String> ids = Arrays.asList(idList.split(","));
	 Forme dessin = new Dessin(formeName);
	 
	 for ( String id : ids ) {
		 Long idLong = Long.valueOf(id);
		 Forme newForme = dao.read(idLong);
		 ((Dessin) dessin).addForme(newForme);
	 }
	 
	 dao.create(dessin);
		
	}
}
