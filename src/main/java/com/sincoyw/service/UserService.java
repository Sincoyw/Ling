package com.sincoyw.service;

import com.sincoyw.domain.UserInfo;

import java.util.Date;

/**
 * Created by Sincoyw on 2016/8/18.
 * Desc:
 */
public interface UserService {
    /**
     * Create a new Account.
     * @param userId
     * @param password
     * @param accessLevel
     * @param cellphone
     * @param lastVisitTime
     * @param homeSite
     * @param email
     * @return
     */
    public UserInfo createNewAccount(
            String userId,
            String password,
            int accessLevel,
            String cellphone,
            Date lastVisitTime,
            String homeSite,
            String email);

    public UserInfo findUserByEmail(String email);
}
