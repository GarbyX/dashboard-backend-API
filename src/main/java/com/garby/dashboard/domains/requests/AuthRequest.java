package com.garby.dashboard.domains.requests;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private String role;    // GLOBAL_ADMIN, BANK_ADMIN, TELLER
}
