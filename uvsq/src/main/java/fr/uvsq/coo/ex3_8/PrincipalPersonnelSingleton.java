package fr.uvsq.coo.ex3_8;

public class PrincipalPersonnelSingleton {

	public static void main(String[] args) {

		Personnel a = new Personnel.PersonnelBuilder().name("A")
				.fonction("directeur").build();
		
		Personnel b = new Personnel.PersonnelBuilder().name("B")
				.fonction("developpeur").build();

		GroupeComposite groupe1 = new GroupeComposite("Groupe1");
		
		groupe1.addGroupe(a);
		groupe1.addGroupe(b);
		
		// System.out.println(groupe1.getAnnuaireBFS());
		
		GroupeComposite groupe2 = new GroupeComposite("Groupe2");
		
		Personnel c = new Personnel.PersonnelBuilder().name("C")
				.fonction("developpeur").build();
		
		groupe2.addGroupe(groupe1);
		groupe2.addGroupe(c);
		
		System.out.println(groupe2.getAnnuaireBFS());
		
	}

}
