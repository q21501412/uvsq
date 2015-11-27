package fr.uvsq.coo.ex3_8;

import java.util.HashSet;
import java.util.Set;

public class GroupeComposite implements Groupe {

	Set<Groupe> groupes;
	private String fonction;

	public GroupeComposite(String fonction) {
		this.fonction = fonction;
	}

	public Set<Groupe> getPersonnels() {
		if (groupes == null) {
			groupes = new HashSet<Groupe>();
		}
		return groupes;
	}

	public void addGroupe(Groupe p) {
		if (groupes == null) {
			groupes = new HashSet<Groupe>();
		}
		groupes.add(p);
	}

	@Override
	public String getAnnuaireBFS() {

		StringBuilder builder = new StringBuilder();
		builder.append(getFonction());
		builder.append("\n");
		builder.append("|");
		builder.append("\n");
		for (Groupe each : groupes) {
			builder.append(each.getAnnuaireBFS());
		}

		return builder.toString();
	}

	@Override
	public String getAnnuaireDFS() {

		return null;

	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

}
