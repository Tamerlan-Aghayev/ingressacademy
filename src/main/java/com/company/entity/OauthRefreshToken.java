package com.company.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "oauth_refresh_token", schema = "public", catalog = "library")
public class OauthRefreshToken {
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "token_id")
    private String tokenId;
    @Basic
    @Column(name = "token")
    private byte[] token;
    @Basic
    @Column(name = "authentication")
    private byte[] authentication;

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

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OauthRefreshToken that = (OauthRefreshToken) o;
        return Objects.equals(tokenId, that.tokenId) && Arrays.equals(token, that.token) && Arrays.equals(authentication, that.authentication);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(tokenId);
        result = 31 * result + Arrays.hashCode(token);
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
