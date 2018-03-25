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

    private Integer currentPage;

    private Integer pageSize;

    public String list() throws Exception {
        System.out.println(pageSize);
        // 封装离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
        if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
            // 判断并封装参数
            dc.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
        }
        if (linkMan.getCustomer() != null) {
            dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
        }
        // 1. 调用service查询分页数据(PageBean)
        PageBean pb = linkManService.getPageBean(dc, currentPage, pageSize);
        // 2. 将PageBean放入request域，转发到列表页面
        ActionContext.getContext().put("pageBean", pb);
        return "list";
    }

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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }
}
