package com.blogapp14.controller;

import com.blogapp14.payload.ListPostDto;
import com.blogapp14.payload.PostDto;
import com.blogapp14.service.PostService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
//        if(postDto.getTitle().length()<3){
//            return new ResponseEntity<>("Title should be atleat 3 character", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/posts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post is deleted", HttpStatus.OK);
    }
    //http:localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=description&sortDir=asc
    @GetMapping
    public ResponseEntity<ListPostDto> fetchAllPosts(
            @RequestParam(name="pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(name="pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(name="sortBy" , defaultValue = "id" , required = false) String sortBy,
            @RequestParam(name="sortDir" , defaultValue = "asc" , required = false) String sortDir
    ){
        ListPostDto listPostDto = postService.fetchAllPosts(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(listPostDto, HttpStatus.OK);
    }
    //http:localhost:8080/api/posts?id=2
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}