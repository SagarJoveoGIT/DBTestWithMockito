package com.joveo.mock.dao;

import lombok.Getter;
import org.json.simple.JSONObject;

@Getter
public class UserRepositoryTestData {
    private User user;

    public UserRepositoryTestData(){
        this.user = new User();
        user.setName("Santosh");
        user.setAddress(new JSONObject());
    }
}
