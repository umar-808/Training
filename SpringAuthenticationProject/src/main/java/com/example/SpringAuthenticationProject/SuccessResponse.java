/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringAuthenticationProject;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author kalsym
 */
@JsonPropertyOrder({"access_token","token_type", "expires_in", "scope"})
public class SuccessResponse {

    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;

    public SuccessResponse(String access_token, String token_type, int expires_in, String scope) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.scope = scope;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
