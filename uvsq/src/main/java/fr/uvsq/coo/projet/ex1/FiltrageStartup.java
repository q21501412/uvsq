package fr.uvsq.coo.projet.ex1;

import java.util.Arrays;
import java.util.List;

import fr.uvsq.coo.projet.ex1.core.Message;
import fr.uvsq.coo.projet.ex1.core.MessageBuilder;
import fr.uvsq.coo.projet.ex1.criteria.BeByteFiltrageCriteria;
import fr.uvsq.coo.projet.ex1.criteria.BeTextFiltrageCriteria;
import fr.uvsq.coo.projet.ex1.criteria.BeXmlFiltrageCriteria;
import fr.uvsq.coo.projet.ex1.criteria.MotDeCleContainsFiltrageCriteria;
import fr.uvsq.coo.projet.ex1.criteria.TailleGreaterThanFiltrageCriteria;
import fr.uvsq.coo.projet.ex1.criteria.TailleLessThanFiltrageCriteria;
import fr.uvsq.coo.projet.ex1.enums.FiltrageType;
import fr.uvsq.coo.projet.ex1.enums.MessageType;
import fr.uvsq.coo.projet.ex1.filters.Filtrage;

public class FiltrageStartup {

	public static void main(String[] args) {

		Message msg1 = new MessageBuilder().taille(10).type(MessageType.XML)
				.contenu("<xml>test</xml>").build();

		Message msg2 = new MessageBuilder().taille(15).type(MessageType.TEXT)
				.contenu("some text").build();

		Message msg3 = new MessageBuilder().taille(20).type(MessageType.BYTE)
				.contenu("01010011").build();

		FiltrageFactory factory = new FiltrageFactory();

		Filtrage filtrageXml = factory.createFiltrage(FiltrageType.TYPE,
				new BeXmlFiltrageCriteria());

		Filtrage filtrageText = factory.createFiltrage(FiltrageType.TYPE,
				new BeTextFiltrageCriteria());

		Filtrage filtrageByte = factory.createFiltrage(FiltrageType.TYPE,
				new BeByteFiltrageCriteria());

		Filtrage filtrageHigherThan12 = factory.createFiltrage(
				FiltrageType.TAILLE, new TailleGreaterThanFiltrageCriteria(12));

		Filtrage filtrageLessThan18 = factory.createFiltrage(
				FiltrageType.TAILLE, new TailleLessThanFiltrageCriteria(18));
		
		Filtrage haveXmlContent = factory.createFiltrage(
				FiltrageType.MOT_DE_CLE, new MotDeCleContainsFiltrageCriteria("xml"));

		List<Message> msgs = Arrays.asList(msg1, msg2, msg3);

		System.out.println("Filtering by Xml - Should show 1 : "
				+ filtrageXml.filtrer(msgs));
		System.out.println("Filtering by Text - Should show 1 : "
				+ filtrageText.filtrer(msgs));
		System.out.println("Filtering by Byte - Should show 1 : "
				+ filtrageByte.filtrer(msgs));

		System.out
				.println("Filtering by taille - Higher than 12 - Should show 2 : "
						+ filtrageHigherThan12.filtrer(msgs));

		System.out
				.println("Filtering by taille - Less than 18 - Should show 2 : "
						+ filtrageLessThan18.filtrer(msgs));
		
		System.out
		.println("Filtering by contenu - checking string 'xml' - Should show 1 : "
				+ haveXmlContent.filtrer(msgs));

	}

}
