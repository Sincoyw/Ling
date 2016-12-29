package com.sincoyw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Sincoyw on 2016/8/18.
 * Desc:
 */
@Entity
@Table(name = "t_ling_user")
public class UserInfo implements Serializable {
    @Column(name = "user_uuid", unique = true, nullable = false)
    @Id
    private String userUUId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "salt_fixed")
    private String saltFixed;

    @Column(name = "salt_random")
    private String saltRandom;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private int status;

    @Column(name = "access_level")
    private int accessLevel;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "last_visit_time")
    private Date lastVisitTime;

    @Column(name = "home_site")
    private String homeSite;

    @Column(name = "email")
    private String email;

    public String getUserUUId() {
        return userUUId;
    }

    public void setUserUUId(String userUUId) {
        this.userUUId = userUUId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSaltFixed() {
        return saltFixed;
    }

    public void setSaltFixed(String saltFixed) {
        this.saltFixed = saltFixed;
    }

    public String getSaltRandom() {
        return saltRandom;
    }

    public void setSaltRandom(String saltRandom) {
        this.saltRandom = saltRandom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public String getHomeSite() {
        return homeSite;
    }

    public void setHomeSite(String homeSite) {
        this.homeSite = homeSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
