package com.viniciusgomes.restapispringmongodb.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Data
@Document
public class User implements Serializable {
    @Id
    private String id;
    @NotBlank(message = "Field(name) cannot be empty")
    private String name;
    @NotBlank(message = "Field(email) cannot be empty")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    private String password;

    public User() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
