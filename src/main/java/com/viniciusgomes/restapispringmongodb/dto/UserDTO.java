package com.viniciusgomes.restapispringmongodb.dto;

import com.viniciusgomes.restapispringmongodb.models.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        password = obj.getPassword();
    }
}
