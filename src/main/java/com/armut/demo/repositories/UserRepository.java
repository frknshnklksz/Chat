package com.armut.demo.repositories;

import com.armut.demo.models.User;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    String findByEmail(String email);
    JSONObject findByUserName(String userName);



}
