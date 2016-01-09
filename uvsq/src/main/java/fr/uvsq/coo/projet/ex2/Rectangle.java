package fr.uvsq.coo.projet.ex2;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * TODO: do rotation - needs refactory for handling points instead of sides. EX:
 * 
 * //TRANSLATE TO ORIGIN double x1 = p1.getX() - center.x; double y1 = p1.getY()
 * - center.y;
 * 
 * //APPLY ROTATION double temp_x1 = x1 * Math.cos(angle) - y1 *
 * Math.sin(angle)); double temp_y1 = x1 * Math.sin(angle) + y1 *
 * Math.cos(angle));
 * 
 * //TRANSLATE BACK p1.setLocation(temp_x1 + center.x, temp_y1 + center.y); You
 * have to do this for each point. Also you will need to find the center of the
 * rectangle center.x and center.y.
 * 
 * 
 * @author nicolas
 *
 */

public class Rectangle implements Forme {

	private Map<String, Object> properties;

	private long id;
	private double area;

	private Color color;
	private String name;

	public Rectangle() {

	}

	public Rectangle(double side1, double side2, Color color) {

		properties = new HashMap<String, Object>();
		properties.put("side1", side1);
		properties.put("side2", side2);

		this.color = color;
		setName(side1, side2);
		calculerSuperficie(side1, side2);
	}

	protected void setName(double side1, double side2) {
		if (Double.compare(side1, side2) == 0) {
			this.name = Forme.CARRE;
		} else {
			this.name = Forme.RECTANGLE;
		}
	}

	protected void calculerSuperficie(double side1, double side2) {
		this.area = (side1 * side2) / 2;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Map<String, Object> properties() {
		return properties;
	}

	@Override
	public double getArea() {
		return area;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
