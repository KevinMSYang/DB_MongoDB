import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.net.UnknownHostException;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;
import com.mongodb.WriteResult;


public class MongoDB_Connection 
{	
	public static void main(String[] args)
	{
		// Creating a Mongo client
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		
		// Accessing the database
		DB database = mongo.getDB("myDb");
		MongoDatabase db = mongo.getDatabase("Youtube");
		
		
		// Creating a collection
		DBCollection collection = database.getCollection("myCollection");
		MongoCollection<Document> dbcollection = db.getCollection("channel");
		
		System.out.println("Collection created successfully");
		
		//Inserting document into the collection
		DBObject document = new BasicDBObject();
		document.put("title","SQLite");
		document.put("description", "database");
		document.put("likes", 100);
		document.put("by", "tutorial point");
		collection.insert(document);
		
		Document doc = new Document("name", "Database");
		doc.append("id", 101);
		doc.append("subscribers", 100);
		doc.append("Genre", "Java Programming");
		dbcollection.insertOne(doc);
		System.out.println("Document inserted successfully");
		
		
		// Listing all MongoDB Documents in Collection
		FindIterable<Document> iterDoc = dbcollection.find();
		int i = 1;
		System.out.println("Listing all mongoDB Documents");
		Iterator it = iterDoc.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
			i++;
		}
		
		// Specific document retrieving in a collection
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "Tutorial");
		System.out.println("Retrieving specific mongo document");
		MongoCursor<Document> cursor = dbcollection.find(searchQuery).iterator();
		while (cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
		
		
		// Updating document
		dbcollection.updateOne(Filters.eq("name", "Tutorial"), Updates.set("Genre", "Coding"));
		System.out.println("Document updateded successfully");
		int j = 1;
		Iterator<Document> iterNew = iterDoc.iterator();
		while (iterNew.hasNext())
		{
			System.out.println(iterNew.next());
			j++;
		}
		
		// Deleting document
		dbcollection.deleteOne(Filters.eq("Genre", "Programming"));
		
		int k = 1;
		Iterator<Document> iterDelete = iterDoc.iterator();
		while (iterDelete.hasNext())
		{
			System.out.println(iterDelete.next());
			k++;
		}
	}
}
