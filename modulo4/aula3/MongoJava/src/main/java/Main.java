import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserpesadelonacozinha");

        MongoCollection<Document> receitas = mongoDatabase.getCollection("receitas");
        MongoCollection<Document> usuarios = mongoDatabase.getCollection("usuarios");



        // Nova receita
        Document novaReceita = new Document("recipeName", "Mastruz com leite")
                .append("prepareRecipe", "Mastruz e leite")
                .append("prepareTime", 10)
                .append("ingredientes", Arrays.asList("mastruz", "leite"))
                .append("price", 10)
                .append("calories", 200)
                .append("username","flavio");

        Document novaReceita1 = new Document("recipeName", "arroz")
                .append("prepareRecipe", "uashusah uajsuidhaushdasjdui")
                .append("prepareTime", 10)
                .append("ingredientes", Arrays.asList("arroz", "alho","sal","agua"))
                .append("price", 12.30)
                .append("calories", 318);




        //  POST
//        System.out.println(receitas.insertOne(novaReceita));
//         receitas.insertOne(novaReceita1);


        //PUT
//         usuarios.updateOne(Filters.eq("username", "flavio"), ("$set","email","flavio@gmail.com");


//        Document encontrado = receitas.find(new Document("recipeName","Mastruz com leite")).first();
//
//        if (encontrado != null){
//            System.out.println("receita encontrada!");
//
//            Bson updateValue = new Document("calories",300);
//            Bson updateObject = new Document("$set",updateValue);
//            receitas.updateOne(encontrado,updateObject);
//            System.out.println("receita atualizada!");
//        }
//


//        Document usuarioEncontrado = usuarios.find(new Document("username","flavio")).first();
//
//        if (usuarioEncontrado != null){
//            System.out.println("usuario encontrada!");
//
//            Bson updateValue = new Document("username","rafael");
//            Bson updateObject = new Document("$set",updateValue);
//            receitas.updateOne(usuarioEncontrado,updateObject);
//            System.out.println("usuario atualizado!");
//        }



        //delete
//        receitas.deleteOne(Filters.eq("recipeName" , "Mastruz com leite"));
//        receitas.deleteOne(Filters.eq("calories" , "200"));


        //GET
        // Buscar receitas
//        System.out.println("-- Receita");
//        Document receita = receitas.find(new Document("recipeName" , "Mastruz com leite")).first();
//        System.out.println(receita);

//         Aggregate
        System.out.println("-- Receitas");
        receitas.aggregate(
                Arrays.asList(
                        match(Filters.eq("calories",new Document("$lte",1000))),
                        group("$username", Accumulators.sum("calories", "$calories"))
                )).forEach(doc -> System.out.println(doc.toJson()));

        mongoClient.close();
    }
}
