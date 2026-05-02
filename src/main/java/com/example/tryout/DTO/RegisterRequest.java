package com.example.tryout.DTO;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nis;
    private String username;
    private String password;
    private String nama;
    private String kelas;
}
