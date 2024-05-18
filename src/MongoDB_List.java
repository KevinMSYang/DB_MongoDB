import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB_List 
{
	public static void main(String[] args)
	{
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoDatabase db = mongo.getDatabase("myDb");
		MongoCollection<Document> dbcollection = db.getCollection("myCollection");
		
		FindIterable<Document> iterDoc = dbcollection.find();
		int i = 1;
		System.out.println("Listing all mongoDB Documents");
		Iterator it = iterDoc.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
			i++;
		}
	}
}
