package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.CstCustomerEntity;
import domain.LinkMan;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import service.CustomerService;
import service.LinkManService;
import utils.PageBean;

import java.io.File;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan = new LinkMan();
    private LinkManService linkManService;

    public String add() throws Exception {
        // 1. 调用service
        linkManService.save(linkMan);
        // 2. 重定向到联系人列表
        return "toList";
    }

    public LinkManService getLinkManService() {
        return linkManService;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }
}
