package fr.uvsq.coo.ex3_8;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Personnel implements Groupe {

	final private String name;
	final private String lastName;
	final private LocalDate birthDate;
	final private Map<Phone, String> phoneNumbers;
	final private String fonction;

	public Personnel(PersonnelBuilder builder) {
		this.name = builder.name;
		this.lastName = builder.lastName;
		this.birthDate = builder.birthDate;
		this.phoneNumbers = builder.phoneNumbers;
		this.fonction = builder.fonction;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getPortable() {
		return phoneNumbers.get(Phone.portable);
	}

	public String getFixePro() {
		return phoneNumbers.get(Phone.fixePro);
	}

	public String getFixePersonnal() {
		return phoneNumbers.get(Phone.fixePersonnal);
	}

	public String getFonction() {
		return fonction;
	}

	@Override
	public String getAnnuaireBFS() {
		return this.name + " - ";
	}
	
	@Override
	public String getAnnuaireDFS() {
		return "|" + "nom: " + this.name + " fonction: " + this.fonction + "| ";
	}

	public static class PersonnelBuilder {

		private String name;
		private String lastName;
		private LocalDate birthDate;
		private Map<Phone, String> phoneNumbers = new HashMap<Phone, String>();
		private String fonction;

		public PersonnelBuilder() {

		}

		public PersonnelBuilder name(String name) {
			this.name = name;
			return this;
		}

		public PersonnelBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PersonnelBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public PersonnelBuilder fonction(String fonction) {
			this.fonction = fonction;
			return this;
		}

		public PersonnelBuilder portable(String portable) {

			this.phoneNumbers.put(Phone.portable, portable);
			return this;
		}

		public PersonnelBuilder fixePro(String fixePro) {

			this.phoneNumbers.put(Phone.fixePro, fixePro);
			return this;
		}

		public PersonnelBuilder fixePersonnal(String fixePersonnal) {

			this.phoneNumbers.put(Phone.fixePersonnal, fixePersonnal);
			return this;
		}

		public Personnel build() {
			return new Personnel(this);
		}
	}
}

enum Phone {

	portable, fixePro, fixePersonnal;

}
