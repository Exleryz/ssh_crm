package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.SaleVisit;
import domain.User;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import service.SaleVisitService;
import utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

    private SaleVisit saleVisit = new SaleVisit();
    private SaleVisitService svs;

    private Integer currentPage;

    private Integer pageSize;

    public String list() throws Exception {
        System.out.println(pageSize);
        // 封装离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
        if (saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
            // 判断并封装参数
            dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
        }
        // 1. 调用service查询分页数据(PageBean)
        PageBean pb = svs.getPageBean(dc, currentPage, pageSize);
        // 2. 将PageBean放入request域，转发到列表页面
        ActionContext.getContext().put("pageBean", pb);
        return "list";
    }

    // 添加客户拜访记录
    public String add() throws Exception {
        // 取出登录用户
        User u = (User) ActionContext.getContext().getSession().get("user");
        saleVisit.setUser(u);
        System.out.println(saleVisit);
        // 1. 调用service保存客户拜访记录
        svs.save(saleVisit);
        // 2. 重定向
        return "toList";
    }

    public String toEdit() throws Exception {
        // 调用service根据id查询客户拜访对象
        SaleVisit sv = svs.getById(saleVisit.getVisit_id());
        ActionContext.getContext().put("saleVisit", sv);
        return "add";
    }

    public void setSvs(SaleVisitService svs) {
        this.svs = svs;
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
    public SaleVisit getModel() {
        return saleVisit;
    }
}
