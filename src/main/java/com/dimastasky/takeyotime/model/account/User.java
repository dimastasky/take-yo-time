package com.dimastasky.takeyotime.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashSet;
import java.util.Set;

@Document(collection = "user")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String username;

    private String email;

    private String fullname;

    @JsonIgnore
    private String password;

    @DBRef(lazy = true)
    private Set<Role> roles = new HashSet<>();

    public User() {   }

    public User(String username, String email, String fullname, String password) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }
}
