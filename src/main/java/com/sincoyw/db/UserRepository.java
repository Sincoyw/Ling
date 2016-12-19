package com.sincoyw.db;

import com.sincoyw.domain.UserInfo;

/**
 * Created by Sincoyw on 2016/8/17.
 * Desc:
 */
public interface UserRepository {
    public UserInfo save(UserInfo userInfo);
}
