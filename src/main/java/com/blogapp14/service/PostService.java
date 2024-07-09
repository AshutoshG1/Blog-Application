package com.blogapp14.service;

import com.blogapp14.payload.ListPostDto;
import com.blogapp14.payload.PostDto;

public interface PostService {
    public PostDto createPost(PostDto postDto);

    void deletePost(long id);

    ListPostDto fetchAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    public PostDto getPostById(long id);
}
