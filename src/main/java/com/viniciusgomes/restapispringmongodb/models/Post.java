package com.viniciusgomes.restapispringmongodb.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    public Post() {}

    public Post(String id, Date date, String title, String content) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
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
