package services;

import models.User;

import java.util.HashMap;

public class UserService {
    private static UserService instance = null;
    private HashMap<String, User> useridtoUserhashmap;
    private UserService() {
        this.useridtoUserhashmap = new HashMap<>();
    }

    public static UserService getInstance()
    {
        if(instance == null)
        {
            instance = new UserService();
        }
        return instance;
    }

    public User createUser(String userid, String username)
    {
        User u = new User(userid, username);
        useridtoUserhashmap.put(userid, u);
        return u;
    }

    public HashMap<String, User> getUseridtoUserhashmap() {
        return useridtoUserhashmap;
    }
}