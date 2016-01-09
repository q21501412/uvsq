package fr.uvsq.coo.projet.ex2;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Triangle implements Forme {

	private long id;
	private Map<String, Object> properties;

	private double side1;
	private double side2;
	private double side3;
	private double area;

	private Color color;

	public Triangle() {

	}

	public Triangle(double side1, double side2, double side3, Color color) {

		properties = new HashMap<String, Object>();
		properties.put("side1", side1);
		properties.put("side2", side2);
		properties.put("side3", side3);

		calculerSuperficie();
		this.color = color;
	}

	public void calculerSuperficie() {
		this.area = (side1 + side2 + side3) / 2;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public String getName() {
		return Forme.TRIANGLE;
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

	public void setId(long id) {
		this.id = id;
	}
}
