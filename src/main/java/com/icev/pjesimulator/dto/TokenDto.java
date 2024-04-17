package com.icev.pjesimulator.dto;

public class TokenDto {

    private String type;
    private String token;
    private String nomeUser;

    public TokenDto(String type, String token, String nomeUser) {
        this.type = type;
        this.token = token;
        this.nomeUser = nomeUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
}
