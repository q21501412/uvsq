package fr.uvsq.coo.projet.ex2;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Circle implements Forme {

	private Map<String, Object> properties;

	private long id;

	private String name;
	private double r;
	private double area;

	private Color color;
	private Point centre;

	public Circle() {
		this.r = 1.0;
		this.name = Forme.CIRCLE;
		this.color = new Color(0);
		this.setCentre(new Point(1, 1));
	}

	public Circle(double r, Point centre, Color color) {

		this.r = r;
		this.name = Forme.CIRCLE;
		this.color = color;
		this.centre = centre;

		properties = new HashMap<String, Object>();
		properties.put("r", r);
		properties.put("pointX", (int) centre.getX());
		properties.put("pointY", (int) centre.getY());
		
		calculerSuperficie();
	}

	public void calculerSuperficie() {
		area = 2 * Math.PI * r;
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
	public double getArea() {
		return area;
	}

	@Override
	public Map<String, Object> properties() {
		return properties;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

}
