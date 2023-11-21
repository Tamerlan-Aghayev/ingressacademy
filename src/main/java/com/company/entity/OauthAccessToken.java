package com.company.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "oauth_access_token", schema = "public", catalog = "library")
public class OauthAccessToken {
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "authentication_id")
    private String authenticationId;
    @Basic
    @Column(name = "token_id")
    private String tokenId;
    @Basic
    @Column(name = "token")
    private byte[] token;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "client_id")
    private String clientId;
    @Basic
    @Column(name = "authentication")
    private byte[] authentication;
    @Basic
    @Column(name = "refresh_token")
    private String refreshToken;

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OauthAccessToken that = (OauthAccessToken) o;
        return Objects.equals(authenticationId, that.authenticationId) && Objects.equals(tokenId, that.tokenId) && Arrays.equals(token, that.token) && Objects.equals(userName, that.userName) && Objects.equals(clientId, that.clientId) && Arrays.equals(authentication, that.authentication) && Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(authenticationId, tokenId, userName, clientId, refreshToken);
        result = 31 * result + Arrays.hashCode(token);
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
