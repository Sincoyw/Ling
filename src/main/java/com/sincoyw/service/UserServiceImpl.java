package com.sincoyw.service;

import com.sincoyw.db.UserRepository;
import com.sincoyw.domain.UserInfo;
import com.sincoyw.status.LoginResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

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
    private RedisTemplate<String, UserInfo> redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Override
    public UserInfo createNewAccount(
            String userId,
            String password,
            int accessLevel,
            String cellphone,
            Date lastVisitTime,
            String homeSite,
            String email) {

        UserInfo userInfo = new UserInfo();
        String saltRandom = RandomStringUtils.randomAlphanumeric(8);
        userInfo.setUserUUId(userId + saltFixed + saltRandom);
        userInfo.setUserId(userId);
        userInfo.setSaltFixed(saltFixed);
        userInfo.setSaltRandom(saltRandom);
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
        userInfo.setStatus(0);
        userInfo.setAccessLevel(accessLevel);
        userInfo.setCellphone(cellphone);
        userInfo.setLastVisitTime(new java.sql.Date(lastVisitTime.getTime()));
        userInfo.setHomeSite(homeSite);
        userInfo.setEmail(email);
        userRepository.save(userInfo);

        // push to redis cache.
        redisTemplate.opsForList().leftPush(userId, userInfo);

        inMemoryUserDetailsManager.createUser(User.withUsername(userId).password(resultPassword).roles("USER").build());

        return userInfo;
    }

    @Override
    public UserInfo findUserByEmail(String email) {
        if (redisTemplate.hasKey(email)) {
            return redisTemplate.opsForValue().get(email);
        } else {
            return userRepository.findByEmail(email);
        }
    }

    @Override
    public int loginWithUserIdPassword(String userId, String password) {
        UserInfo userInfo;
        if (redisTemplate.hasKey(userId)) {
            userInfo = redisTemplate.opsForValue().get(userId);
        } else {
            userInfo = userRepository.findByEmail(userId);
        }

        if (null == userInfo) {
            return LoginResult.NotExist;
        }

        String resultPassword = saltFixed + password + userInfo.getSaltRandom();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(resultPassword.getBytes());
            byte[] digestData = messageDigest.digest();
            resultPassword = new String(digestData);
        } catch (NoSuchAlgorithmException exception) {
            resultPassword = saltFixed + password + userInfo.getSaltRandom();
        }
        if (resultPassword.equals(userInfo.getPassword())) {

            inMemoryUserDetailsManager.createUser(User.withUsername(userId).password(resultPassword).roles("USER").build());

            return LoginResult.Success;
        } else {
            return LoginResult.PasswordError;
        }
    }
}
