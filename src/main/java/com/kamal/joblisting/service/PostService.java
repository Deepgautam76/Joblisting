package com.kamal.joblisting.service;

import com.kamal.joblisting.model.PostModel;
import com.kamal.joblisting.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    //Use the cunstuctor injection dependancy
    @Autowired
   private PostRepository postRepository;

    public List<PostModel> allposts() {
        return postRepository.findAll();
    }

    public PostModel addpost(PostModel postModel) {
        return postRepository.save(postModel);
    }
}
