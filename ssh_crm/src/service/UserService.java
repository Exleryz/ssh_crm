package service;

import dao.BaseDao;
import domain.User;

public interface UserService{
    // 登录
    User getUserByCodePassword(User u);
    // 注册用户
    void saveUser(User u);
}
