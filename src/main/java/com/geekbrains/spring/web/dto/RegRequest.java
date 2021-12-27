package com.geekbrains.spring.web.dto;

import lombok.Data;

@Data
public class RegRequest {
    private String username;
    private String password;
    private String email;
}
