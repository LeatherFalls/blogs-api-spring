package com.viniciusgomes.restapispringmongodb.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommentDTO implements Serializable {
    private String content;
    private Date date;
    private AuthorDTO author;

    public CommentDTO() {}

    public CommentDTO(String content, Date date, AuthorDTO author) {
        super();
        this.content = content;
        this.date = date;
        this.author = author;
    }
}
