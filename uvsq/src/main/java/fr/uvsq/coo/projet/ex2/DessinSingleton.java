package fr.uvsq.coo.projet.ex2;

import java.awt.Color;
import java.awt.Point;
import java.util.Scanner;

import fr.uvsq.coo.projet.ex2.dao.DessinController;
import fr.uvsq.coo.projet.ex2.dao.FormeDTO;

public final class DessinSingleton {

	// VISUAL TESTS IN DB
	private static DessinSingleton principal;

	private DessinSingleton() {

	}

	static DessinSingleton getInstance() {
		if (principal == null) {
			principal = new DessinSingleton();
		}
		return principal;
	}

	/**
	 * Dummy Console UI for testing the backend.
	 */
	public void startUp() {

		DessinController controller = new DessinController();

		int option = 0;
		Scanner input = new Scanner(System.in);
		while (true) {

			System.out.println("Choose an option:");
			System.out.println("0 - Exit");
			System.out.println("1 - List Dessins");
			System.out.println("2 - Add a Forme");
			System.out.println("3 - Delete a Forme");
			System.out.println("4 - Modify a Forme");
			System.out.println("5 - Create a Dessin");

			option = input.nextInt();

			switch (option) {

			case 0:
				System.out.println("Exit- Bye");
				return;
			case 1:
				for (FormeDTO dto : controller.getFormes()) {
					System.out.println(dto);
				}
				break;
			case 2:
				System.out
						.println("Select a Forme: 1 - Circle, 2 - Rectangle, 3 - Triangle");
				int optionType = input.nextInt();
				if (optionType == 1) {

					System.out.println("Rayon:");
					double r = input.nextDouble();
					Color c = retrieveColor(input);
					System.out.println("Centre X:");
					int pointX = input.nextInt();
					System.out.println("Centre Y:");
					int pointY = input.nextInt();

					Point centre = new Point(pointX, pointY);

					controller.createCircle(r, centre, c);
					System.out.println("Circle Created");

				}
				break;
			case 3:
				System.out.println("Select the id to be deleted:");
				long optionDelete = input.nextLong();
				controller.remove(optionDelete);
				break;
			case 4:
				System.out.println("Not supported");
				break;
			case 5:
				// create dessin
				System.out
						.println("Choose the list of formes by id comma separated. Ex : '1,10,2'");
				String idList = input.next();
				System.out.println("Select the name of your forme");
				String formeName = input.next();
				controller.createDessin(idList, formeName);
			default:
				break;
			}
		}
	}

	private Color retrieveColor(Scanner input) {
		Color c = null;
		System.out.println("Color: 1 - RGB, 2 - HSB");
		int optionColor = input.nextInt();
		if (optionColor == 1) {
			System.out.println("Red:");
			int red = input.nextInt();
			System.out.println("Blue:");
			int blue = input.nextInt();
			System.out.println("Green:");
			int green = input.nextInt();

			c = new Color(red, green, blue);

		} else {
			System.out.println("hue:");
			double hue = input.nextInt();
			System.out.println("saturation:");
			double saturation = input.nextInt();
			System.out.println("brightness:");
			double brightness = input.nextInt();
			c = Color.getHSBColor((float) hue, (float) saturation,
					(float) brightness);
		}
		return c;
	}
}
