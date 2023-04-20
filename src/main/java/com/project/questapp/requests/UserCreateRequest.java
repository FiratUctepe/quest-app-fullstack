package com.project.questapp.requests;

import lombok.Data;

@Data
public class UserCreateRequest {
    String userName;
    String password;
    int avatar;
}
