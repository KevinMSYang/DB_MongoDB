import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDB_Delete 
{
	public static void main(String[] args)
	{
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoDatabase db = mongo.getDatabase("myDb");
		MongoCollection<Document> dbcollection = db.getCollection("myCollection");
		
		dbcollection.deleteOne(Filters.eq("title", "MySQL"));
		
		FindIterable<Document> iterDoc = dbcollection.find();
		Iterator<Document> iterNew = iterDoc.iterator();
		int j = 1;
		while (iterNew.hasNext())
		{
			System.out.println(iterNew.next());
			j++;
		}
	}
}
