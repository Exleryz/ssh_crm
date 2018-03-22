package service.impl;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao ud;

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
