package com.example.apirestpostgreconcecionaria.security.payload;

public class JwtResponse {
//devuelve el token para la comunicacion
    private String token;

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
