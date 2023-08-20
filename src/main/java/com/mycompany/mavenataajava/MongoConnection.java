package com.mycompany.mavenataajava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author milli
 */
public class MongoConnection {
    // Connection String
    String connectionString = "mongodb://localhost:27017"; // Replace with your actual MongoDB URI

        
    public void MongoConnection(){
     // Create a MongoDB client
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Access the database
            MongoDatabase database = mongoClient.getDatabase("ataaRecords"); // Replace with your database name
            System.out.println("Connected to database: " + database.getName());

            // Now you can perform operations on the database
            // ...
//        } catch (Exception e) {
//            System.err.println("Error connecting to MongoDB: " + e.getMessage());
//        }
//    
//        try{

            // Access the collection (table) where you want to insert the records
			
            MongoCollection<Document> collection = database.getCollection("ataa_record_trans_three");


           // Create a new document (record) with the desired fields based on your schema
            Document flightDocument = new Document("aircraftowner", "Military")
		.append("aircraft", "F16")
                .append("runway", "31R")
                .append("operation", "Takeoff")
                .append("approach", "")
                .append("departure", "VFR")
                .append("count", 7)
                .append("dateof", "2023-08-20")
                .append("overflight", "No")
                .append("createdAt", new java.util.Date())
                .append("updatedAt", new java.util.Date());

            // Insert the document into the collection
            collection.insertOne(flightDocument);



            System.out.println("Record added successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
    
    
}

