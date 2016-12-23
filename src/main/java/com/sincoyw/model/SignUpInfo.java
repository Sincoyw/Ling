package com.sincoyw.model;

/**
 * Created by heaven on 16-12-22.
 */
public class SignUpInfo {
    private String email;
    private String password;
    private String cellphone;
    private String homeSite;

    //
    public String getEmail() {
        return this.email;
    }

    //
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getHomeSite() {
        return homeSite;
    }

    public void setHomeSite(String homeSite) {
        this.homeSite = homeSite;
    }
}
