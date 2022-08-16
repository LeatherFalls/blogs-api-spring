package com.viniciusgomes.restapispringmongodb.dto;

import com.viniciusgomes.restapispringmongodb.models.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }
}
