package fr.uvsq.coo.ex4_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.uvsq.coo.ex3_8.Personnel;

public class StreamPersonnelDao implements Dao<Personnel> {

	File serializablePersonnel;

	public StreamPersonnelDao() {
		serializablePersonnel = new File("personnels.txt");
	}

	@Override
	public Personnel create(Personnel entity) {

		try {

			List<Personnel> personnels = list();

			if (personnels == null) {
				personnels = new ArrayList<Personnel>();
			}

			personnels.add(entity);

			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(
							serializablePersonnel)));

			out.writeObject(personnels);
			out.close();

		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Personnel update(Personnel entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnel read(String name) {
		
		List<Personnel> list = list();
		
		for ( Personnel p : list ) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		
		return null;
	}

	@Override
	public void delete(String id) {
	}

	@SuppressWarnings({ "unchecked" })
	public List<Personnel> list() {

		ObjectInputStream in;
		List<Personnel> personnels = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(serializablePersonnel)));
			personnels = (List<Personnel>) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO: normal at first time
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return personnels;
	}
	
	

}
