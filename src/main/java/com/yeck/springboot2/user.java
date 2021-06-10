package com.yeck.springboot2;

public class user {
    private int _id;
    private String username;
    private String password;

    public user(int _id, String username, String password){
        this._id = _id;
        this.username = username;
        this.password = password;
    }

    public user(){
        super();
    }

    public int get_id() {
        return _id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString(){
        return "id=" + _id + ",username=" + username + ",password=" + password;
    }
}
