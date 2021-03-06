package service.impl;

import dao.UserDao;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService{
    private UserDao ud;

    @Override
    public User getUserByCodePassword(User u) {
        // 1. 根据登录名称查询登录用户
        User existU = ud.getByUserCode(u.getUser_code());
        // 2. 判断用户是否存在，不存在=>抛出异常，提示用户名不存在
        if (existU == null) {
            throw new RuntimeException("用户名不存在!");
        }
        // 3. 判断用户名密码是否正确 => 不正确 => 抛出异常，提示密码错误
        if (!existU.getUser_password().equals(u.getUser_password())) {
            throw new RuntimeException("密码错误！");
        }

        // 4.
        return existU;
    }

    @Override
//    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
    public void saveUser(User u) {
        // 1. 调用dao根据注册的用户名获得用户对象
        User existU = ud.getByUserCode(u.getUser_code());
        if (existU != null) {
            // 2. hava User
            throw new RuntimeException("用户名已经存在");
        }
        ud.save(u);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
