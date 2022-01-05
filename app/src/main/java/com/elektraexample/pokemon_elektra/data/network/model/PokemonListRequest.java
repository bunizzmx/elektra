package com.elektraexample.pokemon_elektra.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonListRequest {

    @SerializedName("name_user")
    @Expose
    private String user;
    @SerializedName("password_user")
    @Expose
    private String password;
    @SerializedName("target")
    @Expose
    private String target;

    public PokemonListRequest() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApp() {
        return target;
    }

    public void setApp(String app) {
        this.target = app;
    }
}
