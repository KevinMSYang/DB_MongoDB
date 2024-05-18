import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDB_Query 
{
	public static void main(String[] args)
	{
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoDatabase db = mongo.getDatabase("myDb");
		MongoCollection<Document> dbcollection = db.getCollection("myCollection");
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("by", "tutorial point");
		System.out.println("Retrieving specific mongo document");
		MongoCursor<Document> cursor = dbcollection.find(searchQuery).iterator();
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}
}
