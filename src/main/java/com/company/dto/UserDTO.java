package com.company.dto;

import com.company.entity.Users;

public class UserDTO {
    private String username;
    private String password;
    private String userType;

    public UserDTO() {

    }

    public UserDTO(Users user) {
        this.username = user.getUsername();
        this.password=user.getPasswordhash();
        this.userType=user.getUsertype();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
