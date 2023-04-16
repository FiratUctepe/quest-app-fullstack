package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService=postService;
    }

    @GetMapping
    public List<Post> getAllPostsByUserId(@RequestParam(required = false) Long userId){
        return postService.getAllPostsByUserId(userId);
    }

    @GetMapping("/{postId}")
        public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.createOnePost(postCreateRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updateOnePost(postId,postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePost(postId);
    }

}
