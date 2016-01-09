package fr.uvsq.coo.projet.ex2.dao;

import java.awt.Color;
import java.util.Map;

/**
 * TODO: check if really helps (depends of the frontend)
 * 
 * Data transfer object of Formes for communicating data between all layers
 * 
 * @author nicolas
 * 
 *
 */
public class FormeDTO {

	FormeType type;
	double area;
	Color color;
	long id;
	String name;
	Map<String, Object> properties;

	public FormeDTO() {

	}

	@Override
	public String toString() {

		String colorRGB = null;
		if (color != null) {
			colorRGB = color.toString();
		} else {
			colorRGB = "A dessin does not have color";
		}

		return "(" + id + ", " + type + ", " + area + ", " + colorRGB + ", "
				+ name + ", " + properties + ")";
	}
}
