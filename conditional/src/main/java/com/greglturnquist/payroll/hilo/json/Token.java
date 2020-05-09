
package com.greglturnquist.payroll.hilo.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Token {

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private Long expiresIn;
    @SerializedName("id_token")
    private Object idToken;
    @SerializedName("not-before-policy")
    private Long notBeforePolicy;
    @SerializedName("refresh_expires_in")
    private Long refreshExpiresIn;
    @SerializedName("refresh_token")
    private String refreshToken;
    @Expose
    private String scope;
    @SerializedName("session_state")
    private String sessionState;
    @SerializedName("token_type")
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Object getIdToken() {
        return idToken;
    }

    public void setIdToken(Object idToken) {
        this.idToken = idToken;
    }

    public Long getNotBeforePolicy() {
        return notBeforePolicy;
    }

    public void setNotBeforePolicy(Long notBeforePolicy) {
        this.notBeforePolicy = notBeforePolicy;
    }

    public Long getRefreshExpiresIn() {
        return refreshExpiresIn;
    }

    public void setRefreshExpiresIn(Long refreshExpiresIn) {
        this.refreshExpiresIn = refreshExpiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSessionState() {
        return sessionState;
    }

    public void setSessionState(String sessionState) {
        this.sessionState = sessionState;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

}
