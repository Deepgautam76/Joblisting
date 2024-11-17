package com.kamal.joblisting.repository;

import com.kamal.joblisting.model.PostModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostModel, ObjectId> {

}
