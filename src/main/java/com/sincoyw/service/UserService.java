package com.sincoyw.service;

import com.sincoyw.domain.UserInfo;

import java.sql.Date;

/**
 * Created by Sincoyw on 2016/8/18.
 * Desc:
 */
public interface UserService {
    //
    public UserInfo createNewAccount(
            String userId, String password, int accessLevel, String cellphone,
            Date lastVisitTime, String homeSite, String email);
}
