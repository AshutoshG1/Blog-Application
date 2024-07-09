package com.blogapp14.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {

    private long id;
    @NotEmpty
    @Size(min=3,message = "Title should be atleast 3 character")
    private String title;

    @Size(min=3, message = "Description should be atleast 3 character")
    private String description;
    private String content;

    /*validating the email format
        @Email
        private String email;
    */
    /*validating the mobile
        @Size(min=10,max=10,message="Mobile number should be 10 digits")
        private String mobile;
    */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
