package com.sincoyw.service;

import com.sincoyw.db.UserRepository;
import com.sincoyw.domain.UserInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

/**
 * Created by Sincoyw on 2016/8/18.
 * Desc:
 */
@Service
@ComponentScan("com.sincoyw")
public class UserServiceImpl implements UserService {

    /**
     * The fixed salt string for encryption.
     */
    private static final String saltFixed = "Ling";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo createNewAccount(
            String userId, String password, int accessLevel, String cellphone,
            Date lastVisitTime, String homeSite, String email) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        String saltRandom = RandomStringUtils.randomAlphanumeric(8);
        String resultPassword = saltFixed + password + saltRandom;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(resultPassword.getBytes());
            byte[] digestData = messageDigest.digest();
            resultPassword = new String(digestData);
        } catch (NoSuchAlgorithmException exception) {
            resultPassword = saltFixed + password + saltRandom;
        }
        userInfo.setPassword(resultPassword);
        userInfo.setAccessLevel(accessLevel);
        userInfo.setCellphone(cellphone);
        userInfo.setLastVisitTime(lastVisitTime);
        userInfo.setHomeSite(homeSite);
        userInfo.setEmail(email);
        userRepository.save(userInfo);
        return userInfo;
    }
}
