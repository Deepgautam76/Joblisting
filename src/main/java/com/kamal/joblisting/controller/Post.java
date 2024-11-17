package com.kamal.joblisting.controller;

import com.kamal.joblisting.model.PostModel;
import com.kamal.joblisting.repository.SearchRepository;
import com.kamal.joblisting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Post {

    //here use the field injection
    @Autowired
    private PostService postService;
    @Autowired
    private SearchRepository searchRepository;

    //Fetch all posts from DB

    @GetMapping("/allPosts")
    public List<PostModel> posts(){
        return postService.allposts();
    }

    //This is a search endPoint of API

    @GetMapping("/posts/{text}")
    public List<PostModel> search(@PathVariable String text){
        return searchRepository.findByText(text);
    }

    //This endpoint for add job post
    @PostMapping("/post")
    public PostModel addPost(@RequestBody PostModel postModel){
        return postService.addpost(postModel);
   }
}
