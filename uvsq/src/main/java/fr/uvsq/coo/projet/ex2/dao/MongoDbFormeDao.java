package fr.uvsq.coo.projet.ex2.dao;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import fr.uvsq.coo.projet.ex2.Forme;

/**
 * Use MongoDb for implementing the backend. Just one collection dessin, belows
 * the json specification:
 * 
 * dessin { name : "string", type : "dessin" or "forme", color : { red : int,
 * blue : int, green: int } , sides : [] r : }
 * 
 * 
 * @author nicolas
 *
 */
public class MongoDbFormeDao implements GenericDao<Forme> {

	MongoClient client;
	MongoDatabase db;
	MongoCollection<Document> coll;
	FormeJsonConverter formeConverter;

	public MongoDbFormeDao() {
		client = new MongoClient();
		db = client.getDatabase("uvsq");
		coll = db.getCollection("dessin");
		formeConverter = new FormeJsonConverter();
		// System.setProperty("DEBUG.MONGO", "true");
		// System.setProperty("DB.TRACE", "true");

	}

	@Override
	public Forme create(Forme entity) {

		long id = coll.count();
		
		if ( coll.find(new Document("_id", id)) != null ) {
			id += 21;
		}
		
		Document dessin = formeConverter.buildJsonFromForme(entity, ++id);
		coll.insertOne(dessin);
		return entity;
	}

	@Override
	public Forme read(long id) {

		Document forme = coll.find(Filters.eq("_id", id)).first();

		Forme formeReloaded = formeConverter.buildFormeFromJson(forme);

		return formeReloaded;
	}

	@Override
	public Forme update(Forme entity) {

		Color newColor = entity.getColor();
		Map<String, Object> properties = entity.properties();

		Document colorDoc = new Document("red", newColor.getRed()).append(
				"green", newColor.getGreen())
				.append("blue", newColor.getBlue());
		Document updateDoc = new Document().append("color", colorDoc).append(
				"properties", properties);

		coll.updateOne(Filters.eq("_id", entity.getId()), updateDoc);
		return read(entity.getId());
	}

	@Override
	public void delete(long id) {
		coll.deleteOne(Filters.eq("_id", id));
	}

	@Override
	public List<Forme> list() {
		ArrayList<Document> formesJson = coll.find().into(
				new ArrayList<Document>());

		ArrayList<Forme> formes = new ArrayList<Forme>();

		for (Document doc : formesJson) {
			formes.add(formeConverter.buildFormeFromJson(doc));
		}
		return formes;
	}
}
