package com.cpe.springbootuser.model;

public class LoginForm {

    private String surname;
    private String password;

    public LoginForm() {

    }

    public LoginForm(String surname, String password) {
        this.surname = surname;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
