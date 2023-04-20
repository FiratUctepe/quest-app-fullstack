package com.project.questapp.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {
    String userName;
    String password;
    int avatar;
}
