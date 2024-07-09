package com.blogapp14.service;

import com.blogapp14.payload.CommentDto;
import com.blogapp14.payload.PostWithCommentDto;



public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);
    public PostWithCommentDto getAllCommentsByPostId(long id);
}
