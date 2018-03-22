package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.CstCustomerEntity;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import service.CustomerService;
import utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<CstCustomerEntity>{

    private  CstCustomerEntity customer = new CstCustomerEntity();
    private CustomerService customerService;

    private Integer currentPage;

    private Integer pageSize;

    public String list() throws Exception {
        System.out.println(pageSize);
        // 封装离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(CstCustomerEntity.class);
        if (StringUtils.isNotBlank(customer.getCust_name())) {
            // 判断并封装参数
            dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }
        // 1. 调用service查询分页数据(PageBean)
        PageBean pb = customerService.getPageBean(dc, currentPage, pageSize);
        // 2. 将PageBean放入request域，转发到列表页面
        ActionContext.getContext().put("pageBean", pb);
        return "list";
    }

    public void setCustomerService(CustomerService cs) {
        this.customerService = cs;
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
    public CstCustomerEntity getModel() {
        return customer;
    }
}
