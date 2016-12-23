package com.sincoyw.db;

import com.sincoyw.domain.UserInfo;

/**
 * Created by Sincoyw on 2016/8/17.
 * Desc:
 */
public interface UserRepository {
    /**
     * Save user info into database.
     * @param userInfo
     * @return
     */
    public UserInfo save(UserInfo userInfo);

    /**
     * Find user by email address.
     * @param email
     * @return
     */
    public UserInfo findByEmail(String email);
}
