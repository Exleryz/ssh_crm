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

import java.io.File;

public class CustomerAction extends ActionSupport implements ModelDriven<CstCustomerEntity>{

    private  CstCustomerEntity customer = new CstCustomerEntity();
    private CustomerService customerService;

    private File photo;    // 上传的文件会自动封装到File对象中
    // 在后台提供一个与前台input type file组件 name相同的属性

    private String photoFileName;    // 在提交的键名后加上固定后缀FileName，文件名会自动封装到属性中
    private String photoContentType;    // 文件的MIME类型值

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

    public String add() throws Exception {

        photo.renameTo(new File("E:/upload/haha.jpg"));

        // 调用service，保存Customer对象
        customerService.save(customer);
        // 重定向到客户列表

        return "toList";
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

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }
    @Override
    public CstCustomerEntity getModel() {
        return customer;
    }
}
