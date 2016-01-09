package fr.uvsq.coo.projet.ex2;

import java.awt.Color;
import java.util.Map;

/**
 * 
 * @author nicolas
 *
 *         Generic interface for formes.
 *
 *         Note: Better would be create an interface with just generic behavior
 *         and a generic class with attributes ( getters/ setters ). For
 *         convenience I jumped creating this class having a bigger interface
 *
 */
public interface Forme {

	static final String CIRCLE = "Circle";
	static final String RECTANGLE = "Rectangle";
	static final String CARRE = "Carre";
	static final String TRIANGLE = "Triangle";

	void setId(long id);

	long getId();

	double getArea();

	Color getColor();

	String getName();

	Map<String, Object> properties();

}
