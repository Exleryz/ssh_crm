package web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import domain.User;

import java.util.Map;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

    @Override    // 不校验登录和注册方法
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        // 1. 获得Session
        Map<String, Object> session = ActionContext.getContext().getSession();
        // 2. 获得登录标识
        User user = (User) session.get("user");
        // 3. 判断标识是否存在
        if (user != null) {
            // 存在=>放行
            return actionInvocation.invoke();
        } else {
            // 不存在 => 重定向到登录页面
            return "toLogin";
        }
    }
}
