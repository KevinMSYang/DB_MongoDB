import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB_Drop 
{
	public static void main(String[] args)
	{
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoDatabase db = mongo.getDatabase("Youtube");
		MongoCollection<Document> dbcollection = db.getCollection("channel");
		
		dbcollection.drop();
		
	}
}
