package com.blogapp14.payload;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostWithCommentDto {
    private PostDto post;
    private List<CommentDto> commentDto = new ArrayList<>();



    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }

    public List<CommentDto> getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(List<CommentDto> commentDto) {
        this.commentDto = commentDto;
    }
}
