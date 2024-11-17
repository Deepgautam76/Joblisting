package com.kamal.joblisting.repository;

import com.kamal.joblisting.model.PostModel;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    private MongoClient mongoClient;
    @Autowired
    private MongoConverter converter;
    @Override
    public List<PostModel> findByText(String text) {
       final List<PostModel> postModels =new ArrayList<>();

        MongoDatabase database=mongoClient.getDatabase("deep");
        MongoCollection<Document> collection=database.getCollection("postModel");
        AggregateIterable<Document> result=collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                         new Document("$sort", new Document("exp", 1L)),
                         new Document("$limit", 5L)));


        //Convert document to java object
        result.forEach(doc -> {
//            System.out.println("Found document: " + doc.toJson());
            postModels.add(converter.read(PostModel.class,doc));
        });
        return postModels;
    }
}

