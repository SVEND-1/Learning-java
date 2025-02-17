package org.example.MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Indexes.ascending;
import static com.mongodb.client.model.Indexes.descending;

public class MongoDB {
    public static void main(String[] args) {
        MongoCollection<Document> collection = connectDB();
        readSome(collection);
    }
    private static MongoCollection<Document> connectDB(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("WorkWork");
        MongoCollection<Document> collection = database.getCollection("User");
        return  collection;
    }
    private static void create(MongoCollection<Document> collection){
        Document user = new Document("name","Test").append("email","wad@gmail.com").append("age",18);

        collection.insertOne(user);
    }
    private static void read(MongoCollection<Document> collection) {
        Document search = new Document("name","Test");
        Document updateUser =  collection.find(search).first();
        if(updateUser != null) {
            System.out.println("Найден пользователь: " + updateUser.getString("name") + " " + updateUser.getString("email"));
            System.out.println();
            System.out.println("Все данные о нем: " + updateUser.toJson());
        }
        else {
            System.out.println("Пользователь не найден");
        }
    }
    private static void readOr(MongoCollection<Document> collection){
        Document search1 = new Document("name","Test");
        Document search2 = new Document("email","dasd");
        List<Document> documentList = collection.find(new Document("$or", Arrays.asList(search1, search2))).into(new ArrayList<>());
        for(Document document : documentList){
            System.out.println(document.toJson());
        }
    }
    private static void readSome(MongoCollection<Document> collection){//Проверка больше или меньше
        System.out.println("Больше 18");
        for (Document doc : collection.find(new Document("age", new Document("$gt", 18)))) {//Если надо больше или равно то gte
            System.out.println(doc.toJson());
        }
        System.out.println("Меньше 18");
        for (Document doc : collection.find(new Document("age", new Document("$lt", 18)))) {//Если надо меньше или равно то lte
            System.out.println(doc.toJson());
        }
        System.out.println("Не 15");
        for (Document doc : collection.find(new Document("age", new Document("$ne", 15)))) {//Найти всех кому не равно 15
            System.out.println(doc.toJson());
        }
        System.out.println("Сортировка");
        System.out.println("По возрастанию");
        ArrayList<Document> arrayListAsc = new ArrayList<>();
        for (Document doc : collection.find().sort(ascending("age"))) {
            arrayListAsc.add(doc);
            System.out.println(doc.toJson());
        }

        System.out.println("По убыванию");
        ArrayList<Document> arrayListDesc = new ArrayList<>();
        for (Document doc : collection.find().sort(descending("age"))) {
            arrayListDesc.add(doc);
            System.out.println(doc.toJson());
        }

        System.out.println("Лимиты");
        for (Document doc : collection.find().sort(descending("age")).limit(2)) {//Взять первые 2 самых больших
            System.out.println(doc.toJson());
        }
    }
    private static void insertMany(MongoCollection<Document> collection){
        List<Document> documents = Arrays.asList(
                new Document("name", "Alice").append("email", "dasd").append("age",20),
                new Document("name", "Bob").append("email", "dasd").append("age",15),
                new Document("name", "Charlie").append("email", "dasd@das").append("age",17)
        );

        // Вставляем документы в коллекцию
        collection.insertMany(documents);
    }
    private static void update(MongoCollection<Document> collection){
        Document search = new Document("name","Test");
        Document updateUser =  collection.find(search).first();
        if(updateUser != null){
            Document updateDocument = new Document("name","update");
            Document updateOperation = new Document("$set",updateDocument);
            collection.updateOne(updateUser, updateOperation);
        }
    }

    private static void delete(MongoCollection<Document> collection){
        Document search = new Document("name","update");
        Document deleteUser = collection.find(search).first();
        if (deleteUser != null) {
            collection.deleteOne(deleteUser);
        } else {
            System.out.println("Документ не найден.");
        }
    }
}
