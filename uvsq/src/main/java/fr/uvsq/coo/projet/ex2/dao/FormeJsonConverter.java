package fr.uvsq.coo.projet.ex2.dao;

import java.awt.Color;
import java.awt.Point;

import org.bson.Document;

import fr.uvsq.coo.projet.ex2.Circle;
import fr.uvsq.coo.projet.ex2.Dessin;
import fr.uvsq.coo.projet.ex2.Forme;
import fr.uvsq.coo.projet.ex2.Rectangle;
import fr.uvsq.coo.projet.ex2.Triangle;

public class FormeJsonConverter {

	public FormeJsonConverter() {

	}

	public Document buildJsonFromForme(Forme entity, long id) {
		boolean isDessin = (entity instanceof Dessin);

		String type = isDessin ? "dessin" : "forme";
		String name = entity.getName();
		double area = entity.getArea();

		Document colorJson = null;

		if (!isDessin) {
			int red = entity.getColor().getRed();
			int blue = entity.getColor().getBlue();
			int green = entity.getColor().getGreen();

			colorJson = new Document().append("red", red).append("blue", blue)
					.append("green", green);
		}

		Document dessinJson = new Document().append("_id", id)
				.append("type", type).append("name", name).append("area", area)
				.append("color", colorJson);

		if (isDessin) {
			dessinJson = dessinJson.append("formeIds",
					((Dessin) entity).getFormeIds());
		} else {
			dessinJson = dessinJson.append("properties",
					new Document(entity.properties()));
		}
		return dessinJson;
	}

	public Forme buildFormeFromJson(Document forme) {
		Document colorJson = forme.get("color", Document.class);
		Document properties = forme.get("properties", Document.class);

		// TODO: change if include generic form
		Forme formeReloaded = null;
		String type = forme.getString("type");
		String name = forme.getString("name");
		long id = forme.getLong("_id");

		Color color = null;

		if (!"dessin".equals(type)) {
			color = new Color(colorJson.getInteger("red"),
					colorJson.getInteger("green"), colorJson.getInteger("blue"));
		}

		if ("dessin".equals(type)) {
			formeReloaded = new Dessin(name);
		} else if (Forme.TRIANGLE.equals(name)) {
			double side1 = properties.getDouble("side1");
			double side2 = properties.getDouble("side2");
			double side3 = properties.getDouble("side3");
			formeReloaded = new Triangle(side1, side2, side3, color);

		} else if (Forme.CIRCLE.equals(name)) {
			double r = properties.getDouble("r");
			int x = properties.getInteger("pointX");
			int y = properties.getInteger("pointY");
			Point centre = new Point(x, y);
			formeReloaded = new Circle(r, centre, color);
		} else if (Forme.RECTANGLE.equals(name)) {

			double side1 = properties.getDouble("side1");
			double side2 = properties.getDouble("side2");
			formeReloaded = new Rectangle(side1, side2, color);
		}
		formeReloaded.setId(id);
		return formeReloaded;
	}
}
