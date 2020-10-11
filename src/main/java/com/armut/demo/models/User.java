package com.armut.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "User")
public class User {

    @Id
    private String id;

    private String name;
    private String surname;
    private String email;
    private String userName;
    private String password;
    private StateOfUser state;

}
