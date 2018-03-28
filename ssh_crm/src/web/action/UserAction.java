package web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.UserService;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private UserService userService;

    public String login() throws Exception {
        // 1. 调用Service执行登录逻辑
        User u = userService.getUserByCodePassword(user);
        // 2. 将返回的User对象放入session域中
        ActionContext.getContext().getSession().put("user", u);
        // 3. 重定向到项目首页
        return "toHome";
    }

    public String regist() throws Exception {
        // 调用service保存注册用户
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            ActionContext.getContext().put("error", e.getMessage());
            return "regist";
        }
//        重定向到注册页面
        return "toLogin";
    }

    public void setUserService(UserService us) {
        this.userService = us;
    }

    @Override
    public User getModel() {
        return user;
    }
}
