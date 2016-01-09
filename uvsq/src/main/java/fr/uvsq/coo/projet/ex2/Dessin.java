package fr.uvsq.coo.projet.ex2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that represents the Draws
 * 
 * Note that dessin can have many formes which can be just a forme ( triangle,
 * carre, etc ) or another dessin. So making use of composite concept.
 * 
 * @author nicolas
 *
 */
public class Dessin implements Forme {

	private List<Forme> formes;

	private long id;
	private String name;
	private double area;

	public Dessin(String name) {
		this.name = name;
		formes = new ArrayList<Forme>();
	}

	public void calculerSuperficie() {
		this.area = 0;
		for (Forme f : formes) {
			area += f.getArea();
		}
	}

	@Override
	public Color getColor() {
		// TODO: Dessin is a collection of formes, so no color to it. However
		// figure out
		// how to get rid of get color. Makes no sense just returning null
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getArea() {
		calculerSuperficie();
		return area;
	}

	@Override
	public Map<String, Object> properties() {
		// Dessin is basically a collection of formes so no need of add
		// properties
		return new HashMap<String, Object>();
	}

	public void addForme(Forme newForme) {
		formes.add(newForme);
	}

	public List<Long> getFormeIds() {

		List<Long> ids = new ArrayList<Long>();
		for (Forme f : formes) {
			ids.add(f.getId());
		}
		return ids;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
