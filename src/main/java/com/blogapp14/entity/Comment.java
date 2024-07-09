package com.blogapp14.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String message;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return message;
    }

    public void setEmail(String email) {
        this.message = email;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
