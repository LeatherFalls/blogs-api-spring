package com.viniciusgomes.restapispringmongodb.models;

import com.viniciusgomes.restapispringmongodb.dto.AuthorDTO;
import com.viniciusgomes.restapispringmongodb.dto.CommentDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Data
@Document
public class Post implements Serializable {
    @Id
    private String id;
    @NotBlank
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private AuthorDTO author;

    private Set<CommentDTO> comments = new HashSet<>();

    public Post() {}

    public Post(String id, Date date, String title, String content, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
