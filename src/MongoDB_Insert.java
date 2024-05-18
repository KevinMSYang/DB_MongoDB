import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB_Insert
{
	public static void main(String[] args)
	{
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoDatabase db = mongo.getDatabase("myDb");
		MongoCollection<Document> dbcollection = db.getCollection("myCollection");
		
		Document doc = new Document("title", "PostgreSQL");
		doc.append("description", "database");
		doc.append("likes", 200);
		doc.append("by", "Online Tutorial");
		dbcollection.insertOne(doc);
	}
}
